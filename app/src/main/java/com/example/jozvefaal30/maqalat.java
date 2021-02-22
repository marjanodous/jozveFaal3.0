package com.example.jozvefaal30;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jozvefaal30.adapter.adapter_menu_maqalat;
import com.example.jozvefaal30.model.Item;

import java.util.ArrayList;
import java.util.List;


public class maqalat extends Fragment {

    RecyclerView recyclerView_maqalat;
    List<Item> newItem_maqalat = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_maqalat, null);

        recyclerView_maqalat = rootView.findViewById(R.id.recycler_view_maqalat);
        recyclerView_maqalat.setLayoutManager(new LinearLayoutManager(getActivity()));
        setTakhasosi();
        recyclerView_maqalat.setAdapter(new adapter_menu_maqalat(newItem_maqalat, getActivity()));
        //for HORIZONTAL recyclerView
        recyclerView_maqalat.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return rootView;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setTakhasosi() {
        newItem_maqalat = new ArrayList<>();
        newItem_maqalat.add(new Item(R.drawable.test,
                "درس شبکه های اینترنتی د نظریه",
                "مهندسی نرم افزار",
                "3500",
                "1398/05/09",
                "1399/01/30",
                "tooooziiiiihaaaaat",
                "استاد شفیعی",
                "دانشگاه قدسیه"));
        newItem_maqalat.add(new Item(R.drawable.test,
                "درس شبکه های اینترنتی د نظریه",
                "مهندسی نرم افزار",
                "3500",
                "1398/05/09",
                "1399/01/30",
                "tooooziiiiihaaaaat",
                "استاد شفیعی",
                "دانشگاه قدسیه"));
        newItem_maqalat.add(new Item(R.drawable.test,
                "درس شبکه های اینترنتی د نظریه",
                "مهندسی نرم افزار",
                "3500",
                "1398/05/09",
                "1399/01/30",
                "tooooziiiiihaaaaat",
                "استاد شفیعی",
                "دانشگاه قدسیه"));
        newItem_maqalat.add(new Item(R.drawable.test,
                "درس شبکه های اینترنتی د نظریه",
                "مهندسی نرم افزار",
                "3500",
                "1398/05/09",
                "1399/01/30",
                "tooooziiiiihaaaaat",
                "استاد شفیعی",
                "دانشگاه قدسیه"));
    }

}