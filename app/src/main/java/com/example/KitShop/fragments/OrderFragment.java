package com.example.KitShop.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.KitShop.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderFragment extends Fragment {
    public OrderFragment(){

    }
    Double totalPrice;
    EditText nameTv;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment, container, false);

        Bundle arguments = getArguments();
        totalPrice = arguments.getDouble("price");
        nameTv = (EditText) view.findViewById(R.id.nameOrder);
        EditText adressTv = (EditText) view.findViewById(R.id.adres);
        System.out.println("get text " + nameTv.getText());
        String name = nameTv.getText().toString();
        String adress = String.valueOf(adressTv.getText());
        System.out.println("----name-----" + name);
        Button doOrder = (Button) view.findViewById(R.id.orderFinal);
        doOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> order = new HashMap<>();
                order.put("total_price", totalPrice);
                order.put("name", name);
                order.put("address", adress);
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Zamówienia")
                        .add(order)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error adding document", e);
                            }
                        });
            }
        });
        return view;
    }


}
