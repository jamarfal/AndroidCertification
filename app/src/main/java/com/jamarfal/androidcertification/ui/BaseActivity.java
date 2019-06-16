package com.jamarfal.androidcertification.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
  }

  public void setFragment(Fragment fragment) {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(getContainerId(), fragment);
    ft.addToBackStack(null);
    ft.commit();
  }

  protected abstract Toolbar getToolbar();

  protected abstract int getLayoutId();

  protected abstract int getContainerId();
}
