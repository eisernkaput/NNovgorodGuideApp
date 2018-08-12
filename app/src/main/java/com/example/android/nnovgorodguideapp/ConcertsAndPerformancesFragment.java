package com.example.android.nnovgorodguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConcertsAndPerformancesFragment extends Fragment {


    public ConcertsAndPerformancesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> cAndP = new ArrayList<>();

        cAndP.add(new Place(getContext(), R.string.nizhniy_novgorod_circus_name,
                R.string.nizhniy_novgorod_circus_address,
                R.string.nizhniy_novgorod_circus_email_address,
                R.string.nizhniy_novgorod_circus_tel_num,
                R.string.nizhniy_novgorod_circus_coordinates,
                R.drawable.nizhniy_novgorod_circus));
        cAndP.add(new Place(getContext(), R.string.drama_theater_name,
                R.string.drama_theater_address,
                R.string.drama_theater_email_address,
                R.string.drama_theater_tel_num,
                R.string.drama_theater_coordinates,
                R.drawable.drama_theater));
        cAndP.add(new Place(getContext(), R.string.opera_and_ballet_theater_name,
                R.string.opera_and_ballet_theater_address,
                R.string.opera_and_ballet_theater_email_address,
                R.string.opera_and_ballet_theater_tel_num,
                R.string.opera_and_ballet_theater_coordinates,
                R.drawable.opera_and_ballet_theater));
        cAndP.add(new Place(getContext(), R.string.puppet_theatre_name,
                R.string.puppet_theatre_address,
                R.string.puppet_theatre_email_address,
                R.string.puppet_theatre_tel_num,
                R.string.puppet_theatre_coordinates,
                R.drawable.puppet_theatre));
        cAndP.add(new Place(getContext(), R.string.comedy_theater_name,
                R.string.comedy_theater_address,
                R.string.comedy_theater_email_address,
                R.string.comedy_theater_tel_num,
                R.string.comedy_theater_coordinates,
                R.drawable.comedy_theater));

        GaAdapter itemsAdapter = new GaAdapter(getActivity(), cAndP, R.color.category_concerts_and_performances);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        return rootView;
    }


}
