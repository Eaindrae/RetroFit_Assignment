package com.padcmyanmar.padc9.home_rent_application.network.dataAgents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.home_rent_application.data.models.EventModel;
import com.padcmyanmar.padc9.home_rent_application.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.home_rent_application.utils.EventConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionDataAgentImpl implements EventsDataAgent{

    private static HttpUrlConnectionDataAgentImpl objInstance;

    private HttpUrlConnectionDataAgentImpl() {

    }

    public static HttpUrlConnectionDataAgentImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new HttpUrlConnectionDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accesstoken,GetEventsFromNetworkDelegate delegate) {
        new GetEventTask(accesstoken,delegate).execute();
    }

    public static class GetEventTask extends AsyncTask<Void, Void, GetEventsResponse> {

        private String accesstoken;
        private GetEventsFromNetworkDelegate eventsResponseDelegate;

        private GetEventTask(String accesstoken,GetEventsFromNetworkDelegate delegate){
            this.accesstoken=accesstoken;
            this.eventsResponseDelegate=delegate;
        }
@Override
        protected GetEventsResponse doInBackground(Void... voids) {
            URL url;
            BufferedReader reader = null;
            StringBuilder stringBuilder;

            try {
                url = new URL(EventConstants.BASE_URL + EventConstants.GET_EVENTS);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");

                connection.setReadTimeout(15*1000);
                connection.setDoInput(true);
                connection.setDoOutput(true);


                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair("access_token", accesstoken));

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();

                connection.connect();

                reader = new BufferedReader((new InputStreamReader(connection.getInputStream())));
                stringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");

                }
                String responseString = stringBuilder.toString();

                GetEventsResponse response = new Gson().fromJson(responseString, GetEventsResponse.class);
                return response;


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
            return null;

        }

        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            boolean first = true;

            for (NameValuePair pair : params) {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));


            }
            return result.toString();
        }

        @Override
        protected void onPostExecute(GetEventsResponse getEventsResponse) {
            super.onPostExecute(getEventsResponse);
            if(getEventsResponse != null) {
                if (getEventsResponse.isResponseOK()) {
                    eventsResponseDelegate.onSuccess(getEventsResponse.getHotelVOList());
                } else {
                    eventsResponseDelegate.onFailure(getEventsResponse.getMessage());
                }
            }else {
                eventsResponseDelegate.onFailure(EventConstants.EM_NULL_EVENT_RESPONESE);
            }
        }
    }
}
