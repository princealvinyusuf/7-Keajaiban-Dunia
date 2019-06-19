package com.intent.ajaib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAndroidAdapter extends RecyclerView.Adapter<GridAndroidAdapter.GridViewHolder>{
    private Context context;
    private ArrayList<Ajaib> listAjaib;
    private Activity activity;

    private ArrayList<Ajaib> getListAjaib() {
        return listAjaib;
    }

    void setListAjaib(ArrayList<Ajaib> listAjaib) {
        this.listAjaib = listAjaib;
    }

    GridAndroidAdapter(Context context){
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_ajaib, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position){
        Ajaib a = getListAjaib().get(position);
        holder.ajaib = a;

        Glide.with(context)
                .load(getListAjaib().get(position).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount(){
        return getListAjaib().size();
    }


    public void startactivity(Intent intent){

    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        Ajaib ajaib;

        GridViewHolder(View itemView){
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            imgPhoto.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("key", ajaib);
            context.startActivity(intent);
        }
    }
}
