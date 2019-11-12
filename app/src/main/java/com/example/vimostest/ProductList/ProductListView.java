package com.example.vimostest.ProductList;

import com.example.vimostest.Model.Product;

import java.util.List;

public interface ProductListView {

    void showProgress();

    void hideProgress();

    void showProductList(List<Product> productList);

    void showMessage(String message);

    void showProductDetails(Product product);

}
