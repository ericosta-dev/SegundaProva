package com.example.prova2pdm

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewClickListener(val context: Context, recyclerView: RecyclerView, val listener: onItemClickListener ): RecyclerView.OnItemTouchListener {


    var gestoClick: GestureDetector
    init {
        gestoClick = GestureDetector(context, object: GestureDetector.SimpleOnGestureListener(){
            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                super.onSingleTapUp(e)

                val childView = recyclerView.findChildViewUnder(e!!.x, e.y)
                if (childView != null) {
                    listener.onItemCLick(childView, recyclerView.getChildAdapterPosition(childView))
                }
                return true
            }

            override fun onLongPress(e: MotionEvent?) {
                super.onLongPress(e)
                val childView = recyclerView.findChildViewUnder(e!!.x, e.y)
                if (childView != null) {
                    listener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView))
                }
            }
        })
    }


    interface onItemClickListener {
        fun onItemCLick(v: View, position: Int)
        fun onItemLongClick(v: View, position: Int)
    }


    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        gestoClick.onTouchEvent(e)
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }
}