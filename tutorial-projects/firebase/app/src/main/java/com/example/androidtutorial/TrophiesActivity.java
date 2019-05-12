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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

public class TrophiesActivity extends AppCompatActivity {
    private static final String TAG = "TrophiesActivity";
    private MaterialSearchBar searchBar;

    LinearLayoutManager mLayoutManager;
    private RecyclerView recyclerView;
    private TrophyAdapter adapter;
    private ArrayList<Trophy> trophies;

    FirebaseFirestore mFirebaseDatabase;
    CollectionReference mRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create trophies_activity layout object
        setContentView(R.layout.trophies_activity);

        // access a Cloud Firestore instance from your Activity
        mFirebaseDatabase = FirebaseFirestore.getInstance();
        mRef = mFirebaseDatabase.collection("Data");

        mLayoutManager = new GridLayoutManager(this, 3);

        // set recyclerview layout manager
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //set layout as LinearLayout
        recyclerView.setLayoutManager(mLayoutManager);
        trophies = new ArrayList<>();
        // no longer needed since we are getting the items from FirestoreRecyclerAdapter
//        // - fill data for recyclerview items
//        createTrophyData();

    }

    //load data into recycler view onStart
    @Override
    protected void onStart() {
        super.onStart();

        FirestoreRecyclerOptions<Trophy> options = new FirestoreRecyclerOptions.Builder<Trophy>()
                .setQuery(mRef, Trophy.class)
                .build();

        adapter = new TrophyAdapter(options,this);
        // set adapter for recyclerview
        recyclerView.setAdapter(adapter);
        // CLOUD FIRESTORE
        // start listening for recyclerview items from firestore
        adapter.startListening();
    }

//    // - set data to adapter and notify data
//    private void createTrophyData() {
//        Trophy trophy;
//        trophy = new Trophy("Baseball - Arman Rafati - 2018", "Epic year for MVP player Arman Rafati ... ");
//        trophies.add(trophy);
//        trophy = new Trophy("Tennis - Shay Sarn - 2019", "Fabulous game!");
//        trophies.add(trophy);
//        trophy = new Trophy("Soccer - Johnny Bee - 2018", "Another fabulous game!");
//        trophies.add(trophy);
//        adapter.notifyDataSetChanged();
//    }

    // search data
    private void doSearch(String searchText) {
        Log.d(TAG, "doSearch: "  + searchBar.getText());
        //convert string entered in SearchView to lowercase
        String query = searchText.toLowerCase();
        Query firebaseSearchQuery = mRef.whereArrayContains("search", query);
        FirestoreRecyclerOptions<Trophy> options = new FirestoreRecyclerOptions.Builder<Trophy>()
                .setQuery(query.isEmpty() ?  mRef : firebaseSearchQuery, Trophy.class)
                .build();
        adapter = new TrophyAdapter(options,this);
        // set adapter for recyclerview
        recyclerView.setAdapter(adapter);
        // CLOUD FIRESTORE
        // start listening for recyclerview items from firestore
        adapter.startListening();
        // no longer needed since FirestoreRecyclerAdapter is already doing the filtering
//        adapter.getFilter().filter(searchText);
    }
}
