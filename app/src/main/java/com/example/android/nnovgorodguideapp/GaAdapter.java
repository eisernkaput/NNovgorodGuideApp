package com.example.android.nnovgorodguideapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GaAdapter extends ArrayAdapter<Place> {
    private int colorResourceId;
    private Context mContext;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context          The current context. Used to inflate the layout file.
     * @param places           A List of Word objects to display in a list
     * @param mColorResourceId is the resource ID for the background color for this list of words
     */

    GaAdapter(Activity context, ArrayList<Place> places, int mColorResourceId) {
        super(context, R.layout.list_item, places);
        mContext = context;
        colorResourceId = mColorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        final Place place = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        if (place != null) {
            ((TextView) convertView.findViewById(R.id.name))
                    .setText(place.getName());
        }

        if (place != null) {
            TextView addressTextView = convertView.findViewById(R.id.address);
            addressTextView.setText(place.getAddress());
            addressTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri gmmIntentUri = Uri.parse(place.getMapCoordinates());
                    Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    intent.setPackage("com.google.android.apps.maps");
                    if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                        mContext.startActivity(intent);
                    }
                }
            });
        }


        TextView telNumberTextView = convertView.findViewById(R.id.telNumber);
        // Check if an String is provided for this place or not
        if (place != null) {
            if (place.hasTelNumber()) {
                // If an String is available, display the provided image based on the resource ID
                telNumberTextView.setText(place.getTelNumber());
                // Make sure the view is visible
                telNumberTextView.setVisibility(View.VISIBLE);
                telNumberTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + place.getTelNumber()));
                        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                            mContext.startActivity(intent);
                        }
                    }
                });
            } else {
                // Otherwise hide the TextView (set visibility to GONE)
                telNumberTextView.setVisibility(View.GONE);
            }
        }

        TextView emailAddressTextView = convertView.findViewById(R.id.emailAddress);
        // Check if an String is provided for this place or not
        if (place != null) {
            if (place.hasEmailAddress()) {
                // If an String is available, display the provided image based on the resource ID
                emailAddressTextView.setText(place.getEmailAddress());
                // Make sure the view is visible
                emailAddressTextView.setVisibility(View.VISIBLE);
                emailAddressTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setType("message/rfc822");
                        intent.setData(Uri.parse("mailto:" + place.getEmailAddress()));
                        intent.putExtra(Intent.EXTRA_SUBJECT, place.getName());
                        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                            mContext.startActivity(intent);
                        }
                    }
                });
            } else {
                // Otherwise hide the TextView (set visibility to GONE)
                emailAddressTextView.setVisibility(View.GONE);
            }
        }


        ImageView imageView = convertView.findViewById(R.id.imageView);
        // Check if an image is provided for this place or not
        if (place != null) {
            if (place.hasImage()) {
                // If an image is available, display the provided image based on the resource ID
                imageView.setImageResource(place.getImageResourceId());
                // Make sure the view is visible
                imageView.setVisibility(View.VISIBLE);
            } else {
                // Otherwise hide the ImageView (set visibility to GONE)
                imageView.setVisibility(View.GONE);
            }
        }


        // Set the theme color for the list item
        View textContainer = convertView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        return convertView;
    }


}
