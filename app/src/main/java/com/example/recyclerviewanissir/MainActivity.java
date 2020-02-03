package com.example.recyclerviewanissir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    String[] countryNames,countryDesc;
    int[] countryImages={R.drawable.belgium,R.drawable.england,R.drawable.germany,R.drawable.india,
            R.drawable.netherlands,R.drawable.portugal,R.drawable.spain,R.drawable.united_states};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView=findViewById(R.id.recyclerViewId);
        countryNames=getResources().getStringArray(R.array.country_name);
        countryDesc=getResources().getStringArray(R.array.country_desc);

        MyAdapter myAdapter=new MyAdapter(this,countryNames,countryDesc,countryImages);
        recycleView.setAdapter(myAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, "onitemClick : "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View view) {
                Toast.makeText(MainActivity.this, "onItemLongClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
