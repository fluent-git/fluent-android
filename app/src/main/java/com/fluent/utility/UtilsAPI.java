package com.fluent.utility;

public class UtilsAPI {
    public static final String BASE_URL_API = "http://165.22.105.219:8000";

    public UtilsAPI() {
    }

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
