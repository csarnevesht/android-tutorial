package com.example.androidtutorial;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrophyAdapter adapter;
    private ArrayList<Trophy> trophyArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // - set recyclerview layout manager
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trophyArrayList = new ArrayList<>();
        adapter = new TrophyAdapter(this, trophyArrayList);
        // set adapter for recyclerview
        recyclerView.setAdapter(adapter);
        // - fill data for recyclerview items
        createListData();
    }

    // - create data and notify adapter
    private void createListData() {
        Trophy trophy;
        trophy = new Trophy("Baseball - Arman Rafati - 2018", "Epic year for MVP player Arman Rafati ... ");
        trophyArrayList.add(trophy);
        trophy = new Trophy("Tennis - Shay Sarn - 2019", "Fabulous game!");
        trophyArrayList.add(trophy);
        trophy = new Trophy("Soccer - Johnny Bee - 2018", "Another fabulous game!");
        trophyArrayList.add(trophy);
        adapter.notifyDataSetChanged();
    }
}
