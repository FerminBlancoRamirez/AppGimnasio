package com.example.appgimnasio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<Days> daysArrayList;
    public MyAdapter(Context context, ArrayList<Days> daysArrayList){
        this.context=context;
        this.daysArrayList=daysArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.days_item, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Days days=daysArrayList.get(position);
        holder.tVDiaDeLaSemana.setText(days.tVDiaDeLaSemana);
        holder.tvEntrenamiento.setText(days.tVEntrenamiento);
    }

    @Override
    public int getItemCount() {
        return daysArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tVDiaDeLaSemana;
        TextView tvEntrenamiento;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tVDiaDeLaSemana = itemView.findViewById(R.id.tVDiaDeLaSemana);
            tvEntrenamiento= itemView.findViewById(R.id.tVEntrenamiento);
        }
    }
}
