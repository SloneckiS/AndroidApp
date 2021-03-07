package com.example.KitShop;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<String> nameList;
    List<String> description;
    List<String> prices;
    int flags[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<String> nameList, int[] flags, ArrayList<String> description, ArrayList<String> prices) {
        this.context = applicationContext;
        this.nameList = nameList;
        this.flags = flags;
        this.description = description;
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

        view = inflter.inflate(R.layout.menu_item, null);
        TextView name = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);

        name.setText(nameList.get(i));
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("Name",nameList.get(i));
                intent.putExtra("Desc", description.get(i));
                intent.putExtra("price", prices.get(i));
                intent.putExtra("pic", flags[i]);
                context.startActivity(intent);
            }
        });
        icon.setImageResource(flags[i]);
        return view;
    }
}