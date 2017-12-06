package com.sheygam.masa_2017_06_12;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

/**
 * Created by gregorysheygam on 06/12/2017.
 */

public class ButtonFragment extends Fragment implements View.OnClickListener {
    private Button changeColorBtn, changeTitleBtn;
    private String[] titles = {"Title 1","Title 2","Title 3","Title 4"};
    private ButtonFragmentListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (ButtonFragmentListener) activity;
        }catch (ClassCastException ex){
            throw new RuntimeException(activity.getClass().getName() + " Must implement ButtonFragmentListener!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeColorBtn = view.findViewById(R.id.fr_change_color_btn);
        changeTitleBtn = view.findViewById(R.id.fr_change_title_btn);
        changeTitleBtn.setOnClickListener(this);
        changeColorBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fr_change_color_btn){
            Random rnd = new Random();
            int color = Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
            listener.onColorClicked(color);

        }else if(v.getId() == R.id.fr_change_title_btn){
            Random rnd = new Random();
            listener.onTitleClicked(titles[rnd.nextInt(titles.length)]);
        }
    }

    public interface ButtonFragmentListener{
        void onColorClicked(int color);
        void onTitleClicked(String title);
    }
}
