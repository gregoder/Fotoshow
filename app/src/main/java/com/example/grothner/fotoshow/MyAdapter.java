package com.example.grothner.fotoshow;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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
        mItems.add(new Item("",       R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("", R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("", R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("", R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        mItems.add(new Item("", R.drawable.red));
        mItems.add(new Item("",   R.drawable.magenta));
        mItems.add(new Item("", R.drawable.dark_gray));
        mItems.add(new Item("",      R.drawable.gray));
        mItems.add(new Item("",     R.drawable.green));
        getCameraImages(context);
    }
    public static final String CAMERA_IMAGE_BUCKET_NAME =
            Environment.getExternalStorageDirectory().toString()
                    + "/DCIM/Camera";
    public static final String CAMERA_IMAGE_BUCKET_ID =
            getBucketId(CAMERA_IMAGE_BUCKET_NAME);

    /**
     * Matches code in MediaProvider.computeBucketValues. Should be a common
     * function.
     */
    public static String getBucketId(String path) {
        return String.valueOf(path.toLowerCase().hashCode());
    }

    public static List<String> getCameraImages(Context context) {
        final String[] projection = { MediaStore.Images.Media.DATA };
        final String selection = MediaStore.Images.Media.BUCKET_ID + " = ?";
        final String[] selectionArgs = { CAMERA_IMAGE_BUCKET_ID };
        final Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                selectionArgs,
                null);
        ArrayList<String> result = new ArrayList<String>(cursor.getCount());
        if (cursor.moveToFirst()) {
            final int dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            do {
                final String data = cursor.getString(dataColumn);
                result.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return result;
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
        CheckBox name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.Checkbox, v.findViewById(R.id.Checkbox));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (CheckBox) v.getTag(R.id.Checkbox);

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
