package com.example.vimostest.ProductList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vimostest.ApiService.Options;
import com.example.vimostest.Model.Product;
import com.example.vimostest.ProductDetails.ProductDetailsActivity;
import com.example.vimostest.R;

import java.util.List;

public class ProductListViewActivity extends AppCompatActivity implements ProductListView {

    private ProductListPresenter listPresenter;
    private RecyclerView recyclerView;
    private Options options;
    private View progressBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        progressBarView = findViewById(R.id.progress_bar_layout);

        options = (Options) getIntent().getSerializableExtra("options");

        if (listPresenter == null) {
            listPresenter = new ProductListPresenter(this);
        }

        recyclerView = findViewById(R.id.product_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listPresenter.getProductListFromApi(
                options.getCatId(),
                options.getLimit(),
                options.getOffset(),
                options.getBaseId(),
                options.getSortType()
        );
    }

    @Override
    public void showProductList(List<Product> productList) {
        recyclerView.setAdapter(new ProductListViewAdapter(productList, this));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProductDetails(Product product) {
        getSelectedProductDetails(product);
    }

    private void getSelectedProductDetails(Product product) {
        Intent intent = new Intent(ProductListViewActivity.this, ProductDetailsActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }

    @Override
    public void showProgress() {
        progressBarView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBarView.setVisibility(View.INVISIBLE);
    }


}
