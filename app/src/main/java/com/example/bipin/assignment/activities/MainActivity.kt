package com.example.bipin.assignment.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import com.bipin.pocketnews.model.DashBoardMenuItemBean
import com.example.bipin.assignment.R
import com.example.bipin.assignment.adapter.DashBoardMenuAdapter
import com.example.bipin.assignment.drawer.EndDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import com.example.bipin.assignment.R.string.closeDrawer
import android.R.attr.fragment
import android.support.v4.app.Fragment
import android.util.Log
import com.example.bipin.assignment.fragments.MakeARequestFragment
import com.example.bipin.assignment.fragments.MyProfileFragment
import com.example.bipin.assignment.fragments.PreviousRequestFagment


class MainActivity : AppCompatActivity() {

    private var toggle : EndDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadToolbar()
        loadDrawerMenu()
    }

    private fun loadToolbar(){

        setSupportActionBar(toolbar)

        toggle = EndDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close,main_layout)
        drawer_layout.addDrawerListener(toggle!!)


    }

    private fun loadDrawerMenu() {

        val mDashBoardMenuItemBeans = ArrayList<DashBoardMenuItemBean>()

        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, getString(R.string.make_a_request)))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, getString(R.string.my_profile)))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, getString(R.string.prev_requests)))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, getString(R.string.hrc_karakoe_guide)))
        mDashBoardMenuItemBeans.add(DashBoardMenuItemBean(R.drawable.ic_person_black_24dp, getString(R.string.other_events)))

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val dashBoardMenuAdapter = DashBoardMenuAdapter(this, mDashBoardMenuItemBeans)
        recyclerView.adapter = dashBoardMenuAdapter

        dashBoardMenuAdapter.setCallback(object : DashBoardMenuAdapter.Callback {
            override fun onItemClick(title: String, position: Int) {
                drawer_layout.closeDrawers()
                selectItem(position)
            }
        })

        selectItem(0)
    }


    fun selectItem(position: Int){
        var fragment: Fragment? = null
        var tag: String
          when(position){
            0 -> {
                fragment =  MakeARequestFragment()
                tag = resources.getString(R.string.make_a_request)
            }
            1 -> {
                fragment = MyProfileFragment()
                tag = resources.getString(R.string.my_profile)
            }
            else -> {
                fragment = PreviousRequestFagment()
                tag = resources.getString(R.string.prev_requests)
            }

        }
        setFragment(fragment,tag)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle!!.syncState()
    }

    private fun setFragment(fragment: Fragment?, TAG: String){

        if (fragment != null) {
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment,TAG).commit()

            toolbar.title = fragment.tag
            drawer_layout.closeDrawers()

        } else {
            Log.e("MainActivity", "Error in creating fragment")
        }
    }
}
