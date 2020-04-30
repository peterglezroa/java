package test1;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setTitle("Test 1");
		window.setSize(600,400);
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		XYSeries series = new XYSeries("Serie XY");
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		for(int i = 0; i < 100; i++) {
			series.add(i, Math.random()*200 + 1);
		}
		
		JFreeChart chart = ChartFactory.createXYLineChart("Line Chart", "x", "f(x)", dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		
		
		window.add(chartPanel, BorderLayout.CENTER);
		window.setVisible(true);
	}

}
