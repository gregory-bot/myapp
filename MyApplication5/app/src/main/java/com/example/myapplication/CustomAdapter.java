package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<NewsItem> newsList;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<NewsItem> newsList) {
        this.context = context;
        this.newsList = newsList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView icon = view.findViewById(R.id.icon);
        TextView title = view.findViewById(R.id.title);
        ImageView statusIcon = view.findViewById(R.id.statusIcon);

        NewsItem item = newsList.get(position);

        icon.setImageResource(item.getIconResId());
        title.setText(item.getTitle());
        statusIcon.setImageResource(item.getStatusIconResId());

        return view;
    }
}
