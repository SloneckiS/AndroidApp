//package com.example.berlindonerkebap;
//
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Product extends AppCompatActivity {
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_product);
//
//        TextView tvTitle = (TextView)findViewById(R.id.titlePro);
//        tvTitle.setText( getIntent().getStringExtra("Name"));
//        TextView tvDesc = (TextView)findViewById(R.id.pDesc);
//        tvDesc.setText( getIntent().getStringExtra("Desc"));
//        ImageView imBurger = (ImageView) findViewById(R.id.ivproductd);
//        imBurger.setImageResource(getIntent().getIntExtra("pic",1));
//    }
//}
