package com.example.bipin.assignment.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.bipin.assignment.R


/**
 * A simple [Fragment] subclass.
 */
class YourPreviousFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_your_previous, container, false)
    }

}// Required empty public constructor
