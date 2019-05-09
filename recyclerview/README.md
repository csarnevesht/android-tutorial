*******************************************************************************************************************
# Create new branch 'recyclerview'
*******************************************************************************************************************

## RecyclerView

Android **RecyclerView** is the advanced version of ListView for more improvements and features.

- Go to **_activity_main.xml_**, open the **Design** tab, and in **Palete** -> **Containers** you will find the **RecyclerView**.
- Drag it to the Contraint Layout.
- You will be asked if you want to add the library to project dependencies, click **Ok**.  When you do, the library will be added to the app/build.gradle file.

The page that we are going to design contains our trophies information with **RecyclerView**.

#### Create a class Trophy.java with getter/setter methods for each row in RecyclerView.

In this tutorial we will have a **title** and a **description** for a trophy:

```
    public class Trophy {
        String title;
        String description;

        public Trophy(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
```

#### Create a layout for RecyclerView item row trophies_item_row.xml.

*src/main/java/com/example/androidtutorial/**trophies_item_row.java***
```
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/txtTitle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:padding="1dp"
            android:textSize="18sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/txtDescription"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:padding="1dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/txtTitle" />

    </androidx.constraintlayout.widget.ConstraintLayout>
```

#### Now create adapter class TrophyAdapter.java step-wise for recyclerview base.
Follow these steps to easily create the adapter without any complex structure.
Below steps are for RecyclerView adapter class.

1. Create class **TrophyAdapter**

*src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter {
    }
```

2. Create **ViewHolder** for RecyclerView

*src/main/java/com/example/androidtutorial/**TrophyHolder.java***
```
    public class TrophyHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;

        public TrophyHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
        }

        public void setDetails(Trophy trophy) {
            txtTitle.setText(trophy.getTitle());
            txtDescription.setText(trophy.getDescription());
        }
    }
```


3. Extend adapter **TrophyAdapter** class to **RecyclerView.Adapter<TrophyHolder>** and
   implement override methods **onCreateViewHolder**, **onBindViewHolder** and **getItemCount**.

   ```
   public class TrophyAdapter extends RecyclerView.Adapter<TrophyHolder> {
       private Context context;
       private ArrayList<Trophy> trophies;

       public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
           this.context = context;
           this.trophies = trophies;
       }

       @Override
       public int getItemCount() {
       }

       @Override
       public TrophyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       }

       @Override
       public void onBindViewHolder(TrophyHolder holder, int position) {
       }

   }
   ```

4. Define context and trophies ArrayList and create a constructor.

*src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter extends RecyclerView.Adapter<TrophyHolder> {
        private Context context;
        private ArrayList<Trophy> trophies;

        public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
            this.context = context;
            this.trophies = trophies;
        }
    }
 ```

5. Change **getItemCount()** method

*src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    @Override
    public int getItemCount() {
          return trophies.size();
    }
```

6. Inflate item layout in **onCreateViewHolder()** method and inflate **trophies_item_row** for the recyclerview.

**_NOTE_**: **Inflate** means to **render** or **show** the page for each trophy row item in the recyclerview list.

*src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    @Override
    public TrophyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.trophies_item_row, parent, false);
         return new TrophyHolder(view);
    }
```

7. Create a method in **TrophyHolder** class to set values for each trophy row item in the recyclerview list.

*src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public void setDetails(Trophy trophy) {
        txtTitle.setText(trophy.getTrophyTitle());
        txtDescription.setText(trophy.getTrophyDescription());
    }
```

8. Call method **onBindViewHolder()** method to bind the trophy row item of recyclerview

*src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    @Override
    public void onBindViewHolder(TrophyHolder holder, int position) {
     Trophy trophy = trophies.get(position);
     holder.setDetails(trophy);
    }
```

#### Now change your activity code to do the following:

    - set recyclerview layout manager
    - set adapter for recyclerview
    - fill data for recyclerview items
    - set data to adapter and notify data

*src/main/java/com/example/androidtutorial/**MainActivity.java***
```
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
    }
```

The LayoutManager is responsible for measuring and positioning item views within the recyclerview as well as
determining the policy for when to recycle item views that are no longer visible to the user.
By changing the layout manager, recyclerview can be used to implement a standard vertically scrolling list,
a uniform grid, staggered grids, horizontally scrolling collections and more.

#### Run/Debug the app

#### Commit and push all your changes

*******************************************************************************************************************
# Create new branch 'search'
*******************************************************************************************************************