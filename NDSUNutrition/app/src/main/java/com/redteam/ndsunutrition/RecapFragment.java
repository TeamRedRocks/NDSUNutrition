package com.redteam.ndsunutrition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RecapFragment extends Fragment
{
    private static final String ARG_SECTION_NUMBER = "section_number";

    public RecapFragment()
    {

    }

    public static Fragment newInstance(int sectionNumber)
    {
        RecapFragment recapFragment = new RecapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        recapFragment.setArguments(args);
        return recapFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_recap, container, false);
        ExpandableListView expListView = (ExpandableListView) rootView.findViewById(R.id.recapList);

        //List for generating day/meals for the corrisponding list item
        List<String> headings = new ArrayList<>();
        //Hashmap for indexing children
        HashMap<String,List<String>> childList = new HashMap<>();

        //These will be generated using a foreach loop for the number of meals for a particular day
        List<String> meal1 = new ArrayList<>();
        List<String> meal2 = new ArrayList<>();
        List<String> meal3 = new ArrayList<>();

        //This will hold the values for the corresponding lists
        String headingItems[] = {"Some day", "Some day","Some day",};
        String firstChild[] = {"First item on list","Second item on list","Third item on list"};
        String secondChild[] = {"First item on list","Second item on list","Third item on list"};
        String thirdChild[] = {"First item on list","Second item on list","Third item on list"};


        // This will populate the Arraylists from the values in the String arrays
        for(String title : headingItems)
        {
            headings.add(title);
        }

        for(String title : firstChild)
        {
            meal1.add(title);
        }
        for(String title: secondChild)
        {
            meal2.add(title);
        }
        for(String title: thirdChild)
        {
            meal3.add(title);
        }


        childList.put(headings.get(0),meal1);
        childList.put(headings.get(1),meal2);
        childList.put(headings.get(2),meal3);


        RecapExpandableListAdapter expAdapter = new RecapExpandableListAdapter(getContext(),headings,childList);
        expListView.setAdapter(expAdapter);

        return rootView;
    }
}
