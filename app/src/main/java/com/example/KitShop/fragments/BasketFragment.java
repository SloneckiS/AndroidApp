package com.example.KitShop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.KitShop.Basket;
import com.example.KitShop.BasketAdapter;
import com.example.KitShop.Book;
import com.example.KitShop.CustomAdapter;
import com.example.KitShop.R;

import java.util.ArrayList;
import java.util.List;

public class BasketFragment extends Fragment {
    public BasketFragment(){

    }
    List<String> nameList2 = new ArrayList<>();
    List<String> prices = new ArrayList<>();
    Double totalPrice = 0.0;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basket_list, container, false);
        Bundle arguments = getArguments();
        nameList2 = Basket.products;
        prices = Basket.price;
        System.out.println("----------from fragment name------" + nameList2);
        System.out.println("----------from fragment name------" + Basket.products);
        ListView listView = view.findViewById(R.id.basket_list);
        BasketAdapter basketAdapter = new BasketAdapter(getActivity(),nameList2 , (ArrayList<String>) prices);
        listView.setAdapter(basketAdapter);

        for (String p : prices){
            totalPrice += Double.valueOf(p);
        }
        TextView totalTv = (TextView) view.findViewById(R.id.totalPrice);
        totalTv.setText(String.valueOf(totalPrice));
        Button addToBasketBtn = (Button) view.findViewById(R.id.order);
        addToBasketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderFragment fragment = new OrderFragment();
                Bundle arguments = new Bundle();
                arguments.putDouble( "price" , totalPrice);
                fragment.setArguments(arguments);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });

        return view;
    }
}
