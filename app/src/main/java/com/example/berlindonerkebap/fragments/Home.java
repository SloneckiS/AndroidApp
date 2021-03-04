package com.example.berlindonerkebap.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.berlindonerkebap.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    Button ButtonFB;
    Button ButtonYT;
    Uri uriYT;
    Uri uriFB;
    private ViewFlipper vFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        vFlipper = view.findViewById(R.id.flipper);
        int images[] = {R.drawable.imag11,R.drawable.image22,R.drawable.image33,R.drawable.image44};
        for(int i: images)
        {
            flipperImages(i);
        }

        ButtonFB = view.findViewById(R.id.btnFb);
        uriFB = Uri.parse("https://www.facebook.com/BerlinDonerKebap");


        ButtonFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, uriFB);
                startActivity(i);
            }
        });


        ButtonYT = view.findViewById(R.id.btyt);
        uriYT = Uri.parse("https://www.youtube.com/channel/UCXrC6VvwSrzl_u8rugMfUGg");


        ButtonYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, uriYT);
                startActivity(i);
            }
        });

        return view;
    }
    public void flipperImages(int image)
    {
        ImageView imageView = new ImageView(getActivity());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(image);
        vFlipper.addView(imageView);
        vFlipper.setFlipInterval(4000);
        vFlipper.setAutoStart(true);
        vFlipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        vFlipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right
        );
    }

}