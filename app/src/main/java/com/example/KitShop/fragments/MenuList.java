package com.example.KitShop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.KitShop.Book;
import com.example.KitShop.CustomAdapter;
import com.example.KitShop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MenuList extends Fragment {
    public MenuList(){

    }
    List<String> nameList2 = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    ArrayList<String> prices = new ArrayList<>();
    String category;
    ArrayList<Book> books = new ArrayList<>();
    int images[] = {R.drawable.zew_cth,R.drawable.smetarz,R.drawable.to,R.drawable.dwadziescia,R.drawable.necronomicon};
    int images2[] = {R.drawable.miecz,R.drawable.hobbit,R.drawable.cud,R.drawable.klopotliwy,R.drawable.krew_elfow};
    Boolean isCompleted = false;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_list, container, false);
        Bundle arguments = getArguments();
        nameList2 = arguments.getStringArrayList("names");
        description = arguments.getStringArrayList("dsc");
        prices = arguments.getStringArrayList("price");
        category = arguments.getString("category");
        ListView listView = view.findViewById(R.id.menu_list);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(),nameList2 , "1".equals(category) ? images : images2,description,prices);
        listView.setAdapter(customAdapter);
        return view;
    }
}
