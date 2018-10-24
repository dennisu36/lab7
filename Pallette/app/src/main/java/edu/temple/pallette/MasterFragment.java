package edu.temple.pallette;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MasterFragment extends Fragment {

    Spinner spinner;
    Context parent;

    public MasterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.parent=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        v.setBackgroundColor(Color.WHITE);
        spinner=v.findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(parent, android.R.layout.simple_list_item_1, parent.getResources().getStringArray(R.array.colorsArray)));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                spinner.setSelection(0);

                String color = (String) adapterView.getItemAtPosition(position);
                ((GetColorInterface)parent).colorSelected(color);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }


    public interface GetColorInterface {
        // TODO: Update argument type and name
        void colorSelected(String color);
    }
}
