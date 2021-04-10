package com.example.radio.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radio.R;
import com.example.radio.model.RadioStation;
import com.example.radio.model.RadioList;
import com.example.radio.ui.radio.RadioFragment;
import com.squareup.picasso.Picasso;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {
    LayoutInflater inflater;
    RadioList radioList;

    public RadioAdapter(Context ctx, RadioList radioList){
        this.inflater= LayoutInflater.from(ctx);
        this.radioList = radioList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.item_layout, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.radioName.setText(radioList.radioStationsArray[position].getRadioName());
        Picasso.get().load(radioList.radioStationsArray[position].getRadioImageLink()).into(holder.radioImage);

    }

    @Override
    public int getItemCount() {
        return radioList.radioStationsArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView radioName;
        ImageView radioImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioName= itemView.findViewById(R.id.radioName);
            radioImage= itemView.findViewById(R.id.radioImage);
            itemView.setOnClickListener((this));
        }

        @Override
        public void onClick(View v) {
            RadioStation radioStation= RadioFragment.radioList.radioStationsArray[getLayoutPosition()];
            RadioFragment.currRadio= radioStation;
            Navigation.findNavController(v).navigate(R.id.action_navigation_radio_to_navigation_player);
        }
    }
}
