package com.allchart.graphsdemo.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.allchart.graphsdemo.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class BarChartFragment : Fragment() {
    lateinit var barChart: BarChart

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bar_chart, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        barChart = view.findViewById(R.id.barChart)

            // step 1: Put the values for x-axis
            val xvalues = ArrayList<String>()
            xvalues.add("Monday")
            xvalues.add("Tuesday")
            xvalues.add("Wednesday")
            xvalues.add("Thursday")
            xvalues.add("Friday")
            xvalues.add("Saturday")
            xvalues.add("Sunday")

            // Step2: y-axis values or bar data

            val yaxis = arrayOf<Float>(1.1f,2.1f,3.1f,4.1f,5.1f,6.1f,7.1f)

            // 7 entries for 7 data bar-entries
            // this entries will be done for which axis the data will be plotted at which point
            val entries = ArrayList<BarEntry>()
            /* entries.add(BarEntry(1f, 4f))
             entries.add(BarEntry(2f, 10f))
             entries.add(BarEntry(3f, 2f))
             entries.add(BarEntry(4f, 15f))
             entries.add(BarEntry(5f, 13f))
             entries.add(BarEntry(6f, 2f))
             entries.add(BarEntry(7f, 18f))*/

            for(i in 0..yaxis.size-1)
            {
                entries.add(BarEntry(yaxis[i] ,i.toFloat()))
            }

            //bar data set ,the label will be seen with x-axis
            val barDataSet = BarDataSet(entries, "")
            barDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)

            // Step 4 make a bar data
            val data = BarData(barDataSet)
            barChart.data = data
            barChart.setBackgroundColor(resources.getColor(R.color.light_yellow))
            barChart.animateXY(3000,3000)


    }
}