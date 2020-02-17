package com.example.androidtutorial;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.javahelps.externalsqliteimporter.ExternalSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private ExternalSQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     * @param sourceDirectory
     */
    private DatabaseAccess(Context context, String sourceDirectory) {
        if (sourceDirectory == null) {
            this.openHelper = new DatabaseOpenHelper(context);
        } else {
            this.openHelper = new DatabaseOpenHelper(context, sourceDirectory);
        }
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context         the Context
     * @param sourceDirectory optional external directory
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context, String sourceDirectory) {
        if (instance == null) {
            instance = new DatabaseAccess(context, sourceDirectory);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all trophies from the database.
     *
     * @return a List of trophies
     */
    public List<Trophy> getTrophies() {
        List<Trophy> list = new ArrayList<Trophy>();
        Cursor cursor = database.rawQuery("SELECT * FROM Official_Backend_Trophy_app_Google_Sheets_html1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Trophy trophy = new Trophy(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7)
            );
            list.add(trophy);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}