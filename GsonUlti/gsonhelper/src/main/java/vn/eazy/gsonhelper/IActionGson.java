package vn.eazy.gsonhelper;

/**
 * Created by longzma11 on 1/2/16.
 */
public interface IActionGson {
    void writeObjectToJson(Object o);
    <T> T getObjectfromJson(String json, Class<T> _class);
}
