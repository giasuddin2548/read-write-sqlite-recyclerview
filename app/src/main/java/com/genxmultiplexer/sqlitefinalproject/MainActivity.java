package com.genxmultiplexer.sqlitefinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText editText_name,editText_phoneNo,editText_Imagelink;
    DBHelper db;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button=findViewById(R.id.btn_submitId);
        editText_name=findViewById(R.id.name_id);
        editText_phoneNo=findViewById(R.id.phone_id);
        editText_Imagelink=findViewById(R.id.image_id);

        db = new DBHelper(this);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id="10";
                String name=editText_name.getText().toString().trim();
                String phone=editText_phoneNo.getText().toString().trim();
                String image=editText_Imagelink.getText().toString().trim();

                ViewData_Model viewData_model=new ViewData_Model(id,name,phone,image);


                boolean Data_Insert= (boolean) db.addContact(viewData_model);


                if (Data_Insert==true){
                    Toast.makeText(MainActivity.this,"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Data Not Inserted ",Toast.LENGTH_SHORT).show();
                }

            }
        });





    }

    public void View_data(View view) {

        Intent intent=new Intent(MainActivity.this,Activity_view_Data.class);
        startActivity(intent);
    }
}
