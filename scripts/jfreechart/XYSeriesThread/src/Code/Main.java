package Code;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				JFrame window = new JFrame();
				window.setTitle("Test 1");
				window.setSize(600,400);
				window.setLayout(new BorderLayout());
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				XYSeries series = new XYSeries("Serie XY");
				XYSeries series2 = new XYSeries("Serie XY2"); //Name has to be unique!
				XYSeriesCollection dataset = new XYSeriesCollection(series);
				dataset.addSeries(series2);
				
				XYSeriesFeed feed = new XYSeriesFeed(series, 0);
				XYSeriesFeed feed2 = new XYSeriesFeed(series2, 0);
				
				Thread thread = new Thread(feed);
				thread.start();
				Thread thread2 = new Thread(feed2);
				thread2.start();
				
				JFreeChart chart = ChartFactory.createXYLineChart("Line Chart", "x", "f(x)", dataset);
				ChartPanel chartPanel = new ChartPanel(chart);
				
				
				window.add(chartPanel, BorderLayout.CENTER);
				window.setVisible(true);
	}

}
