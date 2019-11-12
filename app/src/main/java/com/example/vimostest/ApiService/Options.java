package com.example.vimostest.ApiService;

import java.io.Serializable;

public class Options implements Serializable {

    public static final String BASE_URL = "http://vimos.ru:1455/";
    public static final String BASE_URL_FOR_IMAGE = "http://vimos.ru";

    private int catId;
    private int limit;
    private int offset;
    private int baseId;
    private int sortType;

    public Options(int catId, int limit, int offset, int baseId, int sortType){
        this.catId = catId;
        this.limit = limit;
        this.offset = offset;
        this.baseId = baseId;
        this.sortType = sortType;
    }

    public int getCatId() {
        return catId;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getBaseId() {
        return baseId;
    }

    public int getSortType() {
        return sortType;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }
}
