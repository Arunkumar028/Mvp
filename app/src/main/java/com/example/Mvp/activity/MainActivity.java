package com.example.Mvp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.Mvp.mvp.Mvp;
import com.example.Mvp.presenter.Presenter;
import com.example.Mvp.R;
import com.example.Mvp.model.Responcedetails;
import com.example.Mvp.adapter.Custom_adapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Mvp.mainactity {
    RecyclerView recyclerView;
    Custom_adapter custom_adapter;
    Presenter presenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        presenter = new Presenter(MainActivity.this, MainActivity.this);
        presenter.main();
    }

    @Override
    public void success(List<Responcedetails> responcedetails) {
        progressDialog.dismiss();
       // Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show();
        custom_adapter = new Custom_adapter(MainActivity.this, responcedetails);
        recyclerView.setAdapter(custom_adapter);

    }

    @Override
    public void fail(String error) {
        Toast.makeText(this, error + "", Toast.LENGTH_LONG).show();
        progressDialog.dismiss();

    }


}
