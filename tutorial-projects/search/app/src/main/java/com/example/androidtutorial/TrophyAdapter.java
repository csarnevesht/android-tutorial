package com.example.androidtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrophyAdapter extends RecyclerView.Adapter<TrophyHolder> implements Filterable {
    private Context context;
    private ArrayList<Trophy> trophies;
    private List<Trophy> trophiesFiltered;


    public TrophyAdapter(Context context, ArrayList<Trophy> trophies) {
        this.context = context;
        this.trophies = trophies;
        this.trophiesFiltered = trophies;
    }

    @Override
    public int getItemCount() {
        return trophiesFiltered.size();
    }

    @Override
    public TrophyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trophies_item, parent, false);
        return new TrophyHolder(view);
    }

    @Override
    public void onBindViewHolder(TrophyHolder holder, int position) {
        Trophy trophy = trophiesFiltered.get(position);
        holder.setDetails(trophy);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().toLowerCase();
                if (charString.isEmpty()) {
                    trophiesFiltered = trophies;
                } else {
                    List<Trophy> filteredList = new ArrayList<>();
                    for (Trophy row : trophies) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getTitle().toLowerCase().contains(charString) || row.getDescription().contains(charString)) {
                            filteredList.add(row);
                        }
                    }

                    trophiesFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = trophiesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                trophiesFiltered = (ArrayList<Trophy>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}