package vn.eazy.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by longzma11 on 1/2/16.
 */
public class Ebook {
    @SerializedName("author_name")
    private String author_name;
    @SerializedName("ebook_name")
    private String ebook_name;
    @SerializedName("category_name")
    private String category_name;
    @SerializedName("description")
    private String description;
    @SerializedName("viewed")
    private int viewed;
    @SerializedName("image")
    private String image;


    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getEbook_name() {
        return ebook_name;
    }

    public void setEbook_name(String ebook_name) {
        this.ebook_name = ebook_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
