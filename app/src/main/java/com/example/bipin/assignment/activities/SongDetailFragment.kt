package com.example.bipin.assignment.activities


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.bipin.assignment.R
import kotlinx.android.synthetic.main.fragment_song_detail.*


/**
 * A simple [Fragment] subclass.
 */
class SongDetailFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_song_detail)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {

        if(intent!=null){

            val title = intent.getStringExtra("title")
            tvTitle.text = title

        }else{
            return
        }

    }

}// Required empty public constructor
