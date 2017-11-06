package com.example.android.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class Library extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

// data to populate the RecyclerView with
        ArrayList<String> songNames = new ArrayList<>();
        songNames.add("Unforgettable, French Montana");
        songNames.add("Shape of You, Ed Sheeran");
        songNames.add("Despacito, Luis Fonsi");
        songNames.add("Wild Thoughts, DJ Khaled");
        songNames.add("Slide, Calvin Harris");

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.music_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(this, songNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, NowPlaying.class);
        startActivity(intent);
    }

}


