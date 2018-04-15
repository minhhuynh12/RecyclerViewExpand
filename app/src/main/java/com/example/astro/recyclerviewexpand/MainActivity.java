package com.example.astro.recyclerviewexpand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.astro.recyclerviewexpand.Adapter.MainActivityAdapter;
import com.example.astro.recyclerviewexpand.Model.MainDataItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerActivity;
    private RecyclerView recycDataAcitivity;
    private LinearLayout linearActivity;
    private MainActivityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerActivity = findViewById(R.id.spinnerActivity);
        recycDataAcitivity = findViewById(R.id.recycDataAcitivity);
        linearActivity = findViewById(R.id.linearActivity);

        List<MainDataItems> list = new ArrayList<>();
        list.add(new MainDataItems("Minh", "Huynh", "24" , "http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png"));
        list.add(new MainDataItems("Nam", "Huynh", "24" , "http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png"));
        list.add(new MainDataItems("Chau", "Huynh", "24" , "http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png"));
        list.add(new MainDataItems("Tinh", "Huynh", "24" , "http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png"));
        list.add(new MainDataItems("An", "Huynh", "24" , "http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png"));
        list.add(new MainDataItems("Minh", "Huynh", "24" , "http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png"));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycDataAcitivity.setLayoutManager(linearLayoutManager);
        mAdapter = new MainActivityAdapter(this);
        recycDataAcitivity.setAdapter(mAdapter);
        mAdapter.setData(list);


    }
}
