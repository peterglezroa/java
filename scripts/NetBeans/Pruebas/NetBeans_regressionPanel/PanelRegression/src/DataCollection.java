public class DataCollection {
	
	private DataSet[] sets;
	private DataSet test;
	private int validation;
	private int index;
	private int DATASETS_AMOUNT = 5;
	
	public DataCollection() {
		sets = new DataSet[DATASETS_AMOUNT];
		validation = 0;
		index = -1;
		
		for(int i = 0; i < DATASETS_AMOUNT; i++) {
			sets[i] = new DataSet();
		}
		test = new DataSet();
	}
	
	public DataCollection(Function function, double minX, double maxX, double offset) {
		sets = new DataSet[DATASETS_AMOUNT];
		validation = 0;
		index = 0;
		for(int i = 0; i < DATASETS_AMOUNT; i++) {
			System.out.println("DATASET " + i + ": ");
			sets[i] = new DataSet(function, minX, maxX, offset);
		}
		System.out.println("TEST SET: ");
		test = new DataSet(function, minX, maxX, offset);
	}
	
	public void rotation() {
		validation = (validation+1)%DATASETS_AMOUNT;
	}
	
	/*
	public boolean isEmpty() {
		if(test.isEmpty() || index == -1) {
			return true;
		}
		
	}
	*/
	
	public void scale() {
		for(int i = 0; i < DATASETS_AMOUNT; i++) {
			sets[i].scale();
		}
		test.scale();
	}
	
	public DataSet trainingSet(){
		DataSet trainingSet = new DataSet();
		for(int i = 0; i < DATASETS_AMOUNT; i++) {
			if(i != validation) {
				trainingSet.concatenate(sets[i]);
			}
		}
		return trainingSet;
	}
	
	public DataSet validationSet() {
		return sets[validation];
	}
	
	public DataSet testSet() {
		return test;
	}
	
	public void pushSet(DataSet set) {
		sets[(index + 1)%DATASETS_AMOUNT] = set;
                index = (index+1)%DATASETS_AMOUNT;
	}

        public String toString(){
            String string = "DataCollection {";
            string += "\n   Dataset amount: " + this.DATASETS_AMOUNT;
            string += "\n   Actual validation set: " + this.validation;
            for(int i = 0; i < DATASETS_AMOUNT; i++){
                string += "\n   Set " + i + ": " + sets[i].toString();
            }
            string += "\n Test set: " + test.toString();
            string += "}";
            return string;
        }    
        
	public int getDATASETS_AMOUNT() {
		return DATASETS_AMOUNT;
	}

	public void setDATASETS_AMOUNT(int dATASETS_AMOUNT) {
		DATASETS_AMOUNT = dATASETS_AMOUNT;
	}
	
	
}
