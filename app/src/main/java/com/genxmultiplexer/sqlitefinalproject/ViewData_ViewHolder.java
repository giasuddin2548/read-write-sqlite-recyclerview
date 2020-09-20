package com.genxmultiplexer.sqlitefinalproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewData_ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView_Std;

   public TextView textView_name_std,textView_std_phoneNo;



    public ViewData_ViewHolder(@NonNull View itemView) {
        super(itemView);

        //country a
        imageView_Std=itemView.findViewById(R.id.imageView_Stduent_Image);
        textView_name_std=itemView.findViewById(R.id.textview_student_NameId);
        textView_std_phoneNo=itemView.findViewById(R.id.textview_Stdnt_phoneeNoId);



    }
}
