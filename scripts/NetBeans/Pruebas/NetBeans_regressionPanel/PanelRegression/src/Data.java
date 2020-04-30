public class Data {

	private double x;
	private double y;
	
	public Data(double x,double y){
		this.x = x;
		this.y = y;
	}
	
        @Override
	public String toString() {
		return String.valueOf(x) + "," + String.valueOf(y);
	}

	//SETTERS GETTER
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
