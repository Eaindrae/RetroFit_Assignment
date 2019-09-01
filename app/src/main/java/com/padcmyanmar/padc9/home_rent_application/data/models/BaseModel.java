package com.padcmyanmar.padc9.home_rent_application.data.models;

import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.EventsDataAgent;
import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.HttpUrlConnectionDataAgentImpl;

public abstract class BaseModel {
    protected HttpUrlConnectionDataAgentImpl mDataAgent;


    BaseModel(){
        mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
    }


}
