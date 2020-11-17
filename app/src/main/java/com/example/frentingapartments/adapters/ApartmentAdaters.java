package com.example.frentingapartments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.frentingapartments.R;
import com.example.frentingapartments.models.ApartmentModel;
import java.util.ArrayList;

public class ApartmentAdaters extends BaseAdapter {

    private Context context;
    private ArrayList<ApartmentModel>modelArrayList;

    public ApartmentAdaters(Context context, ArrayList<ApartmentModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public ApartmentModel getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.apartment_list_item,viewGroup, false );
        }

        TextView tv_apartment_list_item_description = view.findViewById(R.id.tv_apartment_list_item_description);
        TextView tv_apartment_list_item_code = view.findViewById(R.id.tv_apartment_list_item_code);

        tv_apartment_list_item_description.setText(getItem(position).getDescription());
        tv_apartment_list_item_code.setText(getItem(position).getCode());
        return view;
    }
}
