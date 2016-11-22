package com.redteam.ndsunutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaron on 11/3/2016.
 */

public class RecommendationAdapter extends ArrayAdapter{

    //Manipulated list
    private List list = new ArrayList();

    //Constructor
    public RecommendationAdapter(Context context, int resource)
    {
        super(context,resource);
    }

    //Accessor for the count of the list
    public int getCount()
    {
        return this.list.size();
    }

    //Accessor for a particular position
    public Object getItem(int position)
    {
        return this.list.get(position);
    }

    //Add override
    @Override
    public void add(Object obj)
    {
        list.add(obj);
    }

    //Override to get the current view
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.fragment_recommendation_item, parent, false);

            row.setTag(row.findViewById(R.id.recommendationListItem));
        }

        return row;
    }

}
