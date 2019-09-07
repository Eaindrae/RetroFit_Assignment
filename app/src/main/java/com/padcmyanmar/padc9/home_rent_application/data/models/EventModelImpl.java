package com.padcmyanmar.padc9.home_rent_application.data.models;

import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;
import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.EventsDataAgent;
import com.padcmyanmar.padc9.home_rent_application.utils.EventConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventModelImpl extends BaseModel implements EventModel {

    private Map<Integer, HotelVO> eventsDataRepository;

    private static EventModelImpl objInstance;

    private EventModelImpl() {
        eventsDataRepository = new HashMap<>();
    }

    public static EventModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new EventModelImpl();
        }
        return objInstance;
    }

    public List<HotelVO> getAllEvents() {
        return null;
    }


    @Override
    public void getEvents(final EventModel.GetEventsFromDatalayerDelegate delegate) {
        mDataAgent.getEvents(EventConstants.DUMMY_ACCESS_TOKEN, new EventsDataAgent.GetEventsFromNetworkDelegate() {
            @Override
            public void onSuccess(List<HotelVO> hotelevents) {
                for (HotelVO event : hotelevents) {
                    eventsDataRepository.put(event.getId(), event);
                }
                delegate.onSuccess(hotelevents);
            }

            @Override
            public void onFailure(String errorMessage) {
                delegate.onFailure(errorMessage);
            }
        }

        );
    }

    @Override
    public HotelVO findHotelById(int eventId) {
        HotelVO event = eventsDataRepository.get(eventId);
        return event;
    }


    public List<HotelVO> getDataRepository(){
        List<HotelVO> hotelVOList = new ArrayList<>(eventsDataRepository.values());
        return hotelVOList;
    }

    public List<HotelVO> findHouseByName(String name){
        List<HotelVO> hoteleInfoVOList = new ArrayList<>(eventsDataRepository.values());
        List<HotelVO> returnList = new ArrayList<>();
        for (HotelVO hotelInfoVO : hoteleInfoVOList) {
            if(hotelInfoVO.getName().contains(name)){
                returnList.add(hotelInfoVO);
            }
        }
        return returnList;
    }
}
