package com.example.jozvefaal30;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jozvefaal30.adapter.adapter_menu_omumi;
import com.example.jozvefaal30.model.Item;

import java.util.ArrayList;
import java.util.List;

public class omumi extends Fragment {

    RecyclerView recyclerView_omumi;
    List<Item> newItem = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_omumi, null);


        recyclerView_omumi = rootView.findViewById(R.id.recycler_view_omumi);
        recyclerView_omumi.setLayoutManager(new LinearLayoutManager(getActivity()));
        setOmumi();
        recyclerView_omumi.setAdapter(new adapter_menu_omumi(newItem, getActivity()));
        //for HORIZONTAL recyclerView
        recyclerView_omumi.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return rootView;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setOmumi() {
        newItem = new ArrayList<>();
        newItem.add(new Item(R.drawable.test,
                "درس شبکه های اینترنتی د نظریه",
                "مهندسی نرم افزار",
                "3500",
                "1398/05/09",
                "1399/01/30",
                "tooooziiiiihaaaaat",
                "استاد شفیعی",
                "دانشگاه قدسیه"));
        newItem.add(new Item(R.drawable.test,
                "درس شبکه های اینترنتی د نظریه",
                "مهندسی نرم افزار",
                "3500",
                "1398/05/09",
                "1399/01/30",
                "tooooziiiiihaaaaat",
                "استاد شفیعی",
                "دانشگاه قدسیه"));
        newItem.add(new Item(R.drawable.test,
                "درس شبکه های اینترنتی د نظریه",
                "مهندسی نرم افزار",
                "3500",
                "1398/05/09",
                "1399/01/30",
                "tooooziiiiihaaaaat",
                "استاد شفیعی",
                "دانشگاه قدسیه"));
        newItem.add(new Item(R.drawable.test,
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