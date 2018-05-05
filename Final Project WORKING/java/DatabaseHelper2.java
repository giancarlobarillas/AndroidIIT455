package org.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by GiancarloDesktop on 4/21/2018.
 */

public class DatabaseHelper2 extends SQLiteOpenHelper{

    private static final String TAG="DatabaseHelper";

    //Create fields for table

    private static final String TABLE_NAME="people_table";//table name
    private static final String COL1="ID";
    private static final String COL2="name";
    private static final String COL3="user";

    public DatabaseHelper2(Context context){
        super(context,TABLE_NAME,null ,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="CREATE TABLE people_table ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, user TEXT )";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String droptable="DROP IF TABLE EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(droptable);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String item){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,item);
        Log.d(TAG, "addData: Adding "+item+" to "+ TABLE_NAME);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public boolean addDatas(String item,String user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,item);
        contentValues.put(COL3,user);
        Log.d(TAG, "addData: Adding "+item+" to "+ TABLE_NAME);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor data=db.rawQuery(query,null);
        return data;
    }

    public Cursor getDatas(String user){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+" WHERE "+COL3+" LIKE '"+user+"'";
        Cursor data=db.rawQuery(query,null);
        return data;
    }

    public Cursor getItemID(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT "+COL1+" FROM "+TABLE_NAME+" WHERE "+COL2+" = '"+name+"'";
        Cursor data=db.rawQuery(query,null);
        return data;
    }

    public void updateName(String newName,int id,String oldName){
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG,"updateName: query: "+query);
        Log.d(TAG,"updateName: setting name to "+newName);
        db.execSQL(query);
    }

    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }
}
