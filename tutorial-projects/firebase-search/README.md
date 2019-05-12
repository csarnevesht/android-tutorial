# Android Tutorial

*******************************************************************************************************************
# Create new branch 'firebase-search'
*******************************************************************************************************************

We will be using **MaterialSearchbar** from https://github.com/mancj/MaterialSearchBar

Additionally, we will be adding search functionality to existing Firebase code from the firebase lesson in branch **firebase**

#### Go to res/layout/trophies_activity.xml, open the "Text" tab, and see the added Toolbar and Material Search bar as follows:

*app/src/main/res/layout/**trophies_activity.xml***
```
      <com.mancj.materialsearchbar.MaterialSearchBar
             android:id="@+id/searchBar"
             style="@style/MaterialSearchBarLight"
             android:layout_width="0dp"
             android:layout_height="48dp"
             android:layout_marginStart="8dp"
             android:layout_marginTop="8dp"
             android:layout_marginEnd="8dp"
             android:elevation="8dp"
             app:mt_placeholder=""
             app:layout_constraintEnd_toEndOf="parent"
             app:layout_constraintHorizontal_bias="0.0"
             app:layout_constraintStart_toStartOf="parent"
             app:layout_constraintTop_toTopOf="parent"
             app:mt_maxSuggestionsCount="10"
             app:mt_speechMode="false">
         </com.mancj.materialsearchbar.MaterialSearchBar>

         <androidx.recyclerview.widget.RecyclerView
             android:id="@+id/recyclerView"
             android:layout_width="395dp"
             android:layout_height="635dp"
             android:layout_marginStart="8dp"
             android:layout_marginTop="8dp"
             android:layout_marginEnd="8dp"
             android:layout_marginBottom="8dp"
             app:layout_constraintBottom_toBottomOf="parent"
             app:layout_constraintEnd_toEndOf="parent"
             app:layout_constraintStart_toStartOf="parent"
             app:layout_constraintTop_toBottomOf="@+id/searchBar" />
```

#### Now change your activity code to do the following:

1. Declare the search bar in the **TrophiesActivity** class:

*app/src/main/java/com/example/androidtutorial/**TrophiesActivity.java***
```
    private MaterialSearchBar searchBar;

```

2. Add the following to the **TrophiesActivity** class:

*app/src/main/java/com/example/androidtutorial/**TrophiesActivity.java***
```
   public class TrophiesActivity extends AppCompatActivity {

       private MaterialSearchBar searchBar;

       @Override
           protected void onCreate(Bundle savedInstanceState) {

           ...
           searchBar = findViewById(R.id.searchBar);

           searchBar.addTextChangeListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                   doSearch(searchBar.getText());

               }

               @Override
               public void afterTextChanged(Editable editable) {
                   doSearch(searchBar.getText());

               }

           });

           searchBar.enableSearch();
       }

       // search data
       private void doSearch(String searchText) {

            //convert string entered in SearchView to lowercase
            String query = searchText.toLowerCase();
            Query firebaseSearchQuery = mRef.whereArrayContains("search", query);
            FirestoreRecyclerOptions<Trophy> options = new FirestoreRecyclerOptions.Builder<Trophy>()
                .setQuery(query.isEmpty() ?  mRef : firebaseSearchQuery, Trophy.class)
                .build();
            adapter = new TrophyAdapter(options, this, trophies);
            // set adapter for recyclerview
            recyclerView.setAdapter(adapter);
            // CLOUD FIRESTORE
            // start listening for recyclerview items from firestore
            adapter.startListening();
       }

```

#### Commit and push all your changes.

*******************************************************************************************************************
# Done
*******************************************************************************************************************