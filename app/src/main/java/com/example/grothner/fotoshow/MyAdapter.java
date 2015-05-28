package com.example.grothner.fotoshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grothner on 28.05.2015.
 */
public final class MyAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item("",       R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("",      R.drawable.cyan));
        mItems.add(new Item("",       R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("",      R.drawable.cyan));  mItems.add(new Item("",       R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("",      R.drawable.cyan));  mItems.add(new Item("",       R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("",      R.drawable.cyan));  mItems.add(new Item("",       R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("",      R.drawable.cyan));  mItems.add(new Item("",       R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}
