package com.wot.wotcursdk;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton minstance;
    private RequestQueue requestqueue;
    private static Context mctx;

    private MySingleton(Context context){
        mctx = context;
        requestqueue = getRequestqueue();
    }

    public static synchronized MySingleton getInstance(Context context){
        if(minstance == null){
            minstance = new MySingleton(context);
        }
        return minstance;
    }

    public RequestQueue getRequestqueue() {
        if(requestqueue == null){
            requestqueue = Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestqueue;
    }

    public <T>void addtorequestqueue(Request<T> request){
        requestqueue.add(request);
    }
}

