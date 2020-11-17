package com.example.frentingapartments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.frentingapartments.models.ApartmentModel;

import java.util.Locale;

public class DataDetailFragment extends Fragment {

    private static  String code,type,description;
    private boolean active;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_detail, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_data_datail_code, tv_data_datail_type,tv_data_datail_description;

        tv_data_datail_code = view.findViewById(R.id.tv_data_datail_code);
        tv_data_datail_type= view.findViewById(R.id.tv_data_datail_type);
        tv_data_datail_description = view.findViewById(R.id.tv_data_datail_description);

        tv_data_datail_code.setText(code);
        tv_data_datail_type.setText(type);
        tv_data_datail_description.setText(description);


        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DataDetailFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
    static void receiveData(Bundle bundle){
        ApartmentModel model = (ApartmentModel) bundle.getSerializable("model");
        if(model != null){
            code = model.getCode();
            description = model.getDescription();
            type= model.getType();
        }
    }
}