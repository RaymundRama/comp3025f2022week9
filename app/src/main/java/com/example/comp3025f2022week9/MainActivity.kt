package com.example.comp3025f2022week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var FavouriteTVShows = arrayOf<TvShow>(
            TvShow("House of the Dragon", "HBO"),
            TvShow("Lord of the Rings", "Prime Video"),
            TvShow("Andor", "Disney"),
            TvShow("Severance", "AppleTV"),
            TvShow("Star Trek: Strange New Worlds", "Paramount"))

        val firstAdapter: FirstAdapter = FirstAdapter(FavouriteTVShows)
        val recyclerView: RecyclerView = findViewById(R.id.FirstRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = firstAdapter

    }
}