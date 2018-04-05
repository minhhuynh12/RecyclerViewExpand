package com.example.astro.recyclerviewexpand.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.astro.recyclerviewexpand.Model.MainDataItems;
import com.example.astro.recyclerviewexpand.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitinhHienAnh on 04-04-18.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    List<MainDataItems> list;
    Context context;
    public MainActivityAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();
    }

    public void setData(List<MainDataItems> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_items, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvFirstName.setText(list.get(position).getFirstName());
        holder.tvLastName.setText(list.get(position).getLastName());
        holder.tvAge.setText(list.get(position).getAge());
//        String url = list.get(position).getImage();
        Picasso.get().load("http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png").placeholder(R.drawable.big_data).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName;
        TextView tvLastName;
        TextView tvAge;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvAge = itemView.findViewById(R.id.tvAge);
            img = itemView.findViewById(R.id.img);
        }
    }
}
