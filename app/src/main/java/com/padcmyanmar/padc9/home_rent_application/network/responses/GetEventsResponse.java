package com.padcmyanmar.padc9.home_rent_application.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc9.home_rent_application.data.vos.HotelVO;
import com.padcmyanmar.padc9.home_rent_application.utils.EventConstants;

import java.util.List;

public class GetEventsResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<HotelVO> hotelVOList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HotelVO> getHotelVOList() {
        return hotelVOList;
    }

    public void setHotelVOList(List<HotelVO> hotelVOList) {
        this.hotelVOList = hotelVOList;
    }

    public boolean isResponseOK(){
        return code == EventConstants.CODE_RESPONESE_OK && hotelVOList != null;
    }
}
