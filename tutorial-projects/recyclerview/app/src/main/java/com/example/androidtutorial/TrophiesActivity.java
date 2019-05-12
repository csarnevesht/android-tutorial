package com.example.androidtutorial;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrophiesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrophyAdapter adapter;
    private ArrayList<Trophy> trophies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create trophies_activity layout object
        setContentView(R.layout.trophies_activity);

        // set recyclerview layout manager
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        trophies = new ArrayList<>();
        adapter = new TrophyAdapter(this, trophies);

        // set adapter for recyclerview
        recyclerView.setAdapter(adapter);

        // create data and notify adapter
        createTrophyData();
    }

    // create data and notify adapter
    private void createTrophyData() {
        Trophy trophy;
        trophy = new Trophy("Baseball - Arman Rafati - 2018", "This was an epic year for MVP player Arman Rafati.  He conquered the field with his quick legs.  Congratulations for a game well played by Arman and his mates ... ");
        trophies.add(trophy);
        trophy = new Trophy("Tennis - Shay Sarn - 2019", "Fabulous game! Shay is a lefty who has strengthened his game throughout the year. He has achieved a level of mastery and perfection.  Great job!");
        trophies.add(trophy);
        trophy = new Trophy("Soccer - Johnny Bee - 2018", "Another fabulous game with Johnny Bee. Johnny has legs of steel!  Go Mr. Bee!");
        trophies.add(trophy);
        trophy = new Trophy("Swimming - Anthony Lao - 2017", "Don't let Anthony fool you because he is a sophomore.  He has strong arms and legs and he will not be defated. Good job Mr. Lao!");
        trophies.add(trophy);
        adapter.notifyDataSetChanged();
    }
}
