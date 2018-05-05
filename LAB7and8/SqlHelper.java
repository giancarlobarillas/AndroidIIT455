package org.example.lab7and8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by GiancarloDesktop on 4/8/2018.
 */

public class SqlHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Books.db";
    private static final String TABLE_NAME = "book_table";
    private static final String COL_1 = "id";
    private static final String COL_2 = "title";
    private static final String COL_3 = "author";
    private static final String COL_4 = "rating";
    public SqlHelper(Context context){
        super(context,DATABASE_NAME,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT NOT NULL, AUTHOR TEXT NOT NULL, RATING TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void addBook(Books book){

        Log.d("addBook",book.toString());
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_2,book.getTitle());
        values.put(COL_3,book.getAuthor());
        values.put(COL_4,book.getRating());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public List<Books> getAllBooks(){
        List<Books> books=new LinkedList<Books>();
        String tablequery=" SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(tablequery,null);
        Books bookObject=null;
        if(cursor.moveToFirst()){
            do {
                bookObject=new Books();
                bookObject.setId(Integer.parseInt(cursor.getString(0)));
                bookObject.setTitle(cursor.getString(1));
                bookObject.setAuthor(cursor.getString(2));
                bookObject.setRating(cursor.getString(3));
                books.add(bookObject);
            }while (cursor.moveToNext());
        }
        Log.d("getAllBooks()", books.toString());
        return books;
    }

    public Set<String> getTitle(){
        Set<String> set = new HashSet<String>();
        String tablequery=" SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(tablequery,null);
        if(cursor.moveToFirst()){
            do {
                set.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return set;
    }

    public String getAuthor(String tabletitle){
        StringBuilder stringBuilder=new StringBuilder();
        String tablequery="SELECT * FROM "+TABLE_NAME+" where title=?";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(tablequery,new String[]{tabletitle});
        if(cursor.moveToFirst()){
            do{
                stringBuilder.append(cursor.getString(2));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return stringBuilder.toString();
    }
    public int updateBook(Books book, String updateTitle, String updateAuthor){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("title",updateTitle);
        values.put("autor",updateAuthor);
        int index=db.update(TABLE_NAME,values,COL_1+" =?",new String[]{String.valueOf(book.getId())});
        db.close();
        Log.d("Book Updated",book.toString());
        return index;
    }
    public void deleteBook(Books book){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,COL_1+" =?",new String[]{String.valueOf(book.getId())});
        db.close();
        Log.d("Book Deleted", book.toString());
    }
}
