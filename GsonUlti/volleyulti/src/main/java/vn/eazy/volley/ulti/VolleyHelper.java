package vn.eazy.volley.ulti;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by longzma11 on 1/2/16.
 */
public class VolleyHelper implements IRequestVolley,Response.ErrorListener{
    private static VolleyHelper _instance = null;
    private static Context mContext;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private VolleyHelper(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
        mRequestQueue = getRequestQueue();
        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized VolleyHelper getInstance(Context context) {
        if (_instance == null) {
            _instance = new VolleyHelper(context);
        }
        return _instance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    @Override
    public void getRawDataFromUrl(String url, Response.Listener listener) {
        addToRequestQueue(new StringRequest(url,listener,this));
    }

    @Override
    public void getRawDataFromUrl(String url, int method, Response.Listener listener) {
        addToRequestQueue(new StringRequest(method,url,listener,this));
    }

    @Override
    public void getRawDataFromUrl(String url, Response.Listener listener, Response.ErrorListener errorListener) {
        addToRequestQueue(new StringRequest(url,listener,errorListener));
    }

    @Override
    public void getRawDataFromUrl(String url, int method, Response.Listener listener, Response.ErrorListener errorListener) {
        addToRequestQueue(new StringRequest(method,url,listener,errorListener));
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Log.v(getClass().getSimpleName(),"Error volley:" + error.getLocalizedMessage());
    }
}
