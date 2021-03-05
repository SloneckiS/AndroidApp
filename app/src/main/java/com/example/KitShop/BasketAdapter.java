package com.example.KitShop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  BasketAdapter extends BaseAdapter {
    Context context;
    List<String> nameList;
    List<String> prices;
    LayoutInflater inflter;

    public BasketAdapter(Context applicationContext, List<String> nameList, ArrayList<String> prices) {
        this.context = applicationContext;
        this.nameList = nameList;
        this.prices = prices;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflter.inflate(R.layout.basket_item, null);
        TextView name = (TextView) view.findViewById(R.id.basket_text);
        TextView price = (TextView) view.findViewById(R.id.basket_price);

        name.setText(nameList.get(i));

        price.setText(prices.get(i));
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Map<String, Object> user = new HashMap<>();
                user.put("ksiazka", "1");

//                db.collection("zamówienia")
//                        .add(user)
//                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(DocumentReference documentReference) {
//                                Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w("TAG", "Error adding document", e);
//                            }
//                        });
//                Intent intent = new Intent(context, ProductActivity.class);
//                intent.putExtra("Name",nameList.get(i));
//                intent.putExtra("Desc", description.get(i));
//                intent.putExtra("pic", flags[i]);
//                context.startActivity(intent);
            }
        });
        return view;
    }

}
