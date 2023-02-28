package com.example.domparsing;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<Modal> list = new ArrayList<>();
    Context context;

    public MyAdapter(ArrayList<Modal> list,Context context) {
        this.list = list;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.t1.setText(list.get(position).getName());
        holder.t2.setText(list.get(position).getRoll_no());
        holder.t3.setText(list.get(position).getAge());

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });


        holder.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameedit,rollno_edit,ageedit;
                Button updatebtn;

                Dialog dialog=new Dialog(view.getContext());
                dialog.setContentView(R.layout.custom_dailog);


                nameedit =dialog.findViewById(R.id.nameedit__id);
                rollno_edit = dialog.findViewById(R.id.rollnoedit_id);
                ageedit = dialog.findViewById(R.id.ageedit_id);
                updatebtn = dialog.findViewById(R.id.updatebtn_id);

                String e1 = holder.t1.getText().toString();
                String e2 = holder.t2.getText().toString();
                String e3 = holder.t3.getText().toString();

                nameedit.setText(e1);
                rollno_edit.setText(e2);
                ageedit.setText(e3);

                updatebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = nameedit.getText().toString();
                        String roll = rollno_edit.getText().toString();
                        String age = ageedit.getText().toString();

                        holder.t1.setText(name);
                        holder.t2.setText(roll);
                        holder.t3.setText(age);

                        nameedit.setText("");
                        rollno_edit.setText("");
                        ageedit.setText("");
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
