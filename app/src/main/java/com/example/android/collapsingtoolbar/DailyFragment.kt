package com.example.android.collapsingtoolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.collapsingtoolbar.adapter.DailyListAdapter
import com.example.android.collapsingtoolbar.data.DailyDataClass

class DailyFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_daily, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val dailyListAdapter = DailyListAdapter(prepareData())
        recyclerView.adapter = dailyListAdapter

        val date = view.findViewById<TextView>(R.id.date)
        date.text = arguments?.getString(DATE)
    }

    private fun prepareData(): List<DailyDataClass> {
        val list = ArrayList<DailyDataClass>()
        list.add(DailyDataClass("John Doe", "New York"))
        list.add(DailyDataClass("Emma Book", "San Francisco"))
        list.add(DailyDataClass("Reed Steel", "Chicago"))
        list.add(DailyDataClass("Sidney Crosby", "New Jersey"))
        list.add(DailyDataClass("Mathew Fraser", "Philadelphia"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        list.add(DailyDataClass("Rich Froning", "Saint Louis"))
        return list
    }

    companion object {

        private const val DATE = "date"

        fun newInstance(date: String): DailyFragment {
            val args = Bundle()
            args.putString(DATE, date)
            val fragment = DailyFragment()
            fragment.arguments = args
            return fragment
        }
    }
}