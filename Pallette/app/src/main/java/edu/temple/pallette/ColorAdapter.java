package edu.temple.pallette;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Locale;

public class ColorAdapter extends BaseAdapter{

    Context context;
    String colors[];

    public ColorAdapter(Context context, String colors[]){
        this.context=context;
        this.colors=colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(Locale.getDefault().getLanguage().equals("en")) {
            TextView theseColors = new TextView(context);
            theseColors.setText(colors[position]);
            theseColors.setBackgroundColor(Color.parseColor(colors[position]));
            return theseColors;
        }
        else{
            Resources res=context.getResources();
            final String[] colors1=res.getStringArray(R.array.array_name1);
            TextView theseColors = new TextView(context);
            theseColors.setText(colors1[position]);
            theseColors.setBackgroundColor(Color.parseColor(colors[position]));
            return theseColors;
        }

    }
}
