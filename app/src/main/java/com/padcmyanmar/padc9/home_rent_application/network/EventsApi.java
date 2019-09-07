package com.padcmyanmar.padc9.home_rent_application.network;

import com.padcmyanmar.padc9.home_rent_application.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.home_rent_application.utils.EventConstants;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EventsApi {
    @FormUrlEncoded
    @POST(EventConstants.GET_EVENTS)
    Call<GetEventsResponse> getAllEvents(@Field(EventConstants.PARAM_ACCESS_TOKEN) String accessToken);
}
