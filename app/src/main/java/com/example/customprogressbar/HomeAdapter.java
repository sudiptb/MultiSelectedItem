package com.example.customprogressbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<Home> homeList = new ArrayList<>();

    public HomeAdapter(List<Home> homeList) {
        this.homeList = homeList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new HomeViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.tvCheck.setText(homeList.get(position).getName());

        if (homeList.get(position).isSelected){
            holder.tvCheck.setChecked(true);
        }else {
            holder.tvCheck.setChecked(false);
        }

        holder.tvCheck.setOnClickListener(view -> {
            if (homeList.get(position).isSelected){
                homeList.get(position).isSelected = false;
            }else {
                homeList.get(position).isSelected = true;
            }
            notifyItemChanged(position);
            Integer count = getSelectedItem();

            System.out.println("count is " + count);
        });
    }

    private Integer getSelectedItem(){
        ArrayList<Home> checkItemList = new ArrayList<>();
        checkItemList.clear();
        for (int i = 0; i < homeList.size(); i++) {
            if (homeList.get(i).isSelected){
                checkItemList.add(homeList.get(i));
            }
        }
        return checkItemList.size();
    }

    public ArrayList<Home> selectedValue(){
        ArrayList<Home> productList = new ArrayList<>();
        for (int i = 0; i < homeList.size(); i++) {
            if (homeList.get(i).isSelected){
                productList.add(homeList.get(i));
            }
        }
        return productList;
    }


    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        CheckBox tvCheck;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCheck = itemView.findViewById(R.id.tvCheck);
        }
    }
}
