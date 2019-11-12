package com.example.vimostest.ApiService;

import com.example.vimostest.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("products")
    Call<List<Product>> getProductList(
            @Query("cat_id") int catId,
            @Query("limit") int limit,
            @Query("offset") int offset,
            @Query("base_id") int baseId,
            @Query("sort_type") int sortType
    );
}
