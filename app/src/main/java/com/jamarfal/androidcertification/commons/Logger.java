package com.jamarfal.androidcertification.commons;

import android.util.Log;
import com.jamarfal.androidcertification.MyApplication;

public class Logger {

  public static void logInfo(String tag, String message) {
    Log.i(tag, message);
  }

  public static void logError(String message) {
    logError(MyApplication.class.getName(), message);
  }

  public static void logError(String tag, String message) {
    Log.i(tag, message);
  }
}
