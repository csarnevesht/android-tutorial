package com.example.androidtutorial;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class TrophiesActivity extends AppCompatActivity {
    private static final String TAG = "TrophiesActivity";

    private MaterialSearchBar searchBar;

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

        searchBar = findViewById(R.id.searchBar);

        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG, "onTextChanged: " + searchBar.getText());
                doSearch(searchBar.getText());

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(TAG, "afterTextChanged: " + searchBar.getText());
                doSearch(searchBar.getText());

            }

        });

        searchBar.enableSearch();

    }

    // - create data and notify data
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

    // search data
    private void doSearch(String searchText) {
        Log.d(TAG, "doSearch: " + searchBar.getText());

        adapter.getFilter().filter(searchText);

    }
}
