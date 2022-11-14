package com.example.comp3025f2022week9

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var addTVShowFAB: FloatingActionButton

    @SuppressLint("MissingInflatedId")
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

        addTVShowFAB = findViewById(R.id.add_TV_Show_FAB)

        addTVShowFAB.setOnClickListener{
            showCreateTVShowDialog()
        }
    }

    //Adding a dialog (continued) Slide 8 Week 9
    private fun showCreateTVShowDialog()
    {
        val dialogTitle = getString(R.string.dialog_title)
        val positiveButtonTitle = getString(R.string.add_tv_show)
        val negativeButtonTitle = getString(R.string.cancel)

        val builder = AlertDialog.Builder(this)

        val tvShowTitleEditText = findViewById<EditText>(R.id.tv_show_title_editText)

        val studioNameEditText = findViewById<EditText>(R.id.Studio_Name_EditText)

        builder.setTitle(dialogTitle)
        builder.setView(R.layout.add_new_tv_show_item)

        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()
        }

        builder.setNegativeButton(negativeButtonTitle){ dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }
}