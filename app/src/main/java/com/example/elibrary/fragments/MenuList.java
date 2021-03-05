package com.example.elibrary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.elibrary.CustomAdapter;
import com.example.elibrary.R;

public class MenuList extends Fragment {
    public MenuList(){

    }
    String countryList[] = {"India", "China"};
    int flags[] = {R.drawable.cezar, R.drawable.chicken};
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_list, container, false);

        ListView listView = view.findViewById(R.id.menu_list);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), countryList, flags);
        listView.setAdapter(customAdapter);
        listView.setAdapter(customAdapter);

        return view;
    }
}
