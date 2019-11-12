package com.example.vimostest.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vimostest.ApiService.Options;
import com.example.vimostest.Model.Product;
import com.example.vimostest.R;

public class ProductDetailsActivity extends AppCompatActivity implements ProductDetailsView {

    private ProductDetailsPresenter detailsPresenter;

    private ImageView image;
    private TextView name;
    private TextView price;
    private TextView gCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        name = findViewById(R.id.product_name);
        price = findViewById(R.id.details_price);
        gCode = findViewById(R.id.details_gcode);
        image = findViewById(R.id.details_image);

        if (detailsPresenter == null) {
            detailsPresenter = new ProductDetailsPresenter(this);
        }

        Product product = (Product) getIntent().getSerializableExtra("product");
        detailsPresenter.showProductDetails(product);
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
    public void showProductDetails(Product product) {
        name.setText(product.getName());
        price.setText(String.format("%s", product.getPrice()));
        gCode.setText(String.format("%s", product.getGcode()));
        Glide.with(this)
                .load(String.format("%1$s%2$s", Options.BASE_URL_FOR_IMAGE, product.getImgPreview()))
                .into(image);
    }
}
