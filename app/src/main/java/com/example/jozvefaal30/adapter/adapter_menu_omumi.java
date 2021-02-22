package com.example.jozvefaal30.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jozvefaal30.R;
import com.example.jozvefaal30.model.Item;
import com.example.jozvefaal30.tozihat;

import java.util.List;


public class adapter_menu_omumi extends RecyclerView.Adapter<adapter_menu_omumi.MyViewHolder> {
    List<Item> itemList;
    Context mContext;
    public static boolean flag_omumi=false;

    public adapter_menu_omumi(List<Item>itemList, Context mContext){
        this.itemList = itemList;
        this.mContext= mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu,parent,false);
        return new MyViewHolder(aView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aAvatar.setImageResource(itemList.get(position).getuAvatar());
        holder.aName.setText(itemList.get(position).getuName());
        holder.aReshte.setText(itemList.get(position).getuReshte());
        holder.aPrice.setText(itemList.get(position).getuPrice());

        holder.aAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_omumi=true;
                Intent intent  = new Intent(mContext, tozihat.class);
                intent.putExtra("book_name",itemList.get(position).getuName());
                intent.putExtra("image_avatar",itemList.get(position).getuAvatar());
                intent.putExtra("ostad_name",itemList.get(position).getuOstadName());
                intent.putExtra("book_price",itemList.get(position).getuPrice());
                intent.putExtra("reshte",itemList.get(position).getuReshte());
                intent.putExtra("uplode",itemList.get(position).getuUpload());
                intent.putExtra("daneshgah",itemList.get(position).getuDaneshgah());
                intent.putExtra("enteshar",itemList.get(position).getuEnteshar());
                intent.putExtra("tozihat",itemList.get(position).getuTozihat());
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar;
        public TextView aName;
        public TextView aReshte;
        public TextView aPrice;
        public TextView aUplade;
        public TextView aDaneshgah;
        public TextView aEnteshar;
        public TextView aTozihat;
        public TextView aOstadname;


        public MyViewHolder(View itemView) {
            super(itemView);

            aAvatar = itemView.findViewById(R.id.img_avatar);
            aName = itemView.findViewById(R.id.book_name);
            aReshte = itemView.findViewById(R.id.reshte);
            aPrice = itemView.findViewById(R.id.book_price);


        }
    }

}