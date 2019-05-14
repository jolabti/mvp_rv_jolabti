package xyz.jncode.jp1.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import xyz.jncode.jp1.Adapter.CustomAdapter;
import xyz.jncode.jp1.Model.Articles;
import xyz.jncode.jp1.Presenter.Mypresenter;
import xyz.jncode.jp1.R;
import xyz.jncode.jp1.Retrofit.GlobalContract;

public class MainActivity extends AppCompatActivity  implements GlobalContract.IMainView{

    SwipeRefreshLayout swp;
    RecyclerView rvComponent;
    ProgressDialog progressDialog;
    Mypresenter mypresenter;
    CustomAdapter adapter;
    AppCompatImageView noconnectionImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swp = findViewById(R.id.swpID);
        rvComponent = (RecyclerView) findViewById(R.id.recyclerID);
        progressDialog = new ProgressDialog(MainActivity.this);
        mypresenter = new Mypresenter(MainActivity.this);
        noconnectionImage = findViewById(R.id.noconnectionimageID);
        noconnectionImage.setVisibility(View.GONE);

        swp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mypresenter.consumePhotos();
            }
        });


        mypresenter.consumePhotos();


    }

    @Override
    public void onProgressStart() {
        progressDialog.setMessage("Processing ...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    public void onProgressOff() {
        progressDialog.dismiss();
        swp.setRefreshing(false);

    }

    @Override
    public void showLog(String trace, String message) {
        noconnectionImage.setVisibility(View.VISIBLE);
        Log.d(trace,message);
    }

    @Override
    public void showToast(Context context, String message) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void generateDataList(ArrayList<Articles> datalist) {
        adapter = new CustomAdapter(this,datalist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL, false);

        rvComponent.setLayoutManager(layoutManager);
        rvComponent.setAdapter(adapter);
    }

//    @Override
//    public void generateDataList(List<ModelNews> datalist) {
//
//        adapter = new CustomAdapter(this,datalist);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL, false);
//
//        rvComponent.setLayoutManager(layoutManager);
//        rvComponent.setAdapter(adapter);
//
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }
}
