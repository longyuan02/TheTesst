package com.mazhan.theone.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mazhan.theone.R;

import java.util.List;

/**
 * Created by dragonfly on 2017/4/26.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context lcontext;
    private List<String> list;
    private LayoutInflater inflater;

    public ListViewAdapter(Context context) {
        this.lcontext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_listviewtest, null);
            viewHolder.tv_1 = (TextView) convertView.findViewById(R.id.tv_1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String data = list.get(position);
        viewHolder.tv_1.setText(data);
        return convertView;
    }

    private class ViewHolder {
        TextView tv_1;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
