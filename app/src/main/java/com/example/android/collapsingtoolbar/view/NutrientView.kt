package com.example.android.collapsingtoolbar.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.android.collapsingtoolbar.R

class NutrientView : LinearLayout {

    private var titleView: TextView? = null
    private var valueView: TextView? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        createAndFillView(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        createAndFillView(attrs)
    }

    private fun createAndFillView(attrs: AttributeSet) {
        inflateView()
        applyAttributes(attrs)
    }

    private fun applyAttributes(attrs: AttributeSet) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.NutrientView, 0, 0)

        val title = attributes.getString(R.styleable.NutrientView_name)
        val value = attributes.getString(R.styleable.NutrientView_value)

        titleView?.text = title
        valueView?.text = value

        attributes.recycle()
    }

    private fun inflateView() {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rootView = inflater.inflate(R.layout.view_nutrient, this, true)
        titleView = rootView.findViewById(R.id.name)
        valueView = rootView.findViewById(R.id.value)
    }

}