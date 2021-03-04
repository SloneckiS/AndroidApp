package com.example.KitShop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.KitShop.ProductActivity;
import com.example.KitShop.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Salads#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Salads extends Fragment {

    Button btnCezar;
    Button btnGreco;

    public Salads() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salads, container, false);
        btnCezar = view.findViewById(R.id.btnCezar);
        btnCezar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("Name", "SAŁATKA CEZAR");
                intent.putExtra("Desc", "Pyszna sałatka w biodegradowalnym opakowaniu poleca się na spróbowanie.\n" +
                        "\n");
                intent.putExtra("pic",R.drawable.cezar);
                startActivity(intent);
            }
        });

        btnGreco = view.findViewById(R.id.btnGreco);
        btnGreco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("Name", "SAŁATKA GRECO");
                intent.putExtra("Desc", "Mięso do wyboru, ser sałatkowy, oliwki, świeże warzywa, wyborny sos, a wszystko w biodegradowalnym opakowaniu. Spróbuj!");
                intent.putExtra("pic", R.drawable.greco);
                startActivity(intent);
            }
        });


        return view;
    }
}