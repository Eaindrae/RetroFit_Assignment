package com.padcmyanmar.padc9.home_rent_application.network.dataAgents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.home_rent_application.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.home_rent_application.utils.EventConstants;


import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpDataAgentImpl implements EventsDataAgent {
    private static OkHttpDataAgentImpl objInstance;
    private static OkHttpClient okHttpClient;

    public OkHttpDataAgentImpl() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }


    public static OkHttpDataAgentImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accesstoken, GetEventsFromNetworkDelegate delegate) {
        new GetEventTask(okHttpClient, accesstoken, delegate).execute();
    }

    public static class GetEventTask extends AsyncTask<Void, Void, GetEventsResponse> {

        private OkHttpClient mOkHttpCllient;
        private String mAccesstoken;
        private GetEventsFromNetworkDelegate mDelegate;

        private GetEventTask(OkHttpClient okHttpClient, String accesstoken, GetEventsFromNetworkDelegate delegate) {
            this.mOkHttpCllient=okHttpClient;
           this.mAccesstoken = accesstoken;
            this.mDelegate = delegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            RequestBody formBody =  new FormBody.Builder()
                    .add(EventConstants.PARAM_ACCESS_TOKEN,mAccesstoken)
                    .build();

            Request request=new Request.Builder()
                    .url(EventConstants.BASE_URL + EventConstants.GET_EVENTS)
                    .post(formBody)
                    .build();

            try {
                Response response =mOkHttpCllient.newCall(request).execute();

                if (response.isSuccessful()) {

                    String responseString = response.body().string();

                    GetEventsResponse getEventsResponse =new Gson().fromJson(responseString, GetEventsResponse.class);
                    return getEventsResponse;
                }
            }catch (Exception e){

            }
            return  null;
        }

        @Override
        protected void onPostExecute(GetEventsResponse getEventsResponse) {
            super.onPostExecute(getEventsResponse);
            if(getEventsResponse != null) {
                if (getEventsResponse.isResponseOK()) {
                    mDelegate.onSuccess(getEventsResponse.getHotelVOList());
                } else {
                    mDelegate.onFailure(getEventsResponse.getMessage());
                }
            }else {
                mDelegate.onFailure(EventConstants.EM_NULL_EVENT_RESPONESE);
            }
        }
    }
}
