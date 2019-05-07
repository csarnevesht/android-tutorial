# Android Tutorial

*******************************************************************************************************************
# Open project 'basics'
*******************************************************************************************************************

## Some basics ...

The content in this repository will be mostly based off of the Android tutorial in:
https://www.tutlane.com/tutorial/android/android-tutorial.

The above tutorial is quite comprehensive and you're welcome to explore it, but if you find yourself getting
a bit overwhelmed then in this repository we will try to focus on basic hands-on examples.

In the above tutorial, the following sections are good to skim over for a general idea but you don't need to
delve deeply into them:
(It's ok to skip them for now)

- Android Introduction - What is Android?  https://www.tutlane.com/tutorial/android/android-introduction
- Android Architecture  https://www.tutlane.com/tutorial/android/android-architecture

## Android installation

If you haven't installed Android Developer Studio please do so by following the instructions in:

- Android Development Environment Setup https://www.tutlane.com/tutorial/android/android-development-environment-setup
- Android Studio Installation: https://www.tutlane.com/tutorial/android/android-studio-installation-for-development-environment

## Android Hello World App Example

The following link explains how to create your first Android app.

https://www.tutlane.com/tutorial/android/android-hello-world-app-example


In the above link, you will learn how to create a new project with an Empty Activity.
NOTE:  Whenever you create a new project with an Empty Activity, always remember to check
the checkbox "use androidx.* artifacts".
You will be exposed to files and concepts which will be explained in more details later.
For now, just try to remember the following pieces, you don't need to understand them in detail now:

 - an Android layout file file, activity_main.xml,
 - an Android Main activity file, MainActivity.java
 - Android Manifest file, AndroidManifest.xml
 - Android emulator
 - running the Android app

## Clone android-tutorials and open in Android Developer Studio.

At this point, if you haven't done so already, you will need to clone the android-tutorials github repository and open
the empty app in Android Developer Studio.
You will need to switch to different branches as we go further along in this tutorial.

You will need to know how to switch branches.

In Android Developer Studio, click "Git: master" at the very bottom, see image below:

![Alt text](readmeimgs/android-git.png)



## Android mobile app

A mobile app consists of screens or pages containing UI (user interface) elements.

For example, a mobile app can have a login page and a home page.  A login page can consist of UI elements like a
text edit box where the user enters his/her username, a password box where the user enters his/her password, and
a button that the user clicks to login.
A home page to the mobile app could have a text box with a description of the app and an image with some nice image.

Following are some common UI elements used in a screen/page which you may recognize:

- TextView
- EditText
- Button
- CheckBox
- RadioButton
- ImageButton
- Progress Bar
- Spinner

## Android Activity

In android, an Activity represents a single screen/page with a user interface (UI) of an application.

Generally, the android apps will contain multiple screens and each screen of our application will be an extension of Activity class.
By using activities, we can place all our android application UI elements in a single screen.

## Android View and ViewGroup with Examples

In android, a 'layout' is used to lay out and organize the UI elements in an activity (screen/page).
A 'layout' will hold the UI elements and will help you in organizing the UI elements.

Following are some examples of layouts:

- Linear Layout
- Relative Layout
- Table Layout
- Frame Layout
- Web View
- List View
- Grid View

take a look at the following link to get an idea of the different layouts:
https://www.tutlane.com/tutorial/android/android-view-and-viewgroup-with-examples

## AndroidX Overview

AndroidX is a major improvement to the original Android Support Library.
Whenever we create a new project, when we select an Empty activity, always check the checkbox
"use androidx.* artifacts".

for more information see https://developer.android.com/jetpack/androidx

*******************************************************************************************************************
# Open project 'ui-elements-runtime'
*******************************************************************************************************************

## UI Elements

see https://www.tutlane.com/tutorial/android/android-ui-controls-textview-edittext-radio-button-checkbox


In android, we can define a UI in two ways

- Create UI elements at runtime
- Declare UI elements in XML


The android framework will allow us to use either or both of these methods to define our application’s UI.

## Create UI Elements at Runtime

To create UI elements at runtime, we need to create our own custom View and ViewGroup objects programmatically with required layouts.

Following is the example of creating an UI elements (TextView, EditText, Button) in LinearLayout using custom View and ViewGroup objects in
an activity programmatically.

```
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        TextView textView1 = new TextView(this);
        textView1.setText("Name:");
        EditText editText1 = new EditText(this);
        editText1.setText("Enter Name");
        Button button1 = new Button(this);
        button1.setText("Add Name");
        linearLayout.addView(textView1);
        linearLayout.addView(editText1);
        linearLayout.addView(button1);
        setContentView(linearLayout);
    }
}
```


in Android Studio, use Cmd-Shift-O (or go to "Navigate" -> "File") and type MainActivity.java to see the above code, and
run the app.

*******************************************************************************************************************
# Open project 'ui-elements-xml'
*******************************************************************************************************************

## Declare UI elements in XML

In android, a page layout is created in XML similarly as web pages are created in HTML.

The layout file must contain only one root element, which must be a View or ViewGroup object.
Once we define root element, then we can add additional layout objects or widgets as child elements to build the
View hierarchy that defines our layout.

Following is an example of defining some UI elements (TextView, EditText, Button) in an XML file (activity_main.xml)
using LinearLayout.

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"

    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/fstTxt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Enter Name" />
    <EditText
        android:id="@+id/name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"/>
    <Button
        android:id="@+id/getName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Get Name" />
</LinearLayout>
```

in Android Studio, use Cmd-Shift-O (or go to "Navigate" -> "File") and type activity_main.java to see the above xml code

Also, in file MainActivity.java, method setContentView(R.layout.activity_main) is called to 'render' the layout file.
Rendering a layout means that the activity will be showing the UI design (with the UI elements) written in the xml file.

setContentView(R.layout.activity_main)

R means Resource

layout means design

activity_main is the xml you have created under res->layout->activity_main.xml

for a more detailed explanation of setContentView method, see https://androidride.com/what-setcontentview-android-studio/

in Android Studio, use Cmd-Shift-O (or go to "Navigate" -> "File") and type ActivityMain.java to see the above code, and
run the app.

## Constraint layout

The Constraint Layout is worth learning about, once you watch this video and play around with it you may just have
as much fun as I did!

https://www.youtube.com/watch?v=4N4bCdyGcUc

*******************************************************************************************************************
# Open project 'recyclerview'
*******************************************************************************************************************

## RecyclerView

Android RecyclerView is the advanced version of ListView for more improvements and features.

#### Go to res/layout/activity_main.xml, open the "Design" tab, and in "Palette" -> "Containers" you will find the
RecyclerView.  Drag it to the Contraint Layout.  You will be asked if you want to add the library to project
dependencies.  When you do, the library will be added to the app build.gradle file.

The RecyclerView that we are going to design contains our trophies information with RecyclerView.

#### Create a class Trophy.java with getter/setter methods for each row in RecyclerView.
see src/main/java/com/example/androidtutorial/Trophy.java

#### Create a layout for RecyclerView item row trophies_item_row.xml.
see src/main/res/layout/trophies_item_row.xml.

#### Now create adapter class TrophyAdapter.java step-wise for recyclerview base.
Follow these steps to easily create the adapter without any complex structure.
Below steps are for RecyclerView adapter class.

1. Create class TrophyAdapter.java

(src/main/java/com/example/androidtutorial/TrophyAdapter.java)
```
    public class TrophyAdapter {
    }
```

2. Create ViewHolder for RecyclerView

(src/main/java/com/example/androidtutorial/TrophyHolder.java)
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


3. Extend adapter TrophyAdapter class to RecyclerView.Adapter<TrophyHolder> and
   implement override methods onCreateViewHolder, onBindViewHolder and getItemCount.

(src/main/java/com/example/androidtutorial/TrophyAdapter.java)

4. Define context and ArrayList and create a constructor.

(src/main/java/com/example/androidtutorial/TrophyAdapter.java)
```
    private Context context;
    private ArrayList<Trophy> trophies;

    public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
        this.context = context;
        this.trophies = trophies;
    }
