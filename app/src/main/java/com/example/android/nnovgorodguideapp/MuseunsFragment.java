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
public class MuseunsFragment extends Fragment {


    public MuseunsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> museums = new ArrayList<>();

        museums.add(new Place(getContext(), R.string.museum_of_old_equipment_and_tools_name,
                R.string.museum_of_old_equipment_and_tools_address,
                R.string.museum_of_old_equipment_and_tools_email_address,
                R.string.museum_of_old_equipment_and_tools_tel_num,
                R.string.museum_of_old_equipment_and_tools_coordinates,
                R.drawable.museum_of_old_equipment_and_tools));
        museums.add(new Place(getContext(), R.string.rukavishnikovykh_usadba_name,
                R.string.rukavishnikovykh_usadba_address,
                R.string.rukavishnikovykh_usadba_email_address,
                R.string.rukavishnikovykh_usadba_tel_num,
                R.string.rukavishnikovykh_usadba_coordinates,
                R.drawable.rukavishnikovykh_usadba));
        museums.add(new Place(getContext(), R.string.art_museum_name,
                R.string.art_museum_address,
                R.string.art_museum_email_address,
                R.string.art_museum_tel_num,
                R.string.art_museum_coordinates,
                R.drawable.nizhny_novgorod_state_art_museum));
        museums.add(new Place(getContext(), R.string.history_museum_of_russian_car_producer_GAZ_name,
                R.string.history_museum_of_russian_car_producer_GAZ_address,
                R.string.history_museum_of_russian_car_producer_GAZ_email_address,
                R.string.history_museum_of_russian_car_producer_GAZ_tel_num,
                R.string.history_museum_of_russian_car_producer_GAZ_coordinates,
                R.drawable.history_museum_of_russian_car_producer_gaz));
        museums.add(new Place(getContext(), R.string.russian_museum_of_photography_name,
                R.string.russian_museum_of_photography_address,
                R.string.russian_museum_of_photography_email_address,
                R.string.russian_museum_of_photography_tel_num,
                R.string.russian_museum_of_photography_coordinates,
                R.drawable.russian_museum_of_photography));

        GaAdapter itemsAdapter = new GaAdapter(getActivity(), museums, R.color.category_museums);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        return rootView;
    }

}
