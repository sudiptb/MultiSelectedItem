package com.example.customprogressbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<Integer> selectedIds = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ArrayList<Home> homeArrayList = new ArrayList<>();
        homeArrayList.add(new Home(1,"sudipto", false));
        homeArrayList.add(new Home(2,"sudipto1", false));
        homeArrayList.add(new Home(3,"sudipto2", false));
        homeArrayList.add(new Home(4,"sudipto3", false));
        homeArrayList.add(new Home(5,"sudipto4", false));

        RecyclerView recyclerView = findViewById(R.id.rvList);
        HomeAdapter homeAdapter = new HomeAdapter(homeArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(homeAdapter);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(view -> {
            ArrayList<Home> homes = homeAdapter.selectedValue();
            selectedIds.clear();
            for (int i = 0; i < homes.size(); i++) {
                selectedIds.add(homes.get(i).getId());
            }
            System.out.println("selected id is " + selectedIds.toString());
        });


    }
}
