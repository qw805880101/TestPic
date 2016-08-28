package com.example.admin.testpic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BarChart mBarChart;

    private Context context;

    private int showCount = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutoLayoutConifg.getInstance().useDeviceSize();
        setContentView(R.layout.histogram);
        findy();

    }

    private void findy() {
        mBarChart = (BarChart) findViewById(R.id.my);
        setData(31, 1000);

        mBarChart.setDescription("");

        for (IDataSet set : mBarChart.getData().getDataSets())
            set.setDrawValues(false);

        mBarChart.animateY(3000);

        YAxis mYAxis = mBarChart.getAxisLeft();

        mYAxis.setEnabled(false); //是否启用左边Y轴，如果禁用，关于轴的设置所有属性都将被忽略

//        mYAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);

//        mYAxis.setZeroLineWidth(10);
//        mYAxis.setZeroLineColor(getResources().getColor(R.color.color_54657e));
//        mYAxis.setDrawZeroLine(true);


        mBarChart.getAxisRight().setEnabled(false); //是否显示右边Y轴

        mBarChart.setScaleEnabled(false); // 设置缩放

        mBarChart.getLegend().setEnabled(false);  // 显示图标

        mBarChart.setVisibleXRange(0, showCount);// 设置标签范围


        mBarChart.setExtraBottomOffset(5);

//        mBarChart.setExtraLeftOffset(30);
//
//        mBarChart.setExtraRightOffset(100);

//        mBarChart.setMinOffset(30); // 设置padding

//        mBarChart.setViewPortOffsets(30, 0, 0, 0);


        XAxis mXAxis = mBarChart.getXAxis();
        mXAxis.setEnabled(true); //是否启用轴，如果禁用，关于轴的设置所有属性都将被忽略
        mXAxis.setDrawLabels(true); //是否绘制标签
        mXAxis.setTextSize(18);
        mXAxis.setTextColor(getResources().getColor(R.color.color_54657e));
        Typeface face = Typeface.createFromAsset(getAssets(), "roboto.ttf");
        mXAxis.setTypeface(face); // 设置标签字体
        mXAxis.setLabelCount(showCount);// 设置可见标签个数
        mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //设置标签显示位置
        mXAxis.setDrawAxisLine(false);// 是否绘制轴线
        mXAxis.setDrawGridLines(false);//是否和网格轴线
    }


    private void setData(int count, float range) {

        float start = 1f;

        mBarChart.getXAxis().setAxisMinimum(start);
        mBarChart.getXAxis().setAxisMaximum(count + 1);
        ArrayList<BarEntry> yVals1 = new ArrayList<>();

        for (int i = (int) start; i < count + 2; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult);
            yVals1.add(new BarEntry(i, val));
        }

        BarDataSet set1;

        if (mBarChart.getData() != null &&
                mBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mBarChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mBarChart.getData().notifyDataChanged();
            mBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "The year 2017");
            set1.setColors(ColorTemplate.MATERIAL_COLORS);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(0.8f);
//            data.setValueTypeface(mTfLight);
            data.setBarWidth(0.7f);
            mBarChart.setData(data);
        }

    }
}
