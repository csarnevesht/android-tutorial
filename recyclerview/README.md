# Android Tutorial

*******************************************************************************************************************
# Open project 'recyclerview'
*******************************************************************************************************************

## RecyclerView

Android **RecyclerView** is the advanced version of ListView for more improvements and features.

- Go to **_activity_main.xml_**, open the **Design** tab, and in **Palete** -> **Containers** you will find the **RecyclerView**.
- Drag it to the Contraint Layout.
- You will be asked if you want to add the library to project dependencies, click **Ok**.  When you do, the library will be added to the app/build.gradle file.

The page that we are going to design contains our trophies information with **RecyclerView**.

#### Create a class Trophy.java with getter/setter methods for each row in RecyclerView.
see *src/main/java/com/example/androidtutorial/**Trophy.java***.

#### Create a layout for RecyclerView item row trophies_item_row.xml.
see *src/main/res/layout/**trophies_item_row.xml***.

#### Now create adapter class TrophyAdapter.java step-wise for recyclerview base.
Follow these steps to easily create the adapter without any complex structure.
Below steps are for RecyclerView adapter class.

1. Create class **TrophyAdapter**

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public class TrophyAdapter {
    }
```

2. Create **ViewHolder** for RecyclerView

*app/src/main/java/com/example/androidtutorial/**TrophyHolder.java***
```
    public class TrophyHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtDescription;

        public TrophyHolder(View itemView) {
          super(itemView);
          txtTitle = itemView.findViewById(R.id.txtTitle);
          txtDescription = itemView.findViewById(R.id.txtDescription);
        }
    }
```


3. Extend adapter **TrophyAdapter** class to **RecyclerView.Adapter<TrophyHolder>** and
   implement override methods **onCreateViewHolder**, **onBindViewHolder** and **getItemCount**.

(see *src/main/java/com/example/androidtutorial/**TrophyAdapter.java***)

4. Define context and trophies ArrayList and create a constructor.

(src/main/java/com/example/androidtutorial/**TrophyAdapter.java**)
```
    private Context context;
    private ArrayList<Trophy> trophies;

    public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
        this.context = context;
        this.trophies = trophies;
    }
```

5. Change **getItemCount()** method

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    @Override
    public int getItemCount() {
          return trophies.size();
    }
```

6. Inflate item layout in **onCreateViewHolder()** method and inflate **trophies_item_row** for the recyclerview.

**_NOTE_**: **Inflate** means to **render** or **show** the page for each trophy row item in the recyclerview list.

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    @Override
    public TrophyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.trophies_item_row, parent, false);
         return new TrophyHolder(view);
    }
```

7. Create a method in **TrophyHolder** class to set values for each trophy row item in the recyclerview list.

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    public void setDetails(Trophy trophy) {
        txtTitle.setText(trophy.getTrophyTitle());
        txtDescription.setText(trophy.getTrophyDescription());
    }
```

8. Call method **onBindViewHolder()** method to bind the trophy row item of recyclerview

*app/src/main/java/com/example/androidtutorial/**TrophyAdapter.java***
```
    @Override
    public void onBindViewHolder(TrophyHolder holder, int position) {
     Trophy trophy = trophies.get(position);
     holder.setDetails(trophy);
    }
```

#### Now change your activity code to do the following (see src/main/java/com/example/androidtutorial/MainActivity.java):

    - set recyclerview layout manager
    - set adapter for recyclerview
    - fill data for recyclerview items
    - set data to adapter and notify data

The LayoutManager is responsible for measuring and positioning item views within the recyclerview as well as
determining the policy for when to recycle item views that are no longer visible to the user.
By changing the layout manager, recyclerview can be used to implement a standard vertically scrolling list,
a uniform grid, staggered grids, horizontally scrolling collections and more.

*******************************************************************************************************************
# Open project 'search'
*******************************************************************************************************************

