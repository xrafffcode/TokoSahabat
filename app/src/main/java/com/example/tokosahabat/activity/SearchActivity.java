package com.example.tokosahabat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tokosahabat.R;
import com.example.tokosahabat.activity.user.CartActivity;
import com.example.tokosahabat.adapter.MyCartListAdapter;
import com.example.tokosahabat.adapter.SearchAdapter;
import com.example.tokosahabat.model.DataModel;
import com.example.tokosahabat.model.MyCartListModel;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView rvData;
    public RecyclerView.Adapter adData;
    public RecyclerView.LayoutManager lmData;
    private List<DataModel> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent terima = getIntent();

        rvData = findViewById(R.id.rv_search);

        lmData=  new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false);

        listData = (List<DataModel>) terima.getSerializableExtra("listData");
        rvData.setLayoutManager(lmData);

        adData = new SearchAdapter(SearchActivity.this, listData );
        rvData.setAdapter(adData);
        adData.notifyDataSetChanged();

    }
}