package com.example.vimostest.Model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {

    @SerializedName("gcode")
    @Expose
    private Integer gcode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("old_price")
    @Expose
    private Integer oldPrice;
    @SerializedName("new")
    @Expose
    private Integer _new;
    @SerializedName("has_discount")
    @Expose
    private Integer hasDiscount;
    @SerializedName("is_stocked")
    @Expose
    private Integer isStocked;
    @SerializedName("prior")
    @Expose
    private Integer prior;
    @SerializedName("cat_id")
    @Expose
    private Integer catId;
    @SerializedName("img_preview")
    @Expose
    private String imgPreview;

    public Integer getGcode() {
        return gcode;
    }

    public void setGcode(Integer gcode) {
        this.gcode = gcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getNew() {
        return _new;
    }

    public void setNew(Integer _new) {
        this._new = _new;
    }

    public Integer getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(Integer hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public Integer getIsStocked() {
        return isStocked;
    }

    public void setIsStocked(Integer isStocked) {
        this.isStocked = isStocked;
    }

    public Integer getPrior() {
        return prior;
    }

    public void setPrior(Integer prior) {
        this.prior = prior;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getImgPreview() {
        return imgPreview;
    }

    public void setImgPreview(String imgPreview) {
        this.imgPreview = imgPreview;
    }


    @NonNull
    @Override
    public String toString() {
        return name + ", " + gcode + ", " + price;
    }
}
