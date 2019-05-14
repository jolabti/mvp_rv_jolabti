package xyz.jncode.jp1.Presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.jncode.jp1.Model.Articles;
import xyz.jncode.jp1.Model.JSONResponse;
import xyz.jncode.jp1.Model.ModelNews;
import xyz.jncode.jp1.Retrofit.GetDataService;
import xyz.jncode.jp1.Retrofit.GlobalContract;
import xyz.jncode.jp1.Retrofit.RetrofitClientInstance;

public class Mypresenter implements GlobalContract.Presenter{

    GlobalContract.IMainView iMainView;

    public  Mypresenter(GlobalContract.IMainView iMainView){

            this.iMainView = iMainView;
    }

    @Override
    public void consumePhotos() {
        iMainView.onProgressStart();

//        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
//        Call<List<ModelPhoto>> call = service.getAllPhotos();
//        call.enqueue(new Callback<List<ModelPhoto>>() {
//            @Override
//            public void onResponse(Call<List<ModelPhoto>> call, Response<List<ModelPhoto>> response) {
//
//                if(response.isSuccessful()){
//                    iMainView.onProgressOff();
//                    iMainView.generateDataList(response.body());
//                }
//                else{
//
//                    iMainView.onProgressOff();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<ModelPhoto>> call, Throwable t) {
//                    iMainView.onProgressOff();
//
//                    iMainView.showLog("trace_err", t.getMessage().toLowerCase());
//
//            }
//        });


        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ModelNews> call = service.getAllPhotos();
        call.enqueue(new Callback<ModelNews>() {
            @Override
            public void onResponse(Call<ModelNews> call, Response<ModelNews> response) {


                if(response.isSuccessful()){
                    ModelNews modelNews = response.body();
                    Log.d("trace_mymy", modelNews.status);
                    iMainView.generateDataList(modelNews.articles);
                    iMainView.onProgressOff();
                }
                else{

                    iMainView.onProgressOff();
                    Log.d("trace_else", response.message());

                }



            }

            @Override
            public void onFailure(Call<ModelNews> call, Throwable t) {
                iMainView.onProgressOff();
                Log.d("trace_myerer", t.getMessage());
            }
        });
    }

    @Override
    public void animateLoading() {
        iMainView.onProgressStart();
    }

    @Override
    public void toastTitle(Context context,String title) {
        iMainView.showToast(context, title);
    }
}
