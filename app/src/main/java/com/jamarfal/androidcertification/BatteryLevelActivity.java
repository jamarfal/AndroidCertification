package com.jamarfal.androidcertification;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BatteryLevelActivity extends AppCompatActivity {

  public static void startActivity(Context context) {
    Intent intent = new Intent(context, BatteryLevelActivity.class);
    context.startActivity(intent);
  }

  private ImageView batteryLevelImageView;
  private Button addChargeBtn;
  private Button removeChargeBtn;
  private LevelListDrawable batteryLevelDrawable;

  private final View.OnClickListener addChargeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      currentLevel++;

      if (currentLevel >= fullBatteryLvl) {
        currentLevel = fullBatteryLvl;
      }

      batteryLevelImageView.setImageLevel(currentLevel);
    }
  };

  private final View.OnClickListener removeChargeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      currentLevel--;

      if (currentLevel <= lowBatteryLvl) {
        currentLevel = lowBatteryLvl;
      }

      batteryLevelImageView.setImageLevel(currentLevel);
    }
  };

  private int lowBatteryLvl;
  private int fullBatteryLvl;
  private int currentLevel = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_battery_level);

    lowBatteryLvl = getResources().getInteger(R.integer.battery_empty);
    fullBatteryLvl = getResources().getInteger(R.integer.battery_full);

    bindWidgets();

    setupOnClickListeners();
  }

  //region PRIVATE METHODS
  private void bindWidgets() {
    batteryLevelImageView = findViewById(R.id.battery_level__img);
    addChargeBtn = findViewById(R.id.battery_level__btn__plus);
    removeChargeBtn = findViewById(R.id.battery_level__btn__minus);
  }

  private void setupOnClickListeners() {
    addChargeBtn.setOnClickListener(addChargeClickListener);
    removeChargeBtn.setOnClickListener(removeChargeClickListener);
  }
  //endregion
}
