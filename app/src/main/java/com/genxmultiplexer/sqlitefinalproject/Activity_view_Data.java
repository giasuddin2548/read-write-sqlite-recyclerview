package com.genxmultiplexer.sqlitefinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_view_Data extends AppCompatActivity {


    Toolbar toolbar;
    TextView textView;

    RecyclerView recyclerViewViewData;
    List<ViewData_Model> list_ViewData;
    ViewDataAdapter viewDataAdapter;

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__data);
        db = new DBHelper(this);


        textView=findViewById(R.id.toolbarTextView_ViewData_id);
        textView.setText("View SQLite Data");
        toolbar=findViewById(R.id.toolbar_ViewData_id);
        setSupportActionBar(toolbar);

        list_ViewData=new ArrayList<>();
        recyclerViewViewData=findViewById(R.id.recyclerView_ViewData_id);
        recyclerViewViewData.setHasFixedSize(true);
        recyclerViewViewData.setLayoutManager(new LinearLayoutManager(this));






        getSQLite_Data();



    }

    private void getSQLite_Data() {

        list_ViewData.clear();
        Cursor cursor=db.getData();
        if (cursor.getCount()==0){
            textView.setText("No Data Found");
        }else {

            while (cursor.moveToNext()){

                String std_id=cursor.getString(0);
                String std_name=cursor.getString(1);
                String std_phoneno=cursor.getString(2);
                String std_image=cursor.getString(3);



                list_ViewData.add(new ViewData_Model(std_id,std_name,std_phoneno,std_image));
            }

            viewDataAdapter = new ViewDataAdapter(getApplicationContext(), list_ViewData);
            recyclerViewViewData.setAdapter(viewDataAdapter);
            viewDataAdapter.notifyDataSetChanged();


        }




    }
}
