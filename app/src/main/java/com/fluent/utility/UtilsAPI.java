package com.fluent.utility;

public class UtilsAPI {
    public static final String BASE_URL_API = "https://api.fluent.id";

    public UtilsAPI() {
    }

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
