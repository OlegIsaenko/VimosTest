package com.example.vimostest.ProductDetails;

import com.example.vimostest.Model.Product;

public class ProductDetailsPresenter {

    private ProductDetailsView detailsView;

    public ProductDetailsPresenter(ProductDetailsView detailsView) {
        this.detailsView = detailsView;
    }

    public void showProductDetails(Product product) {
        detailsView.showProductDetails(product);
    }
}
