package com.jamarfal.androidcertification.ui.fruit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import com.jamarfal.androidcertification.R;
import com.jamarfal.androidcertification.commons.Resource;
import com.jamarfal.androidcertification.repository.Fruit;
import com.jamarfal.androidcertification.repository.datasource.db.FruitEntityDbo;
import com.jamarfal.androidcertification.ui.BaseFragment;
import java.util.List;

public class FruitFragment extends BaseFragment {

  public static Fragment newInstance() {
    return new FruitFragment();
  }

  private FruitViewModel viewModel;

  private RecyclerView fruitRecycler;

  private ProgressBar fruitLoader;

  @Override
  protected int getLayoutRes() {
    return R.layout.fragment_fruit_list;
  }

  @Override
  protected void configureToolbar(Toolbar toolbar) {
    toolbar.setTitle("Listado de Frutas");
  }

  @Override
  protected void onViewCreated(View view) {
    fruitLoader = view.findViewById(R.id.paging_loader);
    fruitRecycler = view.findViewById(R.id.paging_list_fruit);
    fruitRecycler.setHasFixedSize(true);
    fruitRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    // fruitRecycler.setAdapter(new RecyclerAdapter());
    fruitRecycler.setAdapter(new FruitPagingAdapter());
    viewModel = ViewModelProviders.of(this).get(FruitViewModel.class);
    // viewModel.getFruits().observe(this, this::onFruitsReceived);
    viewModel.getFruitsPaginated().observe(this, this::onFruitsReceived);
    FloatingActionButton addButton = view.findViewById(R.id.paging_button_add);
    addButton.setOnClickListener(clickedView -> viewModel.add());
  }

  private void onFruitsReceived(PagedList<Fruit> response) {
    if (response != null) {
      if (fruitRecycler.getAdapter() instanceof FruitPagingAdapter) {
        ((FruitPagingAdapter) fruitRecycler.getAdapter()).submitList(response);
      }
    }
  }

  //private void onFruitsReceived(@Nullable Resource<List<Fruit>> response) {
  //
  //  if (response != null) {
  //    if (response.hasError()) {
  //      Snackbar.make(getActivity().findViewById(R.id.content), response.getMessage(), Snackbar.LENGTH_LONG);
  //    } else {
  //      if (fruitRecycler.getAdapter() instanceof RecyclerAdapter) {
  //
  //        ((RecyclerAdapter) fruitRecycler.getAdapter()).addData(response.getData() );
  //      }
  //    }
  //    showLoading(response.getStatus() == Resource.Status.LOADING);
  //  }
  //}

  public void showLoading(boolean shouldShow) {
    if (shouldShow) {
      fruitLoader.setVisibility(View.VISIBLE);
    } else {
      fruitLoader.setVisibility(View.GONE);
    }
  }
}
