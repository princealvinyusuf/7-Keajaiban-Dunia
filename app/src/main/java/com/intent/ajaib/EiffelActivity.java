package com.intent.ajaib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EiffelActivity extends AppCompatActivity implements View.OnClickListener{
    private Button kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eiffel);

        getSupportActionBar().setTitle("Menara Eiffel");

        kembali = (Button)findViewById(R.id.btn_kembali);
        kembali.setOnClickListener(this);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btn_kembali){
            finish();
        }
    }

}
