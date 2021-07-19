package com.example.codingeval2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<covidViewHolder> {
    private List<ResponseModel> covidlist;
    private ClickListener clickListener;

    public CovidAdapter(List<ResponseModel> covidlist, ClickListener clickListener) {
        this.covidlist = covidlist;
        this.clickListener=clickListener;
    }

    @NonNull
    @NotNull
    @Override
    public covidViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new covidViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull covidViewHolder holder, int position) {
        ResponseModel responseModel=covidlist.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return covidlist.size();
    }
}
