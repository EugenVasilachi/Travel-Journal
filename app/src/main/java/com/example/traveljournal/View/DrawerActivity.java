package com.example.traveljournal.View;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.Model.TripViewModel;
import com.example.traveljournal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView number;
    private CheckBox bookmark;
    private TripViewModel tripViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        handleNavigationDrawer();
        handleFabButton();
        bookmark = findViewById(R.id.bookmark);
        tripViewModel = new ViewModelProvider(this).get(TripViewModel.class);
    }

    private void handleNavigationDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_about_us, R.id.nav_contact, R.id.fav_trips)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    private void handleFabButton() {
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(view -> Navigation.findNavController(this, R.id.nav_host_fragment_content_drawer).navigate(R.id.fab));
    }


    public void callEugen(View view) {
        number = findViewById(R.id.text_contact);
        String EugenNumber = number.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+ EugenNumber));
        startActivity(intent);
    }

    public void callRobert(View view) {
        number = findViewById(R.id.text_contact2);
        String RobertNumber = number.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+ RobertNumber));
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void addFavouriteTrip(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if(checked)
        {
            // add trip to favourite list
            ((CheckBox) view).setButtonDrawable(R.drawable.ic_baseline_favorite_24);
        }
        else
        {
            // delete trip from favourite list
            ((CheckBox) view).setButtonDrawable(R.drawable.ic_baseline_favorite_border_24);

        }
    }

    public void showDetails(View view) {
        TextView idText = view.findViewById(R.id.tripId);
        float id = Float.parseFloat(idText.getText().toString());
        int intId = (int)id;
        tripViewModel.getTrips().observe(DrawerActivity.this, trips -> {
            List<Trip> calatorii;
            calatorii = tripViewModel.getTrips().getValue();
            System.out.println(calatorii.size());
        });
    }
}