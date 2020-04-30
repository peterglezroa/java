package test1;

import org.jfree.data.xy.XYSeries;

public class XYSeriesFeed implements Runnable{

	protected XYSeries series;
	protected int x;
	protected boolean running;
	
	public XYSeriesFeed(XYSeries series, int x) {
		this.series = series;
		this.x = x;
		running = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		running = true;
		double time_actual = 0, time_before = 0, time_diff = 0;
		while(running) {
			time_actual = java.lang.System.currentTimeMillis();
			time_diff = time_actual - time_before;
			if(time_diff > 1000) {
				time_before = time_actual;
				x++;
				this.series.add(x, Math.random()*200+1);
			}
		}
	}
	
	public void stop() {
		this.running = false;
	}
	
	
}
