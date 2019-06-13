package com.example.androidtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrophyAdapter extends RecyclerView.Adapter<TrophyViewHolder> {
    private Context context;
    private ArrayList<Trophy> trophies;

    // pass context and data so this adapter has access to the all the data
    public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
        this.context = context;
        this.trophies = trophies;
    }

    // tell recyclerview the size of the data.  If it returns zero, the recyclerview
    // will not display any items in the app screen.
    @Override
    public int getItemCount() {
        return trophies.size();
    }

    // Inflate the trophy item layout when a view holder item is created for a trophy item.
    // That is, create layout view object (trophies_item) for one view item and return a view holder which holds that view.
    // the layout view object contains a TextView object for the trophy title and a TextView object for the trophy description.
    @Override
    public TrophyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create trophies_item layout object
        View view = LayoutInflater.from(context).inflate(R.layout.trophies_item, parent, false);
        return new TrophyViewHolder(view);
    }

    // Bind (set) the trophy item **data** to the trophy item **view**.
    // That is, get the trophy in position 'position' in the trophies arraylist, and set the data for that
    // trophy into the view holder view objects.
    @Override
    public void onBindViewHolder(TrophyViewHolder holder, int position) {
        Trophy trophy = trophies.get(position);
        holder.setData(trophy);
    }

}
