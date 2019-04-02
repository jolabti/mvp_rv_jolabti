package xyz.jncode.jp1.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.jncode.jp1.Config.Link;
import xyz.jncode.jp1.Model.ModelPhoto;

public interface GetDataService {

    @GET("/"+ Link.PARAM_PHOTOS)
    Call<List<ModelPhoto>> getAllPhotos();
}
