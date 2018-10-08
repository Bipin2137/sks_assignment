package com.example.bipin.assignment.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bipin.pocketnews.model.DashBoardMenuItemBean

import com.example.bipin.assignment.R
import com.example.bipin.assignment.activities.SongDetailFragment
import com.example.bipin.assignment.adapter.SongListRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


/**
 * A simple [Fragment] subclass.
 */
class PopularFragment : Fragment() {

    private lateinit var recyclerview: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_popular, container, false)
        recyclerview = view.findViewById(R.id.rvList)

        recyclerview.layoutManager = LinearLayoutManager(activity)

        val songadapter = SongListRecyclerAdapter(this.requireContext(), getSongList())

        recyclerview.adapter = songadapter

        songadapter.setCallback(object : SongListRecyclerAdapter.Callback {
            override fun onItemClick(title: String, position: Int) {

                val intent = Intent(this@PopularFragment.context,SongDetailFragment::class.java)
                intent.putExtra("title",title)
                startActivity(intent)

            }

        })

        return view
    }

    private fun getSongList(): ArrayList<DashBoardMenuItemBean> {
        val mDashBoardMenuItemBeans = ArrayList<DashBoardMenuItemBean>()

        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Happy (Pharrel Williams)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Wake me up (Avicii)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Sail (Awolation)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Fanzy (Laggy Azaeo feat)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Timber (Kesha)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Counting star (One and another)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Let her go (The passenger)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Loose yourself (The Messaenger)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "In The end (The linkinng park)"))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, "Pumped up kissed (Foster the)"))

        return mDashBoardMenuItemBeans
    }

}// Required empty public constructor
