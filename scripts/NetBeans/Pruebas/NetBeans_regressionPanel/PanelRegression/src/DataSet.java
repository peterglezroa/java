import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class DataSet {

	private ArrayList<Data> data;
	private static int DATA_AMOUNT = 10;
	
	public DataSet() {
		data = new ArrayList<Data>();
	}
	
	public DataSet(Function function, double minX, double maxX, double offset) {
		data = new ArrayList<Data>();
		for(int i = 0; i < DATA_AMOUNT; i++) {
			double x = ThreadLocalRandom.current().nextDouble(minX, maxX + 1);
			double value = function.value(x);
			double label = value + ThreadLocalRandom.current().nextDouble(-offset,offset);
			push(new Data(x, label));
		}
	}
	
	public void scale() {
		Iterator<Data> dataIterator = this.data.iterator();
		double standardDev = 0;
		double average = 0;
		//Average
		while(dataIterator.hasNext()) {
			Data data = dataIterator.next();
			average += data.getY()/this.data.size();
		}
		
		//Standard dev
		while(dataIterator.hasNext()) {
			Data data = dataIterator.next();
			standardDev += Math.pow(data.getY()-average, 2)/(this.data.size()-1);
		}
		
		standardDev = Math.sqrt(standardDev);
		//scale: (current - average)/stdev
		while(dataIterator.hasNext()) {
			Data data = dataIterator.next();
			data.setY((data.getY()-average)/standardDev);;
		}
	}
	
	public void push(Data newData) {
		this.data.add(newData);
		System.out.println("[" + newData.getX() + "," + newData.getY() + "]");
	}
	
	public void pop() {
		this.data.remove(this.data.size() - 1);
	}
	
	public void concatenate(DataSet newData) {
		data.addAll(newData.getData());
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
        @Override
	public String toString() {
		String string = "";
		Iterator<Data> iterator = data.iterator();
		while(iterator.hasNext()) {
			Data data = iterator.next();
			string += "\n" + data.toString();
		}
		return "[" + string + "\n]";
	}
	
	public String toStringXs() {
		String string = "";
		Iterator<Data> iterator = data.iterator();
		while(iterator.hasNext()) {
			Data data = iterator.next();
			string += " " + data.getX();
		}
		return "[" + string + " ]";
	}
	
	public String toStringYs() {
		String string = "";
		Iterator<Data> iterator = data.iterator();
		while(iterator.hasNext()) {
			Data data = iterator.next();
			string += " " + data.getY();
		}
		return "[" + string + " ]";
	}

	public int size() {
		return data.size();
	}

	public ArrayList<Data> getData() {
		return data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
	
	
}
