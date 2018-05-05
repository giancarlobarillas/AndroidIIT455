package org.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GiancarloDesktop on 4/20/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_USERNAME="user";
    private static final String COLUMN_PASSWORD="pass";
    private static final String COLUMN_ITEM="item";
    SQLiteDatabase db;

    private static final String TABLE_CREATE="CREATE TABLE contacts (id INTEGER AUTO_INCREMENT , "+
            "name TEXT NOT NULL , user TEXT NOT NULL , pass TEXT NOT NULL);";
    public DatabaseHelper(Context context){
        super(context,TABLE_NAME,null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query="DROP TABLE IF EXIST "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertContact(contact c){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_USERNAME,c.getUsername());
        values.put(COLUMN_PASSWORD,c.getPassword());
        db.insert(TABLE_NAME,null,values);
    }

    public String searchPass(String str){
        db=this.getReadableDatabase();
        String query="SELECT name,pass FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String username,password;
        password="not found";
        if(cursor.moveToFirst())
        {
            do{
                username=cursor.getString(0);
                password=cursor.getString(1);
                if(username.equals(str))
                {
                    password=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return password;
    }
}
