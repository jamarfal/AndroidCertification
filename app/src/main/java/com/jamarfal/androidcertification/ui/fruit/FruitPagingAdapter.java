package com.jamarfal.androidcertification.ui.fruit;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jamarfal.androidcertification.R;
import com.jamarfal.androidcertification.repository.Fruit;

public class FruitPagingAdapter extends PagedListAdapter<Fruit, FruitPagingAdapter.FruitViewHolder> {

  protected FruitPagingAdapter() {
    super(DIFF_CALLBACK);
  }

  @NonNull
  @Override
  public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recycler_data, viewGroup, false);
    return new FruitViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
    Fruit fruit = getItem(position);
    if (fruit != null) {
      holder.nameLabel.setText(fruit.getItem());
      holder.dateLabel.setText(fruit.getCategory());
    } else {
      // Null defines a placeholder item - PagedListAdapter automatically
      // invalidates this row when the actual object is loaded from the
      // database.
    }
  }

  static class FruitViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameLabel;
    private final TextView dateLabel;

    public FruitViewHolder(@NonNull View itemView) {

      super(itemView);
      nameLabel = itemView.findViewById(R.id.row_label_name);
      dateLabel = itemView.findViewById(R.id.row_label_date);
    }
  }

  private static DiffUtil.ItemCallback<Fruit> DIFF_CALLBACK =
      new DiffUtil.ItemCallback<Fruit>() {
        // Fruit details may have changed if reloaded from the database,
        // but ID is fixed.
        @Override
        public boolean areItemsTheSame(Fruit oldFruit, Fruit newFruit) {
          return oldFruit.getId() == newFruit.getId();
        }

        @Override
        public boolean areContentsTheSame(Fruit oldFruit,
            Fruit newFruit) {
          return oldFruit.equals(newFruit);
        }
      };
}
