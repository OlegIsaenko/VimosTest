package com.example.vimostest.ProductList;

import com.example.vimostest.ApiService.ApiService;
import com.example.vimostest.App;
import com.example.vimostest.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ProductListPresenter {

    private ProductListView productListView;
    private ApiService apiService;

    public ProductListPresenter(ProductListView productListView) {
        this.productListView = productListView;
        apiService = App.getInstance().getApiService();
    }

    void getProductListFromApi(int catId, int limit, int offset, int baseId, int sortType) {
        productListView.showProgress();
        apiService.getProductList(catId, limit, offset, baseId, sortType).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> products = response.body();
                    productListView.showProductList(products);
                    productListView.hideProgress();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                productListView.showMessage(t.toString());
                productListView.hideProgress();
            }
        });
    }
}
