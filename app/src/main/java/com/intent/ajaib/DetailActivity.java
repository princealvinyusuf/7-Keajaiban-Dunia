package com.intent.ajaib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    private Button kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        kembali = (Button)findViewById(R.id.btn_kembalis);
        kembali.setOnClickListener(this);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        Ajaib a = getIntent().getParcelableExtra("key");

        ImageView gambar = (ImageView)findViewById(R.id.img_item_photos);
        TextView name = (TextView)findViewById(R.id.names);
        TextView remarks = (TextView)findViewById(R.id.rema);
        TextView content = (TextView)findViewById(R.id.contents);
        TextView sistem = (TextView)findViewById(R.id.strukturs);
        TextView ukuran = (TextView)findViewById(R.id.ukurans);
        TextView arsitek = (TextView)findViewById(R.id.arsiteks);
        TextView lokasi = (TextView)findViewById(R.id.lokasis);

        Glide.with(this).load(a.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(gambar);
        name.setText(a.getName());
        remarks.setText(a.getRemarks());
        content.setText(a.getContent());
        sistem.setText(a.getSistem());
        ukuran.setText(a.getUkuran());
        arsitek.setText(a.getArsitek());
        lokasi.setText(a.getLokasi());

        Log.i("photo", a.getPhoto());
        Log.i("content", a.getContent());
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btn_kembalis){
            finish();
        }
    }

}
