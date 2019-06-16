package com.jamarfal.androidcertification.ui.fruit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import com.jamarfal.androidcertification.R;
import com.jamarfal.androidcertification.ui.BaseActivity;

public class FruitListActivity extends BaseActivity {

  public static void startActivity(Context context) {
    Intent intent = new Intent(context, FruitListActivity.class);
    context.startActivity(intent);
  }

  private Toolbar toolbar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    toolbar = findViewById(R.id.toolbar );
    setFragment(FruitFragment.newInstance());
  }

  @Override
  protected Toolbar getToolbar() {
    return toolbar;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_fruit_list;
  }

  @Override
  protected int getContainerId() {
    return R.id.fruit_list__container__fragment;
  }
}
