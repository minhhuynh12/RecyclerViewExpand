package com.example.astro.recyclerviewexpand.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.astro.recyclerviewexpand.Model.IsExpandItems;
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
    List<IsExpandItems> listIsexpand;
    Context context;
    int pos;
    public MainActivityAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();
        if(listIsexpand == null){
            listIsexpand = new ArrayList<>();
        }
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final MainDataItems items = list.get(position);
        pos = position;
        list.set(position, items).setPosition(position);

        holder.tvFirstName.setText(list.get(position).getFirstName());
        holder.tvLastName.setText(list.get(position).getLastName());
        holder.tvAge.setText(list.get(position).getAge());

        IsExpandItems isExpandItems =  new IsExpandItems(pos);

        for (IsExpandItems isExpandItems_ : listIsexpand ) {
            if (isExpandItems_.getPosition() == items.getPosition() ){
                isExpandItems = isExpandItems_;
                break;
            }
        }

        if (isExpandItems.isExpand == true){
            holder.tvLastName.setVisibility(View.VISIBLE);
            holder.tvAge.setVisibility(View.VISIBLE);
            holder.linearBtn.setVisibility(View.VISIBLE);
        }else {
            holder.tvLastName.setVisibility(View.GONE);
            holder.tvAge.setVisibility(View.GONE);
            holder.linearBtn.setVisibility(View.GONE);
        }

        holder.relativefirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = indexInList(position);
                if(index > -1){
                    listIsexpand.get(index).isExpand = !listIsexpand.get(index).isExpand;
                }else {
                    IsExpandItems isExpandItems= new IsExpandItems(position);
                    isExpandItems.isExpand = true;
                    listIsexpand.add(isExpandItems);
                }
                notifyItemChanged(position);
            }
        });

//        String url = list.get(position).getImage();
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").placeholder(R.drawable.big_data).into(holder.img);
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
        RelativeLayout relativefirstName;
        LinearLayout linearBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvAge = itemView.findViewById(R.id.tvAge);
            img = itemView.findViewById(R.id.img);
            relativefirstName = itemView.findViewById(R.id.relativefirstName);
            linearBtn = itemView.findViewById(R.id.linearBtn);
        }
    }

//    private int indexInList(int postion){
//        for (int i = 0; i < listIsexpand.size() ; i++ ){
//            if (listIsexpand.get(i).getId() == postion){
//                return i;
//            }
//        }
        private int indexInList(int postion){
        for (int i = 0; i < listIsexpand.size() ; i++ ){
//            if (listIsexpand.get(i).getFirstName().equals(firstName) == true){
//                return i;
//            }
            if (listIsexpand.get(i).getPosition() == postion){
                return i;
            }

        }

        return -1;
    }


}
