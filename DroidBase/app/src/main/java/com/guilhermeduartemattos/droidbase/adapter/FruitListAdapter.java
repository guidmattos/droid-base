package com.guilhermeduartemattos.droidbase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.guilhermeduartemattos.droidbase.R;
import com.guilhermeduartemattos.droidbase.model.Fruit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by guilhermeduartemattos on 6/4/15.
 */
public class FruitListAdapter extends ArrayAdapter<Fruit> {


    private final Context context;
    private final int resource;
    private final ArrayList<Fruit> fruits;

    public FruitListAdapter(Context context, int resource, ArrayList fruits) {
        super(context, resource, fruits);
        this.context = context;
        this.resource = resource;
        this.fruits = fruits;
    }

    public int getCount() {
        if (fruits != null)
            return fruits.size();
        return 0;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Fruit fruit = getItem(position);
        View v = convertView;
        ListViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater li = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(resource, null);
            viewHolder = new ListViewHolder(v);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ListViewHolder) v.getTag();
        }

        viewHolder.textViewTitle.setText(fruit.getTitle());
        viewHolder.textViewDescription.setText(fruit.getDescription());
        viewHolder.textViewValue.setText(String.valueOf(fruit.getValue()));

        String imageUrl = fruit.getImgUrl();
        if (imageUrl != null) {
            Picasso.with(context).load(imageUrl).into(viewHolder.imageView);
        }

        return v;
    }

    class ListViewHolder {

        public TextView textViewTitle;
        public TextView textViewDescription;
        public TextView textViewValue;
        public ImageView imageView;

        public ListViewHolder(View base) {

            textViewTitle = (TextView) base.findViewById(R.id.text_view_title);
            textViewDescription = (TextView) base.findViewById(R.id.text_view_description);
            textViewValue = (TextView) base.findViewById(R.id.text_view_value);
            imageView = (ImageView) base.findViewById(R.id.image_view);
        }
    }


}
