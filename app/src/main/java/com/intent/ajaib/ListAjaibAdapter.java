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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Locale;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ListAjaibAdapter extends RecyclerView.Adapter<ListAjaibAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Ajaib> listAjaib;
    private Activity activity;

    ArrayList<Ajaib> getListAjaib() {
        return listAjaib;
    }

    void setListAjaib(ArrayList<Ajaib> listAjaib) {
        this.listAjaib = listAjaib;
    }

    ListAjaibAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_ajaib, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Ajaib a = getListAjaib().get(position);

        holder.tvName.setText(getListAjaib().get(position).getName());
        holder.tvRemarks.setText(getListAjaib().get(position).getRemarks());
        holder.ajaib = a;

        Glide.with(context)
                .load(getListAjaib().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .transition(withCrossFade())
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListAjaib().size();
    }

    public void startactivity(Intent intent) {

    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Ajaib ajaib;

        public CategoryViewHolder(View v) {
            super(v);
            imgPhoto = (ImageView) v.findViewById(R.id.img_item_photo);
            imgPhoto.setOnClickListener(this);
            tvName = (TextView) v.findViewById(R.id.tv_item_name);
            tvName.setOnClickListener(this);
            tvRemarks = (TextView) v.findViewById(R.id.tv_item_remarks);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("key", ajaib);
            context.startActivity(intent);
        }
    }
}