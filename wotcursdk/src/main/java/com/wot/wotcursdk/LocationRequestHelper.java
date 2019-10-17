package com.wot.wotcursdk;

import android.content.Context;
import android.location.Location;
import android.preference.PreferenceManager;
import android.util.Log;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;
import java.util.List;

public class LocationRequestHelper {

    public final static String KEY_LOCATION_UPDATES_REQUESTED = "location-updates-requested";

    public static void setRequesting(Context context, boolean value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_LOCATION_UPDATES_REQUESTED, value)
                .apply();
    }

    public static boolean getRequesting(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_LOCATION_UPDATES_REQUESTED, false);
    }

    public static void sendApi(Context context, String userId, List<Location> mlocation, String fcm_token){
        try {
            String urlSend = "";
            for (Location location : mlocation) {
                urlSend = "http://192.168.2.104/locapp/index.php?user_id="+userId+"&latlong="+location.getLatitude()+","+location.getLongitude()+"&fcm_token="+fcm_token;
            }
            Log.e("check",urlSend);
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    urlSend, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("errors", error.toString());
                        }
                    });
            MySingleton.getInstance(context).addtorequestqueue(jsonObjReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
