package com.jamarfal.androidcertification.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jamarfal.androidcertification.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

  public BaseFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutRes(), container, false);

    FragmentActivity activity = getActivity();
    if (activity instanceof BaseActivity) {
      Toolbar toolbar = ((BaseActivity) activity).getToolbar();
      if (toolbar != null) {
        configureToolbar(toolbar);
      }

      onViewCreated(view);
    }
    return view;
  }

  protected abstract @LayoutRes
  int getLayoutRes();

  protected abstract void configureToolbar(Toolbar toolbar);

  protected abstract void onViewCreated(View view);
}
