package com.padcmyanmar.padc9.home_rent_application.network.dataAgents;

import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;

import java.util.List;

public interface EventsDataAgent {

    void getEvents(String name,GetEventsFromNetworkDelegate delegate);

    interface GetEventsFromNetworkDelegate{
        void onSuccess(List<HotelVO> events);
        void onFailure(String errorMessage);
    }
}
