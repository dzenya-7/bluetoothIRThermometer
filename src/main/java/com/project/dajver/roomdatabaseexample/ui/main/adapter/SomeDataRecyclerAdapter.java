package com.project.dajver.roomdatabaseexample.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.project.dajver.roomdatabaseexample.R;
import com.project.dajver.roomdatabaseexample.DBActivity;
import com.project.dajver.roomdatabaseexample.db.model.DataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SomeDataRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<DataModel> dataModels = new ArrayList<>();
    private OnDeleteListener onDeleteListener;
    private Context context;

    public SomeDataRecyclerAdapter(Context context, List<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_some_data, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final NewsViewHolder viewHolder = (NewsViewHolder) holder;
        viewHolder.date.setText(dataModels.get(position).date);
        viewHolder.name.setText(dataModels.get(position).name);
        viewHolder.lastName.setText(dataModels.get(position).lastName);
        viewHolder.dadName.setText(dataModels.get(position).dadName);
        viewHolder.temp.setText(Double.toString(dataModels.get(position).temperature));
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.temp)
        public TextView temp;
        @BindView(R.id.name)
        public TextView name;
        @BindView(R.id.lastName)
        public TextView lastName;
        @BindView(R.id.dadName)
        public TextView dadName;
        @BindView(R.id.date)
        public TextView date;
        @BindView(R.id.delete) TextView delete;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            delete.setOnClickListener(view -> {
                onDeleteListener.onDelete(dataModels.get(getAdapterPosition()));
                dataModels.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
            });
        }
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    public interface OnDeleteListener {
        void onDelete(DataModel dataModel);
    }
}