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

public class MainActivity extends AppCompatActivity {

    private MaterialSearchBar searchBar;

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

        searchBar = findViewById(R.id.searchBar);

        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("LOG_TAG", getClass().getSimpleName() + " text changed " + searchBar.getText());
                doSearch(searchBar.getText());

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("LOG_TAG", getClass().getSimpleName() + " after text changed " + searchBar.getText());
                doSearch(searchBar.getText());

            }

        });

        searchBar.enableSearch();

    }

    // - set data to adapter and notify data
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

    // search data
    private void doSearch(String searchText) {
        Log.d("LOG_TAG", getClass().getSimpleName() + " doSearch " + searchBar.getText());

        adapter.getFilter().filter(searchText);

    }
}
