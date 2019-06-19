package com.intent.ajaib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class UtamaActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Ajaib> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(AjaibData.getListData());

        tampilCardView();
        setActionBarTitle("7 Keajaiban Dunia");
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListAjaibAdapter listAjaibAdapter = new ListAjaibAdapter(this);
        listAjaibAdapter.setListAjaib(list);
        rvCategory.setAdapter(listAjaibAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedAjaib(list.get(position));
            }
        });

    }

    private void tampilRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridAndroidAdapter gridAndroidAdapter = new GridAndroidAdapter(this);
        gridAndroidAdapter.setListAjaib(list);
        rvCategory.setAdapter(gridAndroidAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedAjaib(list.get(position));
            }
        });

    }

    private void tampilCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewAjaibAdapter cardViewAjaibAdapter = new CardViewAjaibAdapter(this);
        cardViewAjaibAdapter.setListAjaib(list);
        rvCategory.setAdapter(cardViewAjaibAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String title = null;
        switch (item.getItemId()){
            case R.id.action_list:
                title="7 Keajaiban Dunia";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title="7 Keajaiban Dunia";
                tampilRecyclerGrid();
                break;
            case R.id.action_cardview:
                title="7 Keajaiban Dunia";
                tampilCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showSelectedAjaib(Ajaib ajaib){
        Toast.makeText(this, "Ini adalah "+ajaib.getName(), Toast.LENGTH_SHORT).show();
    }
}
