package com.jamarfal.androidcertification.commons;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import org.w3c.dom.Text;

public class Resource<T> {

  public enum Status {
    SUCCESS,
    ERROR,
    LOADING
  }

  private Status status;
  private T data;
  private String message;

  public Resource(Status status, T data, String message) {
    this.status = status;
    this.data = data;
    this.message = message;
  }

  public Status getStatus() {
    return status;
  }

  public T getData() {
    return data;
  }

  public String getMessage() {
    return message;
  }

  public boolean hasError(){
    return !TextUtils.isEmpty(message);
  }

  public static <T> Resource<T> success(T data) {
    return new Resource<>(Status.SUCCESS, data, null);
  }

  public static <T> Resource<T> error(@NonNull String message, @Nullable T data) {
    return new Resource<>(Status.ERROR, data, message);
  }

  public static <T> Resource<T> loading(@Nullable T data) {
    return new Resource<>(Status.LOADING, data, null);
  }
}


