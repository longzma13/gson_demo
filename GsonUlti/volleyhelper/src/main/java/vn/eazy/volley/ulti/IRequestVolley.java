package vn.eazy.volley.ulti;

import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Created by longzma11 on 1/2/16.
 */
public interface IRequestVolley {
    void getRawDataFromUrl(String url,Response.Listener listener);
    void getRawDataFromUrl(String url,int method,Response.Listener listener);
    void getRawDataFromUrl(String url,Response.Listener listener,Response.ErrorListener errorListener);
    void getRawDataFromUrl(String url,int method,Response.Listener listener,Response.ErrorListener errorListener);

}
