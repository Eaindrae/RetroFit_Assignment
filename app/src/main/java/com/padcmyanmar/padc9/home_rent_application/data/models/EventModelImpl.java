package com.padcmyanmar.padc9.home_rent_application.data.models;

import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;
import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.EventsDataAgent;
import com.padcmyanmar.padc9.home_rent_application.utils.EventConstants;

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
            public void onSuccess(List<HotelVO> events) {
                for (HotelVO event : events) {
                    eventsDataRepository.put(event.getId(), event);
                }
                delegate.onSuccess(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                delegate.onFailure(errorMessage);
            }
        }

        );
    }

}
