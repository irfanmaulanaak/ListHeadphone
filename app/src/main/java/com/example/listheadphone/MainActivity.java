package com.example.listheadphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeadphone;
    private ArrayList<Headphone> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeadphone = findViewById(R.id.rv_headphone);
        rvHeadphone.setHasFixedSize(true);

        list.addAll(HeadphoneData.getListData());
        showRecyclerHome();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_about:
                showAbout();
                break;
            case R.id.action_exit:
                System.exit(1);
                break;
        }
    }
    private void showAbout(){
        Intent aboutintent = new Intent(this,About.class);
        startActivity(aboutintent);
    }

    private void showRecyclerHome() {
        rvHeadphone.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvHeadphone.setAdapter(listAdapter);
        listAdapter.setOnItemClickCallback(new ListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Headphone data) {
                showSelectedHeadphone(data);
            }
        });
    }
    private void showSelectedHeadphone(Headphone headphone) {
        Toast.makeText(this, "Kamu memilih " + headphone.getNama(), Toast.LENGTH_SHORT).show();
        Intent moveIntent = new Intent(this,DetailActivity.class);
        moveIntent.putExtra(DetailActivity.EXTRA_NAMA, headphone.getNama());
        moveIntent.putExtra(DetailActivity.EXTRA_INFO,headphone.getInfo());
        moveIntent.putExtra(DetailActivity.EXTRA_PHOTO,headphone.getPhoto());
        startActivity(moveIntent);
    }
}
