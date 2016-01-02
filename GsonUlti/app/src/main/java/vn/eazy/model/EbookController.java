package vn.eazy.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longzma11 on 1/2/16.
 */
public class EbookController {
    @SerializedName("data")
    private List<Ebook> ebooks;
    public EbookController(){
        ebooks = new ArrayList<>();
    }

    public List<Ebook> getEbooks() {
        return ebooks;
    }

    public void setEbooks(List<Ebook> ebooks) {
        this.ebooks = ebooks;
    }
}
