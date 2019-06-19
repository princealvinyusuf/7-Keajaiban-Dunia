package com.intent.ajaib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewAjaibAdapter extends RecyclerView.Adapter<CardViewAjaibAdapter.CardViewViewHolder> {
    private ArrayList<Ajaib> listAjaib;
    private Context context;
    private Activity activity;


    private ArrayList<Ajaib> getListAjaib() {
        return listAjaib;
    }

    void setListAjaib(ArrayList<Ajaib> listAjaib) {
        this.listAjaib = listAjaib;
    }

    CardViewAjaibAdapter(Context context){
        this.context = context;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_ajaib, parent, false);
        return new CardViewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position){
        Ajaib a = getListAjaib().get(position);

        Glide.with(context)
                .load(a.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(a.getName());
        holder.tvRemarks.setText(a.getRemarks());
        holder.ajaib = a;
//
//        holder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback(){
//
//            @Override
//            public void onItemClicked(View v, int position){
//                Toast.makeText(context, "Detail "+getListAjaib().get(position).getName(), Toast.LENGTH_SHORT).show();
//            }
//        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback(){
            @Override
            public void onItemClicked (View v, int position){
                Toast.makeText(context, "Share "+getListAjaib().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount(){
        return getListAjaib().size();
    }

    public void startactivity(Intent intent){

    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnDetail, btnShare;
        Ajaib ajaib;

        public CardViewViewHolder (View v){
            super (v);
            imgPhoto = (ImageView)v.findViewById(R.id.img_item_photo);
            imgPhoto.setOnClickListener(this);
            tvName = (TextView)v.findViewById(R.id.tv_item_name);
            tvName.setOnClickListener(this);
            tvRemarks = (TextView)v.findViewById(R.id.tv_item_remarks);
            btnDetail = (Button)v.findViewById(R.id.btn_set_detail);
            btnDetail.setOnClickListener(this);
            btnShare = (Button)v.findViewById(R.id.btn_set_share);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("key", ajaib);
            context.startActivity(intent);
        }
    }

}
