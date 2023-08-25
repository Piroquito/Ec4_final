package com.edder.ec4_edder.data.retrofit;

import com.edder.ec4_edder.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesInterface {

    @GET("0b5975c8-5c17-4247-b091-8144ba36e96e")
    Call<ShowResponse> getShows();
}
