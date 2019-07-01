package com.fluent.utility;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {
    // Call http://165.22.105.219:8000/login/
    @FormUrlEncoded
    @POST("login/")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    // Call http://165.22.105.219:8000/users/
    @FormUrlEncoded
    @POST("users/")
    Call<ResponseBody> registerRequest(@Field("username") String username,
                                       @Field("password") String password,
                                       @Field("email") String email);

}
