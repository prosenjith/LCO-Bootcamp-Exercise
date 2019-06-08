package com.studycseathome.jsonapivolleypicasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL="https://api.github.com/";
    @GET("users")
    Call<List<User>> getUsers();
}
