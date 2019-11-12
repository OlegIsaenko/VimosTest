package com.example.vimostest.ProductList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vimostest.ApiService.Options;
import com.example.vimostest.Model.Product;
import com.example.vimostest.R;
import com.jakewharton.rxbinding3.view.RxView;

import java.util.List;
import java.util.Locale;

public class ProductListViewAdapter extends RecyclerView.Adapter<ProductListViewAdapter.ProductHolder> {

    private final List<Product> values;
    private final ProductListView listener;

    public ProductListViewAdapter(List<Product> productList, ProductListView listener) {
        values = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_product_holder, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductHolder holder, final int position) {
        holder.price.setText(String.format(Locale.getDefault(),"%d", values.get(position).getPrice()));
        holder.gCode.setText(String.format("%s", values.get(position).getGcode()));
        holder.name.setText(values.get(position).getName());
        Glide.with(holder.view)
                .load(String.format("%1$s%2$s", Options.BASE_URL_FOR_IMAGE, values.get(position).getImgPreview()))
                .into(holder.image);

        RxView.clicks(holder.view).subscribe(v -> listener.showProductDetails(values.get(position)));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }



    public static class ProductHolder extends RecyclerView.ViewHolder {

        public View view;
        public ImageView image;
        public TextView name;
        public TextView price;
        public TextView gCode;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            image = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            gCode = itemView.findViewById(R.id.product_gcode);
        }
    }
}