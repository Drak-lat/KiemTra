package com.example.myfood_letheanh.adapter;
//hiển thij món ăn trong ds
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myfood_letheanh.R;
import com.example.myfood_letheanh.model.FoodModel_LeTheAnh;

import java.util.ArrayList;

public class FoodAdapter_LeTheAnh extends BaseAdapter {
    Context context;
    ArrayList<FoodModel_LeTheAnh> list;

    public FoodAdapter_LeTheAnh(Context context, ArrayList<FoodModel_LeTheAnh> list) {
        this.context = context;
        this.list = list;
    }

    @Override public int getCount() { return list.size(); }
    @Override public Object getItem(int i) { return list.get(i); }
    @Override public long getItemId(int i) { return list.get(i).id; }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_food_list, parent, false);

        FoodModel_LeTheAnh food = list.get(i);
        ((TextView) view.findViewById(R.id.tvFoodName_LeTheAnh)).setText(food.name);
        ((TextView) view.findViewById(R.id.tvSize_LeTheAnh)).setText("Size " + food.size);
        ((TextView) view.findViewById(R.id.tvPrice_LeTheAnh)).setText((int)food.price + " VNĐ");
        ((TextView) view.findViewById(R.id.tvRestaurant_LeTheAnh)).setText(food.restaurantName);


        ((ImageView) view.findViewById(R.id.imgFood_LeTheAnh)).setImageResource(R.drawable.bacsi);

        return view;
    }
}
