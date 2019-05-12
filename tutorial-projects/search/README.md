# Android Tutorial

*******************************************************************************************************************
# Create new branch 'search'
*******************************************************************************************************************

## Search

We will be using **MaterialSearchbar** from https://github.com/mancj/MaterialSearchBar

Additionally, we will be adding search functionality to existing RecyclerView code from the RecyclerView lesson in branch **recycleview**
https://github.com/csarnevesht/android-tutorial/recyclerview

#### include SearchBar to your project:

add this code to the the project level build.gradle file:

```
    allprojects {
	    repositories {
		    ...
		    maven { url "https://jitpack.io" }
	    }
    }
```

add the dependency to the the app level build.gradle file:

```
    dependencies {
	    implementation 'com.github.mancj:MaterialSearchBar:0.8.2'
    }
```

#### Go to res/layout/trophies_activity.xml, open the "Text" tab, and add the Material Search bar as follows:

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

#### Change activity code to add search functionality:

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
           adapter.getFilter().filter(searchText);
           adapter.notifyDataSetChanged();

       }
   }

```

#### Add filter capability to adapter TrophyAdapter:

1. In **TrophyAdapter** add **Filterable** interface:

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> implements Filterable {
       ...
    }
```

2. Generate **implement methods** for **TrophyFilter** - Right click on **Filterable** -> **Generate** -> **Implement methods**:

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> implements Filterable {
       ...
       @Override
       public Filter getFilter() {
           return null;
       }
       ...
    }
```


3. In **TrophyAdapter** create inner class **TrophyFilter** which extends **Filter** class:

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> implements Filterable  {

        ...
        private class TrophyFilter extends Filter {

        }

        @Override
        public Filter getFilter() {
           return null;
        }
    }
```

4. Generate **implement methods** for TrophyFilter - Right click on **Filter** -> **Generate** -> **Implement methods**:

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> implements Filterable  {

        ...
        private class TrophyFilter extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        }

        @Override
        public Filter getFilter() {
           return null;
        }
    }

```

5. Change **getFilter** method to return a TrophyFilter object:

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> implements Filterable  {

        ...
        private class TrophyFilter extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        }

        @Override
        public Filter getFilter() {
           return new TrophyFilter();
        }
    }

```

5. Add a filtered list of trophies variable **trophiesFiltered** and set it in the constructor:

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> implements Filterable  {

        private Context context;
        private ArrayList<Trophy> trophies;
        private List<Trophy> trophiesFiltered;

        public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
            this.context = context;
            this.trophies = trophies;
            this.trophiesFiltered = trophies;
        }

        ...
        private class TrophyFilter extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        }

        @Override
        public Filter getFilter() {
           return new TrophyFilter();
        }
    }

```

6. Implement methods **performFiltering** and **publishResults**:

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> implements Filterable  {

        private Context context;
        private ArrayList<Trophy> trophies;
        private List<Trophy> trophiesFiltered;

        public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
            this.context = context;
            this.trophies = trophies;
            this.trophiesFiltered = trophies;
        }

        ...
        private class TrophyFilter extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString().toLowerCase();
                if (charString.isEmpty()) {
                    trophiesFiltered = trophies;
                } else {
                    List<Trophy> filteredList = new ArrayList<>();
                    for (Trophy row : trophies) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for title or description match
                        if (row.getTitle().toLowerCase().contains(charString) || row.getDescription().contains(charString)) {
                            filteredList.add(row);
                        }
                    }
                    trophiesFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = trophiesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                trophiesFiltered = (ArrayList<Trophy>) results.values;
                notifyDataSetChanged();
            }
        }

        @Override
        public Filter getFilter() {
            return new TrophyFilter();
        }
    }

```

#### Commit and push all your changes.

*******************************************************************************************************************
# Create new branch 'firebase'
*******************************************************************************************************************
