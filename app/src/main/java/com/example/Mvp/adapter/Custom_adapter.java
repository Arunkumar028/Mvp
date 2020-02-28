package com.example.Mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Mvp.R;
import com.example.Mvp.model.Responcedetails;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Custom_adapter extends RecyclerView.Adapter<Custom_adapter.ViewHolder> {
    Context mcontext;
    List<Responcedetails> responcedetails;


    public Custom_adapter(Context applicationContext, List<Responcedetails> body) {
        this.mcontext = applicationContext;
        this.responcedetails = body;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.custom_layput, parent, false);
        return new Custom_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Responcedetails outputs = responcedetails.get(position);
        holder.name.setText(String.valueOf(outputs.getId()));


    }

    @Override
    public int getItemCount() {
        return responcedetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
