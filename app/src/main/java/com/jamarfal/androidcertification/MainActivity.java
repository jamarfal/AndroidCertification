package com.jamarfal.androidcertification;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

    ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
        this,
        drawerLayout,
        toolbar,
        R.string.navigation_drawer_open,
        R.string.navigation_drawer_close);

    if (drawerLayout != null) {
      drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }
    actionBarDrawerToggle.syncState();

    NavigationView navigationView = findViewById(R.id.navigation_view);
    if (navigationView != null) {
      navigationView.setNavigationItemSelectedListener(this);
    }
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    if (menuItem.getItemId() == R.id.nav_battery_level) {
      BatteryLevelActivity.startActivity(this);
      return true;
    }
    return false;
  }
}
