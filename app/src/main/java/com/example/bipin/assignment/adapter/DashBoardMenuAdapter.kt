package com.example.bipin.assignment.adapter

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bipin.pocketnews.model.DashBoardMenuItemBean
import com.example.bipin.assignment.R
import java.util.ArrayList

/**
 * Created by Bipin on 07-Oct-18.
 */

class DashBoardMenuAdapter(private val mContext: Context,
                           private val mDashBoardMenuItemBeans: ArrayList<DashBoardMenuItemBean>) : RecyclerView.Adapter<DashBoardMenuAdapter.ViewHolder>() {
    private var mCallback: Callback? = null


    fun setCallback(callback: Callback) {
        mCallback = callback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard_menu_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dashBoardMenuItemBean = mDashBoardMenuItemBeans[position]
        holder.setTitle(dashBoardMenuItemBean.title)
        holder.setImage(dashBoardMenuItemBean.resId)
        holder.setOnItemClickListener(View.OnClickListener {
            mCallback!!.onItemClick(dashBoardMenuItemBean.title, position)
        })

    }

    override fun getItemCount(): Int {
        return mDashBoardMenuItemBeans.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        var ivImage: ImageView = itemView.findViewById(R.id.ivImage)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.itemView)

        fun setTitle(title: String) {
            tvTitle.text = title
        }

        fun setImage(@DrawableRes resId: Int) {
            if (resId == -1) {
                ivImage.visibility = View.GONE
            } else {
                ivImage.setImageDrawable(ContextCompat.getDrawable(mContext, resId))
                ivImage.visibility = View.VISIBLE
            }
        }

        fun setOnItemClickListener(onClickListener: View.OnClickListener) {
            linearLayout.setOnClickListener(onClickListener)
        }


    }

    interface Callback {
        fun onItemClick(title: String, position: Int)
    }


}
