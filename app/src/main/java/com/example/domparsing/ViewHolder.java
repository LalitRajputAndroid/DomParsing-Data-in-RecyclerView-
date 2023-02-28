package com.example.domparsing;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView t1,t2,t3;
    Button deletebtn,editbtn;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        t1 = itemView.findViewById(R.id.name_id);
        t2 = itemView.findViewById(R.id.roll_No_id);
        t3 = itemView.findViewById(R.id.age_id);

        deletebtn = itemView.findViewById(R.id.deletebtn_id);
        editbtn = itemView.findViewById(R.id.editbtn_id);
    }
}
