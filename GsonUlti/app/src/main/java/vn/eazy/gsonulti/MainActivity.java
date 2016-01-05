package vn.eazy.gsonulti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;

import vn.eazy.gsonhelper.GsonHelper;
import vn.eazy.model.Ebook;
import vn.eazy.model.EbookController;
import vn.eazy.volley.ulti.VolleyHelper;

public class MainActivity extends AppCompatActivity {
    private final String API = "http://eazybook.esy.es/public/api/ebook";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VolleyHelper.getInstance(getBaseContext()).getRawDataFromUrl(API, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                Log.v("debug",response.toString());
                EbookController ebookController = GsonHelper.getInstance().getObjectfromJson(response.toString(),EbookController.class);
                for(Ebook ebook : ebookController.getEbooks()){
                    Log.v("debug","name ebook:" +ebook.getEbook_name());
                }
            }
        });
    }
}
