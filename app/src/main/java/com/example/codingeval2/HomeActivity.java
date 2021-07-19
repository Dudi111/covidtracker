package com.example.codingeval2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements ClickListener{
    private RecyclerView recycle;
    private List<ResponseModel> covidlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initt();
        CallApi();
    }

    private void CallApi() {
     Apiservice apiservice=Network.getInstance().create(Apiservice.class);
      String id=recycle.toString();
      apiservice.getposts(id).enqueue(new Callback<List<ResponseModel>>() {
          @Override
          public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {

           Recyclerview();
          }

          @Override
          public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

          }
      });
    }

    private void Recyclerview() {
        CovidAdapter covidAdapter=new CovidAdapter(covidlist,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(covidAdapter);
    }

    private void initt() {
        recycle=findViewById(R.id.Recycler);
    }


    @Override
    public void onitemClicked(ResponseModel responseModel, int position) {

    }
}