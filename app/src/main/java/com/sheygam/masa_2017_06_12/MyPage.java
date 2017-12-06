package com.sheygam.masa_2017_06_12;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyPage extends Fragment {

    private int color;
    private String title;
    public MyPage() {
        // Required empty public constructor
    }


    public static MyPage newInctance(String title, int color){
        MyPage fragment = new MyPage();
        fragment.color = color;
        fragment.title = title;
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FrameLayout root = view.findViewById(R.id.root_page_container);
        TextView titleTxt = view.findViewById(R.id.title_txt);
        root.setBackgroundColor(color);
        titleTxt.setText(title);
    }
}
