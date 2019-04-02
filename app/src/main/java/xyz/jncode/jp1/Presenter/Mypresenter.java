package xyz.jncode.jp1.Presenter;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.jncode.jp1.Model.ModelPhoto;
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

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<ModelPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<ModelPhoto>>() {
            @Override
            public void onResponse(Call<List<ModelPhoto>> call, Response<List<ModelPhoto>> response) {

                if(response.isSuccessful()){
                    iMainView.onProgressOff();
                    iMainView.generateDataList(response.body());
                }
                else{

                    iMainView.onProgressOff();
                }

            }

            @Override
            public void onFailure(Call<List<ModelPhoto>> call, Throwable t) {
                    iMainView.onProgressOff();

                    iMainView.showLog("trace_err", t.getMessage().toLowerCase());

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
