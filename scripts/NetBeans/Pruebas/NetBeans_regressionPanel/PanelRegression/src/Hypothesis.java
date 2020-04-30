import java.util.ArrayList;
import java.util.Iterator;

public class Hypothesis extends Function{

	private Double learnRate;
	private final double learnRateChange;
	private ArrayList<Double> errors;
	
	public Hypothesis(double startingLearnRateChange) {
		super();
		learnRate = 0.005;
		learnRateChange = startingLearnRateChange;
		errors = new ArrayList<Double>();
	}
	
	/*Regression------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	public void updateAlpha(Double error) {
		learnRate = Math.log(Math.abs(error)+1)*learnRateChange*0.01;
	}
	
	public double costError(Data data) {
		/*
		 *  (hyp(x) - label)
		*/
		return (this.value(data.getX()) - data.getY());
	}
	
	public double errorMean(ArrayList<Data> dataset) {
		/*
		 * Used to calculate 
		 */
		Iterator<Data> dataItr = dataset.iterator();
		double sum = 0;
		int cant = dataset.size();
		while(dataItr.hasNext()) {
			Data data = dataItr.next();
			sum += Math.abs(costError(data)/cant);
		}		
		this.errors.add(sum);
		return sum;
	}
	
	public void train_dataset(ArrayList<Data> dataset) {
		/*
		 *  prev - learnRate*SUM(error*param(x)/m
		*/
		Iterator<Param> paramsItr = this.params.iterator();
		while(paramsItr.hasNext()) {
			Param param = paramsItr.next();
			Iterator<Data> dataItr = dataset.iterator();
			double sum = 0;
			int cant = dataset.size();
			while(dataItr.hasNext()) {
				Data data = dataItr.next();
				sum += this.learnRate*costError(data)*param.value(data.getX())/cant;
				//System.out.println(param.getCoeficient() + "-" + sum);
			}
			param.setCoeficient(param.getCoeficient() - sum);
		}
	}
	
	public ArrayList<Double> train(DataCollection datacollection, int MAXEPOCHS, double threshold){
		int epoch = 0;
		double costError = 9999;
		do {
			int CYCLEAMOUNT = datacollection.getDATASETS_AMOUNT(); //Will complete a cycle of the training dataset
			DataSet trainingSet = datacollection.trainingSet();
			for(int i = 0; i < CYCLEAMOUNT; i++) {
				train_dataset(datacollection.trainingSet().getData());
				costError = errorMean(trainingSet.getData());
				updateAlpha(costError);
				progressBar(epoch, MAXEPOCHS, i, CYCLEAMOUNT, costError);
				datacollection.rotation();
				
			}
			epoch++;
			progressBar(epoch, MAXEPOCHS, 0, CYCLEAMOUNT, errorMean(trainingSet.getData()));
		}while(epoch < MAXEPOCHS && costError > threshold);
		return errors;
	}

	public void progressBar(int epoch, int maxEpoch, int cycle, int cycleAmount, double costError) {
		int actual = ((epoch*cycleAmount)+cycle);
		int target = maxEpoch*cycleAmount;
		int bars = actual*100/target;
		System.out.print("[");
		for(int i = 0; i < bars; i++) {
			System.out.print('=');
		}
		for(int i = 0; i < 100-bars; i++) {
			System.out.print('-');
		}
		System.out.println("] Epoch: " + epoch + "/" + maxEpoch + ";  Error: " + costError + ";  Alpha: " + learnRate + ", Hyp: " + this.toString());
	}
	//getters and setters
	public double getLearnRate() {
		return learnRate;
	}

	public void setLearnRate(double learnGradient) {
		this.learnRate = learnGradient;
	}

	public ArrayList<Double> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<Double> errors) {
		this.errors = errors;
	}
	
	
}