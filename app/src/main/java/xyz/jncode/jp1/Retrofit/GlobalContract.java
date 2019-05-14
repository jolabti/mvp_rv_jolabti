package xyz.jncode.jp1.Retrofit;

import android.content.Context;

import java.util.ArrayList;

import xyz.jncode.jp1.Model.Articles;

public interface GlobalContract {

    interface IMainView{

        void onProgressStart();
        void onProgressOff();
        void showLog(String trace, String message);
        void showToast(Context context, String message);


        void generateDataList(ArrayList<Articles> datalist);

    }

    interface Presenter{

        void consumePhotos();
        void animateLoading();
        void toastTitle(Context context,String title);

    }

}
