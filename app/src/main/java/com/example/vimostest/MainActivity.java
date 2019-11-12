package com.example.vimostest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vimostest.ApiService.Options;
import com.example.vimostest.ProductList.ProductListViewActivity;
import com.jakewharton.rxbinding3.view.RxView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button productListButton = findViewById(R.id.product_list_button);
        RxView.clicks(productListButton).subscribe(v -> getProductListWithOptions());
    }

    private void getProductListWithOptions() {
        Intent intent = new Intent(MainActivity.this, ProductListViewActivity.class);
        Options options = getQueryParameters();
        intent.putExtra("options", options);
        startActivity(intent);
    }

    private Options getQueryParameters() {
        return new Options(getCatId(), getLimit(), getOffset(), getBaseId(), getSortType());
    }

    public int getCatId() {
        int catId = 7;
        return catId;
    }

    public int getLimit() {
        int limit = 10;
        return limit;
    }

    public int getOffset() {
        int offset = 0;
        return offset;
    }

    public int getBaseId() {
        int baseId = 12;
        return baseId;
    }

    public int getSortType() {
        int sortType = 0;
        return sortType;
    }


}
