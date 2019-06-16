package com.jamarfal.androidcertification.ui.fruit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jamarfal.androidcertification.R;
import com.jamarfal.androidcertification.repository.Fruit;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Fruit> bunchOfFruits;

    public RecyclerAdapter() {

        this.bunchOfFruits = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recycler_data, viewGroup, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Fruit fruit = bunchOfFruits.get(position);
        viewHolder.nameLabel.setText(fruit.getItem());
        viewHolder.dateLabel.setText(fruit.getCategory());

    }

    @Override
    public int getItemCount() {

        return bunchOfFruits != null ? bunchOfFruits.size() : 0;

    }

    public void addData(List<Fruit> fruitBoList) {

        //if (fruitBoList == null || fruitBoList.isEmpty()) {
        //    return;
        //}
        //
        //int indexStart = this.bunchOfFruits.size();
        //int indexEnd = indexStart + (fruitBoList.size() - indexStart);
        this.bunchOfFruits = fruitBoList;
        // notifyItemRangeInserted(indexStart, indexEnd);
        notifyDataSetChanged();

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameLabel;
        private final TextView dateLabel;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            nameLabel = itemView.findViewById(R.id.row_label_name);
            dateLabel = itemView.findViewById(R.id.row_label_date);

        }
    }
}
