package com.redteam.ndsunutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by gage.askegard on 10/29/2016.
 * This is an adapter class to display a range of dates in a spinner
 */
public class CalendarSpinnerAdapter extends BaseAdapter
{
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("MM/d/yyyy");
    private LayoutInflater mInflater;
    private Calendar mCalendar;
    private int mDayCount;
    private int mLastRequestedDay = 0;

    // Creates a list of calendar days starting from the current day up through dayCount + current day
    public CalendarSpinnerAdapter(Context context, Calendar startDate, int dayCount) {
        mInflater = LayoutInflater.from(context);
        mDayCount = dayCount;
        mCalendar = Calendar.getInstance();
        mCalendar.add(Calendar.DAY_OF_YEAR, -29);// Get the past 29 days
    }

    @Override
    public int getCount() {
        return mDayCount;
    }

    @Override
    public Calendar getItem(int position) {
        mCalendar.add(Calendar.DAY_OF_YEAR, position - mLastRequestedDay);
        mLastRequestedDay = position;
        return mCalendar;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Returns the view for the values of the date spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        Calendar item = getItem(position);
        ((TextView) convertView).setText(mDateFormat.format(item.getTimeInMillis()));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
