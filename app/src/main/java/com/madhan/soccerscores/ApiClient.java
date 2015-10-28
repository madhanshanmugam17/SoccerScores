package com.madhan.soccerscores;

import com.madhan.soccerscores.Models.TeamFixtures;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

public class ApiClient {
    private static HDBackendApiInterface sHDBackendService;

    public static HDBackendApiInterface getHDBackendApiClient() {
        if (sHDBackendService == null) {
            String strEndpoint = "http://api.football-data.org";
            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl(strEndpoint)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sHDBackendService = restAdapter.create(HDBackendApiInterface.class);
        }
        return sHDBackendService;
    }

    public interface HDBackendApiInterface {
        @GET("/alpha/soccerseasons/398/fixtures")
        Call<TeamFixtures> getFixtures();
    }
}
