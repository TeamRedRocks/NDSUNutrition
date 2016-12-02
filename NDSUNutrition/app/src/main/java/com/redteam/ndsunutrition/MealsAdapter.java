package com.redteam.ndsunutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gage.askegard on 11/12/2016.
 * Used to display Meal objects in a list
 */
public class MealsAdapter extends ArrayAdapter
{
    private List list = new ArrayList();

    public MealsAdapter(Context context, int resource)
    {
        super(context,resource);
    }

    // Adds an item to the list
    public void add(Object obj)
    {
        list.add(obj);
    }

    // Get number of items in the list
    public int getCount()
    {
        return this.list.size();
    }

    // Get a specific item from the list
    public Object getItem(int position)
    {
        return this.list.get(position);
    }

    // Gets the view that displays the Meal item as a list item
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.fragment_meal_item, parent, false);

            row.setTag(row.findViewById(R.id.meal_list_item));
        }

        return row;
    }
}
