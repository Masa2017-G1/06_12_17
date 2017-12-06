package com.sheygam.masa_2017_06_12;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ButtonFragment.ButtonFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button changeColorBtn = findViewById(R.id.change_color_btn);
        Button changeTitleBtn = findViewById(R.id.change_text_btn);
        MyFragment  fragment = MyFragment.newInstance("Default",Color.rgb(255,0,0));

        Bundle arguments = new Bundle();
        arguments.putInt("COLOR",Color.rgb(0,255,0));
        arguments.putString("TITLE","My title");
        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(arguments);

        getSupportFragmentManager()
                .beginTransaction()
//                .add(R.id.fragment_container, new MyFragment(),"MY_FRAGMENT")
//                .add(R.id.fragment_container, fragment,"MY_FRAGMENT")
                .add(R.id.fragment_container,myFragment,"MY_FRAGMENT")
                .addToBackStack(null)
                .commit();

        changeColorBtn.setOnClickListener(this);
        changeTitleBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Random rnd = new Random();
        switch (v.getId()){
            case R.id.change_color_btn:
//                int color = Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
//                MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MY_FRAGMENT");
//                if(fragment != null){
//                    fragment.changeColor(color);
//                }

                getSupportFragmentManager().popBackStack("", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.change_text_btn:
                String[] titles = {"Title 1","Title 2", "Title 3","Title 4"};
                MyFragment fragment1 = (MyFragment) getSupportFragmentManager().findFragmentByTag("MY_FRAGMENT");
                if(fragment1 != null){
                    fragment1.changeTitle(titles[rnd.nextInt(titles.length)]);
                }
                break;
        }
    }

    @Override
    public void onColorClicked(int color) {
        MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MY_FRAGMENT");
        if(fragment != null){
            fragment.changeColor(color);
        }
    }

    @Override
    public void onTitleClicked(String title) {

        MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MY_FRAGMENT");
        if(fragment!=null){
            fragment.changeTitle(title);
        }
    }
}
