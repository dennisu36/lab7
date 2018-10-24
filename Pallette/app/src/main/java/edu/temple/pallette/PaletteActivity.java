package edu.temple.pallette;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity implements MasterFragment.GetColorInterface{

    final public String Colors = "";

    MasterFragment mf;
    CanvasFragment cf;
    FragmentManager fm;
    boolean singlePane;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        singlePane = findViewById(R.id.container_2)==null;

        cf=new CanvasFragment();
        fm=getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.container_1, cf)
                .commit();



    }

    @Override
    public void colorSelected(String color){
        if(singlePane){
            CanvasFragment newFragment=CanvasFragment.newInstance(color);
            fm.beginTransaction()
                    .replace(R.id.container_1, newFragment)
                    .addToBackStack(null)
                    .commit();
        }
        else{
            CanvasFragment newFragment=CanvasFragment.newInstance(color);
            fm.beginTransaction()
                    .replace(R.id.container_2, newFragment)
                    .addToBackStack(null)
                    .commit();
        }

    }
}