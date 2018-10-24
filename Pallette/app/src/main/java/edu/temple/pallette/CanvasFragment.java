package edu.temple.pallette;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends Fragment {

    private static final String Colors = "colorA";
    private String colorsA;


    public CanvasFragment() {
        // Required empty public constructor
    }


    public static CanvasFragment newInstance(String color) {
        CanvasFragment cf = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Colors, color);
        cf.setArguments(bundle);
        return cf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colorsA = getArguments().getString(Colors);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.setBackgroundColor(Color.parseColor(colorsA));
        return inflater.inflate(R.layout.canvas_fragment_layout, container, false);
    }

}
