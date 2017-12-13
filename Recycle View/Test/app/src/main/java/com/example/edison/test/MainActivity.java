package com.example.edison.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;





    int[] country = {R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac };
    int[] capital = {R.raw.gat,R.raw.gat,R.raw.gat,R.raw.gat,R.raw.gat,R.raw.gat,R.raw.gat,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac,R.raw.cac};



  /*  String[] country = {"India", "Japan", "Kazakhstan", "Greece", "Columbia", "Canada", "Austria", "France", "Jamaica"
            ,"Kenya", "Libya", "Kuwait", "Jordan", "Switzerland", "Philippines", "Pakistan" };
    String[] capital = {"New Delhi", "Tokyo", "Astana", "Athens","Bogota", "Ottawa", "Vienna", "Paris",
            "Kingston", "Nairobi", "Tripoli", "Kuwait City", "Arman", "Bern", "Manila", "Islamabad"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(country, capital);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
