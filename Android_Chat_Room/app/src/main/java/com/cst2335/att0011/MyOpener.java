package com.cst2335.att0011;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyOpener extends SQLiteOpenHelper {

    public static final String filename = "MyMessageDatabase";
    public static final int version = 1;
    public static final String TABLE_NAME = "MyMessages";
    public static final String COL_ID = "_id";
    public static final String COL_MESSAGE_TYPE = "MessageType";
    public static final String COL_MESSAGE = "Message";

    public MyOpener(Context context) {
        super(context, filename, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( String.format( "Create table %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT);"
                , TABLE_NAME, COL_ID,                       COL_MESSAGE, COL_MESSAGE_TYPE) );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "Drop table if exists " + TABLE_NAME ); //deletes the current data
        //create a new table:

        this.onCreate(db); //calls function on line 26
    }
}