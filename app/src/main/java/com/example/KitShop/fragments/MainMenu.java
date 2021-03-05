package com.example.KitShop.fragments;

import android.os.Bundle;

import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.KitShop.Book;
import com.example.KitShop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainMenu extends Fragment {
    CardView horror;
    CardView fantasy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        horror = view.findViewById(R.id.kebapmenu);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<String> prices = new ArrayList<>();
        String category;
        ArrayList<Book> books = new ArrayList<>();
        horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Książka").whereEqualTo("Kategoria", "1")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        System.out.println("-----data-" + document.getData());
                                        description.add(String.valueOf(document.getData().get("Opis")));
                                        prices.add(String.valueOf(document.getData().get("Cena")));
                                        names.add(String.valueOf(document.getData().get("Tytuł")));

                                    }
                                    MenuList fragment = new MenuList();
                                    Bundle arguments = new Bundle();
                                    System.out.println("Desc----" + description);
                                    arguments.putStringArrayList( "names" , names);
                                    arguments.putStringArrayList( "dsc" , description);
                                    arguments.putStringArrayList( "price" , prices);
                                    arguments.putString( "category" , "1");
                                    fragment.setArguments(arguments);
                                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                                    ft.replace(R.id.fragment_container, fragment);
                                    ft.commit();
                                } else {
                                    System.out.println("----------nie dziala-----------");
                                }
                            }
                        });

//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, new MenuList());
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });

        fantasy = view.findViewById(R.id.salatki);
        fantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Książka").whereEqualTo("Kategoria", "2")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        System.out.println("-----data-" + document.getData());
                                        description.add(String.valueOf(document.getData().get("Opis")));
                                        prices.add(String.valueOf(document.getData().get("Cena")));
                                        names.add(String.valueOf(document.getData().get("Tytuł")));

                                    }
                                    MenuList fragment = new MenuList();
                                    Bundle arguments = new Bundle();
                                    arguments.putStringArrayList( "names" , names);
                                    arguments.putStringArrayList( "dsc" , description);
                                    arguments.putStringArrayList( "price" , prices);
                                    arguments.putString( "category" , "2");
                                    fragment.setArguments(arguments);
                                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                                    ft.replace(R.id.fragment_container, fragment);
                                    ft.commit();
                                } else {
                                    System.out.println("----------nie dziala-----------");
                                }
                            }
                        });
            }
        });

        return view;
    }
}
