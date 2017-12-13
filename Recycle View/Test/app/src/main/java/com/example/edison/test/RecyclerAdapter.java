package com.example.edison.test;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Edison on 01/11/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder  > {

    int[] countryNames, countryCapital;

    public RecyclerAdapter(int[] countryNames, int[] countryCapital){


        this.countryNames = countryNames;
        this.countryCapital = countryCapital;

    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.txCountryName.setImageResource(countryNames[position]);
        holder.txCountryCapital.setImageResource(countryCapital[position]);
    }

    @Override
    public int getItemCount() {
        return countryNames.length;
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView txCountryName, txCountryCapital;

        public RecyclerViewHolder(View v){
            super(v);
            txCountryName = (ImageView) v.findViewById(R.id.countryName);
            txCountryCapital = (ImageView) v.findViewById(R.id.capitalName);

        }

    }
}
