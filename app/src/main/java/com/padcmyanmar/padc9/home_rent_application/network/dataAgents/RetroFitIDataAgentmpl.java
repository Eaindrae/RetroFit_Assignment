package com.padcmyanmar.padc9.home_rent_application.network.dataAgents;

import com.padcmyanmar.padc9.home_rent_application.network.EventsApi;
import com.padcmyanmar.padc9.home_rent_application.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.home_rent_application.utils.EventConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitIDataAgentmpl implements  EventsDataAgent{
    private static RetroFitIDataAgentmpl objInstance;

    private EventsApi mEventsApi;
    public static RetroFitIDataAgentmpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new RetroFitIDataAgentmpl();
        }
        return objInstance;
    }

    public RetroFitIDataAgentmpl() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EventConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mEventsApi = retrofit.create(EventsApi.class);
    }

    @Override
    public void getEvents(String accesstoken, final GetEventsFromNetworkDelegate delegate) {
       // new RetroFitIDataAgentmpl().GetEventTask(accesstoken, delegate).execute();
        Call<GetEventsResponse> eventscall=mEventsApi.getAllEvents(accesstoken);
        eventscall.enqueue(new Callback<GetEventsResponse>() {
            @Override
            public void onResponse(Call<GetEventsResponse> call, Response<GetEventsResponse> response) {
                GetEventsResponse getEventsResponse=response.body();
                delegate.onSuccess(getEventsResponse.getHotelVOList());
            }

            @Override
            public void onFailure(Call<GetEventsResponse> call, Throwable t) {
                    delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
