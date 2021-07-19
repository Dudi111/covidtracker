package com.example.codingeval2;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class covidViewHolder extends RecyclerView.ViewHolder {

    private TextView tvDate;
    private TextView tvpositive;
    private TextView tvnegative;
    private TextView tvhospitalised;
    private TextView tvventilator;
    private TextView tvDeaths;
    private ClickListener clickListener;

    public covidViewHolder(@NonNull @NotNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener=clickListener;
        inii(itemView);
    }

    private void inii(View itemView) {
        tvDate=itemView.findViewById(R.id.tvdate);
        tvpositive=itemView.findViewById(R.id.tvpositive);
        tvnegative=itemView.findViewById(R.id.tvnegative);
        tvhospitalised=itemView.findViewById(R.id.tvhospitalised);
        tvventilator=itemView.findViewById(R.id.tvventilator);
        tvDeaths=itemView.findViewById(R.id.tvdeath);

    }
    public void setData(ResponseModel responseModel){
        tvDate.setText(responseModel.getDate());
        tvpositive.setText(responseModel.getPositive());
        tvnegative.setText(responseModel.getNegative());
        tvhospitalised.setText(responseModel.getHospitalized());
        tvventilator.setText(responseModel.getOnVentilatorCurrently());
        tvDeaths.setText(responseModel.getDeath());
    }

}
