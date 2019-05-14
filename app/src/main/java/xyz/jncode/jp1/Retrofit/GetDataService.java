package xyz.jncode.jp1.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.jncode.jp1.Config.Link;
import xyz.jncode.jp1.Model.ModelNews;

public interface GetDataService {

    @GET(Link.BASE_APIKEY)
    Call<ModelNews> getAllPhotos();
}
