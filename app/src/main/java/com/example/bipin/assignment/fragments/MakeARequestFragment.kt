package com.example.bipin.assignment.fragments

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bipin.assignment.R
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.bipin.assignment.activities.SongDetailFragment
import kotlinx.android.synthetic.main.fragment_make_arequest.*


/**
 * A simple [Fragment] subclass.
 */
class MakeARequestFragment : Fragment() {

    private lateinit var viewpager: ViewPager
    private lateinit var tablayout: TabLayout
    private lateinit var autocomplete: AutoCompleteTextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_make_arequest, container, false)
        viewpager = view!!.findViewById<ViewPager>(R.id.viewpager)
        tablayout = view.findViewById<TabLayout>(R.id.tab_layout)
        autocomplete = view.findViewById(R.id.autocomplete)
        setupViewPager(viewpager)
        tablayout.setupWithViewPager(viewpager)

        setAdapterToAutoComplete()

        return view
    }

    private fun setAdapterToAutoComplete() {

        val list = ArrayList<String>()
        list.add("Radio friendly unit shifter")
        list.add("Radio (Lana Del Ray)")
        list.add("Will DO")
        list.add("Radio Ga Ga")
        list.add("Radio/Video (Systems of the down)")

        val array_adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_list_item_1, list)
        autocomplete.setAdapter(array_adapter)

        autocomplete.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this@MakeARequestFragment.context, SongDetailFragment::class.java)
            intent.putExtra("title",list[i])
            startActivity(intent)
        }

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(PopularFragment(), "Popular")
        adapter.addFragment(YourPreviousFragment(), "Your Previous")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private var mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<CharSequence>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList.get(position)
        }
    }

}// Required empty public constructor
