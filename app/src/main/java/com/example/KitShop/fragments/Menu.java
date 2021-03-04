package com.example.KitShop.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.KitShop.ProductActivity;
import com.example.KitShop.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Products#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {

    Button btnRoll;
    Button btnRollo;
    Button btnBox;
    private ListView list ;
    private ArrayAdapter<String> adapter ;
    public Menu() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        btnRoll = view.findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("Name", "KEBAP W BUŁCE");
                intent.putExtra("Desc", "Absolutna klasyka gatunku i jedna z naszych najpopularniejszych potraw. Jej smak to kombinacja chrupiącego pieczywa, świeżo krojonych warzyw, oryginalnych sosów i oczywiście jednego z naszych wyjątkowych mięs. Kebap w bułce był pierwszą potrawą, którą serwowaliśmy naszym klientom.\n" +
                        "\n" +
                        "Jeśli wolisz naszą bułkę bez warzyw, spróbuj wersji z frytkami.");
                intent.putExtra("pic",R.drawable.kebab_w_bulce);
                System.out.println("halko");
                startActivity(intent);
            }
        });
        btnRollo = view.findViewById(R.id.btnRollo);
        btnRollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("Name", "ROLLO KEBAP");
                intent.putExtra("Desc", "Bywa nazywany także durum, roladą, rolką etc. Jednak to my, w 1998 roku użyliśmy nazwy ROLLO po raz pierwszy. Dziś to już klasyczna forma naszej potrawy. Świeże warzywa, oryginalne sosy i nasze wyjątkowe mięso, zawinięte w pszenną lub wieloziarnistą tortillę do wyboru.\n" +
                        "\n" +
                        "Jeśli wolisz nasze rollo bez warzyw, spróbuj wersji z frytkami");
                intent.putExtra("pic", R.drawable.rollo_kebap);
                startActivity(intent);
            }
        });
        btnBox = view.findViewById(R.id.btnBox);
        btnBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("Name", "KEBAP BOX");
                intent.putExtra("Desc", "Nasz pomysł, na potrawę łatwą do zabrania ze sobą wszędzie tam, gdzie ceni się smak. W poręcznym opakowaniu odnajdziecie zestaw świeżo krojonych warzyw, wyjątkowych mięs do wyboru i złocistych frytek.");
                intent.putExtra("pic", R.drawable.kebap_box);
                startActivity(intent);
            }
        });



        return view;
    }
}