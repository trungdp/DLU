package vn.edu.itdlu.a1610234.dhdl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuToolBarAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> data;
    public ResourceBundle res;
    private LayoutInflater inflater;

    public MenuToolBarAdapter(Context context, ArrayList<String> objects) {
        super(context, R.layout.spinner_toolbar, objects);

        this.context = context;
        data = objects;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.spinner_toolbar, parent, false);

        TextView tvCategory = (TextView) row.findViewById(R.id.tvCategory);

        tvCategory.setText(data.get(position).toString());

        return row;
    }
}
