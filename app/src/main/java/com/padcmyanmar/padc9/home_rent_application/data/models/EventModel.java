package com.padcmyanmar.padc9.home_rent_application.data.models;

import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;
import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.EventsDataAgent;

import java.util.List;

public interface EventModel {

    void getEvents(GetEventsFromDatalayerDelegate delegate);
    HotelVO findHotelById(int eventId);

    interface GetEventsFromDatalayerDelegate {
        void onSuccess(List<HotelVO> events);
        void onFailure(String errorMessage);
    }
}
