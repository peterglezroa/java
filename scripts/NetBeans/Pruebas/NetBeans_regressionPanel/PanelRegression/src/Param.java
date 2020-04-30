public class Param {

	private double coeficient;
	private double exponent;
	
	public Param(double coeficient, double exponent) {
		this.coeficient = coeficient;
		this.exponent = exponent;
	}
	
	
	public String toString() {
		return String.valueOf(this.coeficient) + "*x.^" + String.valueOf(this.exponent) + " ";
	}
	
	public double value(double x) {
		return Math.pow(x,exponent)*coeficient;
	}
	
	/*GETTER SETTER*/
	public double getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(double coeficient) {
		this.coeficient = coeficient;
	}
	public double getExponent() {
		return exponent;
	}
	public void setExponent(double exponent) {
		this.exponent = exponent;
	}
	
	
}
