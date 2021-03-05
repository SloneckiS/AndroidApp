package com.example.KitShop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product);

        TextView tvTitle = (TextView) findViewById(R.id.titlePro);
        tvTitle.setText(getIntent().getStringExtra("Name"));
        TextView tvDesc = (TextView) findViewById(R.id.pDesc);
        tvDesc.setText(getIntent().getStringExtra("Desc"));
        ImageView imBurger = (ImageView) findViewById(R.id.ivproductd);
        imBurger.setImageResource(getIntent().getIntExtra("pic", 1));
        Button addToBasketBtn = (Button) findViewById(R.id.addToBasket);
        addToBasketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("---------ad to basket-----------");
                Basket.products.add(getIntent().getStringExtra("Name"));
                Basket.price.add(getIntent().getStringExtra("price"));
                System.out.println("---------ad to basket-----------" + Basket.products);
                System.out.println("---------ad to basket-----------" + Basket.price);

            }
        });


    }
}
