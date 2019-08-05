package com.example.android.collapsingtoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.android.collapsingtoolbar.util.PageAnimator
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter


const val FRAGMENTS_AMOUNT = 3

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.daily_pager)
        val pagerAdapter = DailyFragmentAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = FRAGMENTS_AMOUNT
        viewPager.setPageTransformer(true, PageAnimator())
    }

    private inner class DailyFragmentAdapter(
        fm: FragmentManager,
        behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) :
        FragmentStatePagerAdapter(fm, behavior) {
        override fun getItem(position: Int): Fragment = DailyFragment.newInstance(getDate(position))

        private fun getDate(position: Int): String {
            val pattern = DateTimeFormatter.ofPattern("dd MMM")
            return when (position) {
                0 -> "Yesterday, ${LocalDate.now().minusDays(1).format(pattern)}"
                1 -> "Today, ${LocalDate.now().format(pattern)}"
                else -> "Tomorrow, ${LocalDate.now().plusDays(1).format(pattern)}"
            }
        }

        override fun getCount(): Int = FRAGMENTS_AMOUNT
    }
}
