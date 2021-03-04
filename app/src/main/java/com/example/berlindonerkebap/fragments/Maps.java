package com.example.berlindonerkebap.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.berlindonerkebap.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends Fragment {


    public Maps() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear();
                LatLng latLng = new LatLng(51.76896759582092, 19.49617764133081);
                LatLng latLng2 = new LatLng(51.784262107129905, 19.447769136961778);
                LatLng latLng3 = new LatLng(51.762168371221634, 19.466995209618982);
                CameraPosition googlePlex = CameraPosition.builder()
                        .target(latLng3)
                        .zoom(12)
                        .bearing(0)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 1, null);

                mMap.addMarker(new MarkerOptions()
                        .position(latLng3)
                        .title("Berlin Döner Kebap - Galeria Łódzka"));
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Berlin Döner Kebap - Tulipan"));
                mMap.addMarker(new MarkerOptions()
                        .position(latLng2)
                        .title("Berlin Döner Kebap - Manufaktura"));

            }
        });


        return rootView;
    }
}