package com.padcmyanmar.padc9.home_rent_application.data.models;


import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.EventsDataAgent;
import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.padc9.home_rent_application.network.dataAgents.RetroFitIDataAgentmpl;

public abstract class BaseModel {

    protected EventsDataAgent mDataAgent;


    BaseModel(){
      //mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
           //mDataAgent = OkHttpDataAgentImpl.getObjInstance();
       mDataAgent = RetroFitIDataAgentmpl.getObjInstance();
    }


}
