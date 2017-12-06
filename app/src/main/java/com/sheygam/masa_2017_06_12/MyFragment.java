package com.sheygam.masa_2017_06_12;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by gregorysheygam on 06/12/2017.
 */

public class MyFragment extends Fragment{
    private FrameLayout root;
    private TextView titleTxt;
    private String defaultTitle;
    private int defaultColor;

    public static MyFragment newInstance(String title, int color){
        MyFragment fragment = new MyFragment();
        fragment.defaultColor = color;
        fragment.defaultTitle = title;
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
            defaultColor = args.getInt("COLOR", Color.BLACK);
            defaultTitle = args.getString("TITLE","No Title");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        root = view.findViewById(R.id.root_container);
        titleTxt = view.findViewById(R.id.title_txt);
        root.setBackgroundColor(defaultColor);
        titleTxt.setText(defaultTitle);
    }

    public void changeColor(int color){
        if(root != null){
            root.setBackgroundColor(color);
        }
    }

    public void changeTitle(String title){
        if(titleTxt != null){
            titleTxt.setText(title);
        }
    }
}
