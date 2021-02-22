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


public class adapter_menu_maqalat extends RecyclerView.Adapter<adapter_menu_maqalat.MyViewHolder> {
    List<Item> itemList_maqalat;
    Context mContext_maqalat;
    public static boolean flag_maqalat=false;

    public adapter_menu_maqalat(List<Item>itemList_maqalat, Context mContext_maqalat){

        this.itemList_maqalat = itemList_maqalat;
        this.mContext_maqalat= mContext_maqalat;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu,parent,false);
        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aAvatar.setImageResource(itemList_maqalat.get(position).getuAvatar());
        holder.aName.setText(itemList_maqalat.get(position).getuName());
        holder.aReshte.setText(itemList_maqalat.get(position).getuReshte());
        holder.aPrice.setText(itemList_maqalat.get(position).getuPrice());

        holder.aAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_maqalat=true;
                Intent intent  = new Intent(mContext_maqalat, tozihat.class);
                intent.putExtra("book_name_ma",itemList_maqalat.get(position).getuName());
                intent.putExtra("image_avatar_ma",itemList_maqalat.get(position).getuAvatar());
                intent.putExtra("ostad_name_ma",itemList_maqalat.get(position).getuOstadName());
                intent.putExtra("book_price_ma",itemList_maqalat.get(position).getuPrice());
                intent.putExtra("reshte_ma",itemList_maqalat.get(position).getuReshte());
                intent.putExtra("uplode_ma",itemList_maqalat.get(position).getuUpload());
                intent.putExtra("daneshgah_ma",itemList_maqalat.get(position).getuDaneshgah());
                intent.putExtra("enteshar_ma",itemList_maqalat.get(position).getuEnteshar());
                intent.putExtra("tozihat_ma",itemList_maqalat.get(position).getuTozihat());
                mContext_maqalat.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return itemList_maqalat.size();
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