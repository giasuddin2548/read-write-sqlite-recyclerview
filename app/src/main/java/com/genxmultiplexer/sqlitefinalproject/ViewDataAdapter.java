package com.genxmultiplexer.sqlitefinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;


public class ViewDataAdapter extends RecyclerView.Adapter<ViewData_ViewHolder> {
    Context context;
    List<ViewData_Model> viewdata_list;





    public ViewDataAdapter(Context context, List<ViewData_Model> viewdata_list) {
        this.context = context;
        this.viewdata_list = viewdata_list;
    }

    @NonNull
    @Override
    public ViewData_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.simple_sqlite_dataview_layout,viewGroup,false);
        ViewData_ViewHolder holder=new ViewData_ViewHolder(view);




        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData_ViewHolder viewData_viewHolder, int i) {

        final ViewData_Model mypostPostion=viewdata_list.get(getItemCount()-i-1);



        viewData_viewHolder.textView_name_std.setText("ID: "+mypostPostion.getStd_id()+" "+"Name: "+mypostPostion.getStd_name());
        viewData_viewHolder.textView_std_phoneNo.setText(mypostPostion.getStd_phoneno());

        Picasso.get()
                .load(mypostPostion.getStd_imagelink())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(viewData_viewHolder.imageView_Std);









    }

    @Override
    public int getItemCount() {
        return viewdata_list.size();
    }




}
