package com.zone.android.miskool;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.numetriclabz.numandroidcharts.ChartData;
import com.numetriclabz.numandroidcharts.LineChart;

import java.util.ArrayList;
import java.util.List;



public class examFragment extends Fragment implements  examFragmentInterface {
    public examFragment(){


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_exam, container, false);

      //  GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        /*graph.setTitleColor(Color.CYAN);


        graph.setTitle("Mark Status");
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)


        });
        graph.addSeries(series);

        series.setColor(Color.CYAN);*/

        LineChart lineChart = (LineChart) rootView.findViewById(R.id.linechart);


        List<ChartData> values1=new ArrayList<>();

        values1.add(new ChartData(60f, "Malayalam")); //values.add(new ChartData(y,x));<br />
        values1.add(new ChartData(45f, "Maths"));


        values1.add(new ChartData(73f, "Science"));
        values1.add(new ChartData(80f, "English"));
        values1.add(new ChartData(100f, "Total"));



        lineChart.setData(values1);
        lineChart.setDescription("Sub-Marks");



        return rootView;


    }

    @Override
    public void setExamDetails() {
        //setting exam detailssssss
    }
}
