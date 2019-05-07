# Android Tutorial

*******************************************************************************************************************
# Open project 'basics'
*******************************************************************************************************************

## Some basics ...

The content in this repository will be mostly based off of the Android tutorial in the following link:
https://www.tutlane.com/tutorial/android/android-tutorial.

The above tutorial is quite comprehensive and you're welcome to explore it, but if you find yourself getting
a bit overwhelmed then in this repository we will try to focus on basic hands-on examples.

From the above tutorial, the following sections are good to skim over for a general idea but you don't need to
delve deeply into them:
(It's ok to skip them for now)

- Android Introduction - What is Android?  https://www.tutlane.com/tutorial/android/android-introduction
- Android Architecture  https://www.tutlane.com/tutorial/android/android-architecture

## Android installation

If you haven't installed Android Developer Studio please do so by following the instructions below:

- Android Development Environment Setup https://www.tutlane.com/tutorial/android/android-development-environment-setup
- Android Studio Installation: https://www.tutlane.com/tutorial/android/android-studio-installation-for-development-environment

## Android Hello World App Example

The following link explains how to create your first Android app.

https://www.tutlane.com/tutorial/android/android-hello-world-app-example

In the above link, you will learn how to create a new project with an Empty Activity.

**_IMPORTANT_**:  Whenever you create a new project with an Empty Activity, always remember to check the checkbox "use androidx.* artifacts".

You will be exposed to files and concepts which will be explained in more details later.
For now, just try to remember the following pieces, you don't need to understand them in detail now:

 - an **Android layout file**, activity_main.xml (*app/src/main/res/layout/activity_main.xml*),
 - an **Android Main activity file**, MainActivity.java (*app/src/main/java/com/example/androidtutorial/MainActivity.java*)
 - **Android Manifest file**, **AndroidManifest.xml** (*app/src/main/AndroidManifest.xml*)
 - Android emulator
 - running the Android app

**_HINT_**: in Android Studio, use Cmd-Shift-O (or go to "Navigate" -> "File") and type MainActivity.java or activity_main.xml (or any file name) to open a file.

## Clone android-tutorial and open in Android Developer Studio.

At this point, if you haven't done so already, you will need to clone the android-tutorial github repository and open
the empty app in Android Developer Studio.
You will need to switch to different branches as we go further along in this tutorial.

You will need to know how to switch branches.

In Android Developer Studio, click **Git: master** at the very bottom and you will be able to switch branches, see image below as the arrow points to it:

![Alt text](readmeimgs/android-git.png)

## Android mobile app

A **mobile app** consists of pages (or screens) containing UI (user interface) elements.

For example, a **mobile app** can have a login page and a home page.  A login page can consist of UI elements like a
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

In android, an **Activity** represents a single page with a user interface (UI) of an application.

Generally, the android apps will contain multiple pages and each page of our application will be an extension of Activity class.
By using activities, we can place all our android application UI elements in a single page.

## Android View and ViewGroup with Examples

In android, a **layout** is used to lay out and organize the UI elements in an **activity** (page/screen).
A **layout** will hold the UI elements and will help you in organizing the UI elements.

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

**AndroidX** is a major improvement to the original Android Support Library.

**_IMPORTANT_**:: Whenever we create a new project, when we select an Empty activity, always check the checkbox "use androidx.* artifacts".

for more information see https://developer.android.com/jetpack/androidx

*******************************************************************************************************************
# Open project 'ui-elements-runtime'
*******************************************************************************************************************

## UI Elements

see https://www.tutlane.com/tutorial/android/android-ui-controls-textview-edittext-radio-button-checkbox

In android, we can define a UI in two ways:

- Create UI elements at runtime
- Declare UI elements in XML

The android framework will allow us to use either or both of these methods to define our application’s UI.

## Create UI Elements at Runtime

To create UI elements at runtime, we need to create our own custom View and ViewGroup objects programmatically with required layouts.

Following is the example of creating an UI elements (TextView, EditText, Button) in LinearLayout using custom View and ViewGroup objects in
an activity programmatically.

*app/src/main/java/com/example/androidtutorial/MainActivity.java*
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


**_HINT_**: in Android Studio, use Cmd-Shift-O (or go to "Navigate" -> "File") and type MainActivity.java to see the above code, and
run the app.

*******************************************************************************************************************
# Open project 'ui-elements-xml'
*******************************************************************************************************************

