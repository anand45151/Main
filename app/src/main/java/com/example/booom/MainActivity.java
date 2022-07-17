package com.example.booom;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.booom.adapter.RecentsAdapter;
import com.example.booom.adapter.TopPlacesAdapter;
import com.example.booom.model.RecentsData;
import com.example.booom.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
RecyclerView recentRecycler,topPlacesRecycler;
RecentsAdapter recentsAdapter;
TopPlacesAdapter topPlacesAdapter;
Button seeall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seeall = findViewById(R.id.seall);
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Seeall.class);
                startActivity(i);
            }
        });
        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData(" Pangong Lake","Ladhak","15000₹",R.drawable.p1));
        recentsDataList.add(new RecentsData(" ValleyofFlowers","Nainital","45000₹",R.drawable.p2));
        recentsDataList.add(new RecentsData("Jaisalmer Fort","Jaisalmer","5500",R.drawable.p3));
        recentsDataList.add(new RecentsData("Ruins of Hampi","Karnataka","12000",R.drawable.p4));
        recentsDataList.add(new RecentsData("Ghats at Varanasi","UP","13000",R.drawable.p5));
        recentsDataList.add(new RecentsData("Backwaters","Kerala","23000",R.drawable.p6));
        setRecentRecycler(recentsDataList);
        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Old Goa","Goa","25000",R.drawable.t1));
        topPlacesDataList.add(new TopPlacesData("UmaidBhavanPalace","Jodhpur","30000",R.drawable.t2));
        topPlacesDataList.add(new TopPlacesData(" Jama Masjid","Delhi","4000",R.drawable.t3));
        topPlacesDataList.add(new TopPlacesData("Akshardham Temple","Delhi","12000",R.drawable.t4));
        topPlacesDataList.add(new TopPlacesData("Old Bombay","Mumbai","35000",R.drawable.t5));
        setTopPlacesRecycler(topPlacesDataList);

    }
    private void setRecentRecycler(List<RecentsData> recentsDataList){
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }
    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList)
    {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }
}