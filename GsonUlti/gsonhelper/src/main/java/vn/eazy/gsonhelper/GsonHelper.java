package vn.eazy.gsonhelper;

import com.google.gson.Gson;

/**
 * Created by longzma11 on 1/2/16.
 * TODO this class is created to process json
 */

public class GsonHelper implements IActionGson {
    private static GsonHelper _instance = null;
    private Gson gson;
    public static synchronized GsonHelper getInstance(){
        if(_instance == null){
            _instance = new GsonHelper();
        }
        return _instance;
    }
    public GsonHelper(){
        gson = new Gson();
    }
    @Override
    public void writeObjectToJson(Object o) {
        gson.toJson(o);
    }

    @Override
    public <T> T getObjectfromJson(String json,Class<T> mClass) {
        return gson.fromJson(json,mClass);
    }

}
