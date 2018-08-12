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
public class CulturalSitesFragment extends Fragment {


    public CulturalSitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> culturalSites = new ArrayList<>();

        culturalSites.add(new Place(getContext(), R.string.state_bank_name,
                R.string.state_bank_address,
                R.string.state_bank_tel_num,
                R.string.state_bank_coordinates,
                R.drawable.state_bank));
        culturalSites.add(new Place(getContext(), R.string.rozhdestvenskaya_street_name,
                R.string.rozhdestvenskaya_street_address,
                R.string.rozhdestvenskaya_street_coordinates,
                R.drawable.rozhdestvenskaya_street));
        culturalSites.add(new Place(getContext(), R.string.pozharsky_and_minin_square_name,
                R.string.pozharsky_and_minin_square_address,
                R.string.pozharsky_and_minin_square_coordinates,
                R.drawable.pozharsky_and_minin_square));
        culturalSites.add(new Place(getContext(), R.string.chkalov_staircase_name,
                R.string.chkalov_staircase_address,
                R.string.chkalov_staircase_coordinates,
                R.drawable.chkalov_staircase));
        culturalSites.add(new Place(getContext(), R.string.temple_name,
                R.string.temple_address,
                R.string.temple_email_address,
                R.string.temple_tel_num,
                R.string.temple_coordinates,
                R.drawable.the_nativity_of_st_john_the_baptist_temple));

        GaAdapter itemsAdapter = new GaAdapter(getActivity(), culturalSites, R.color.category_cultural_sites);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        return rootView;

    }

}
