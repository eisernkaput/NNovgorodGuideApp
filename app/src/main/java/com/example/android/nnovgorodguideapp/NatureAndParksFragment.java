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
public class NatureAndParksFragment extends Fragment {


    public NatureAndParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> nAndP = new ArrayList<>();

        nAndP.add(new Place(getContext(), R.string.limpopo_zoo_name,
                R.string.limpopo_zoo_address,
                R.string.limpopo_zoo_email_address,
                R.string.limpopo_zoo_tel_num,
                R.string.limpopo_zoo_coordinates,
                R.drawable.limpopo_zoo));
        nAndP.add(new Place(getContext(), R.string.sormovskiy_park_of_culture_and_leisure_name,
                R.string.sormovskiy_park_of_culture_and_leisure_address,
                R.string.sormovskiy_park_of_culture_and_leisure_email_address,
                R.string.sormovskiy_park_of_culture_and_leisure_tel_num,
                R.string.sormovskiy_park_of_culture_and_leisure_coordinates,
                R.drawable.sormovskiy_park_of_culture_and_leisure));
        nAndP.add(new Place(getContext(), R.string.ekzotarium_exhibition_center_name,
                R.string.ekzotarium_exhibition_center_address,
                R.string.ekzotarium_exhibition_center_email_address,
                R.string.ekzotarium_exhibition_center_tel_num,
                R.string.ekzotarium_exhibition_center_coordinates,
                R.drawable.nizhny_novgorod_ekzotarium_exhibition_center));
        nAndP.add(new Place(getContext(), R.string.switzerland_recreation_park_name,
                R.string.switzerland_recreation_park_address,
                R.string.switzerland_recreation_park_email_address,
                R.string.switzerland_recreation_park_tel_num,
                R.string.switzerland_recreation_park_coordinates,
                R.drawable.switzerland_recreation_park));
        nAndP.add(new Place(getContext(), R.string.nii_botanical_garden_name,
                R.string.nii_botanical_garden_address,
                R.string.nii_botanical_garden_email_address,
                R.string.nii_botanical_garden_tel_num,
                R.string.nii_botanical_garden_coordinates,
                R.drawable.nii_botanical_garden));

        GaAdapter itemsAdapter = new GaAdapter(getActivity(), nAndP, R.color.category_nature_and_parks);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        return rootView;
    }

}