```

5. Change getItemCount() method

(src/main/java/com/example/androidtutorial/TrophyAdapter.java)
```
    @Override
    public int getItemCount() {
          return trophies.size();
    }
```

6. Inflate item layout in onCreateViewHolder() method and inflate trophies_item_row for recyclerview

(src/main/java/com/example/androidtutorial/TrophyAdapter.java)
```
    @Override
    public TrophyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.trophies_item_row, parent, false);
         return new TrophyHolder(view);
    }
```

7. Create a method in TrophyHolder class to set values for each trophy to item row.

(src/main/java/com/example/androidtutorial/TrophyAdapter.java)
```
    public void setDetails(Trophy trophy) {
        txtTitle.setText(trophy.getTrophyTitle());
        txtDescription.setText(trophy.getTrophyDescription());
    }
```

8. Call this method from onBindViewHolder() method to bind item of recyclerview

(src/main/java/com/example/androidtutorial/TrophyAdapter.java)
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

## Search

We will be using MaterialSearchbar from https://github.com/mancj/MaterialSearchBar

Additionally, we will be adding search functionality to existing RecyclerView code from the RecyclerView lession in
https://github.com/csarnevesht/android-tutorials/recyclerview

#### Go to res/layout/activity_main.xml, open the "Text" tab, and see the added Toolbar and Material Search bar as follows:

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

#### Now change your activity code to do the following (see src/main/java/com/example/androidtutorial/MainActivity.java):

1. Declare the search bar in the MainActivity class:

(src/main/java/com/example/androidtutorial/MainActivity.java)
```
    private MaterialSearchBar searchBar;

```

2. Add the following to MainActivity class:

(src/main/java/com/example/androidtutorial/MainActivity.java)
```
   public class MainActivity extends AppCompatActivity {

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

       // search data
       // search data
       private void doSearch(String searchText) {
           Log.d("LOG_TAG", getClass().getSimpleName() + " doSearch " + searchBar.getText());

           adapter.getFilter().filter(searchText);
           adapter.notifyDataSetChanged();

       }

```


*******************************************************************************************************************
# Open project 'firebase'
*******************************************************************************************************************

