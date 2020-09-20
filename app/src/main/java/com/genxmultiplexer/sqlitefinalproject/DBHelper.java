package com.genxmultiplexer.sqlitefinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ImageView;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {







    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "uu_university.db";
    private static final String TABLE_NAME = "std_info";
    private static final String ID="id";
    private static final String NAME = "name";
    private static final String PH_NO = "phone_number";
    private static final String Image_link = "std_image";
    private Context context;
    private String CREATE_TABLE ="CREATE TABLE  "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME +" VARCHAR(50) Not Null,"+PH_NO+" VARCHAR(50),"+Image_link +" VARCHAR(200) NOT NULL  )";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }



    public boolean addContact(ViewData_Model viewData_model) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, viewData_model.getStd_name());
        values.put(PH_NO, viewData_model.getStd_phoneno());
        values.put(Image_link, viewData_model.getStd_imagelink());

        // Inserting Row
        long success=db.insert(TABLE_NAME, null, values);

        if (success==-1){
            return false;
        }else {

            return  true;
        }

    }


    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * From "+TABLE_NAME,null);

        return cursor;
    }



}
