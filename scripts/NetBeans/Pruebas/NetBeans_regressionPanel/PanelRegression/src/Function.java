import java.util.ArrayList;
import java.util.Iterator;

public class Function {

	protected ArrayList<Param> params;
	
	public Function() {
		params = new ArrayList<Param>();
	}
	
        @Override
	public String toString() {
		if(params.isEmpty()) {
			return "Empty function";
		}
		String string = "";
		Iterator<Param> itr = params.iterator();
		while(itr.hasNext()) {
			if(!string.equals("")) {
				string += " + ";
			}
			Param param = itr.next();
			string += param.toString();
		}
		return string;
	}
        
        public String toString_multipleLines() {
		if(params.isEmpty()) {
			return "Empty function";
		}
		String string = "";
		Iterator<Param> itr = params.iterator();
		while(itr.hasNext()) {
			if(!string.equals("")) {
				string += " +\n";
			}
			Param param = itr.next();
			string += param.toString();
		}
		return string;
	}
	
	public double value(double x) {
		if(params.isEmpty()) {
			return 0;
		}
		double val = 0;
		Iterator<Param> itr = params.iterator();
		while(itr.hasNext()) {
			Param param = itr.next();
			val += param.value(x);
		}
		return val;
	}
	
	public void add(Param param) {
		params.add(param);
	}
        
        public boolean isEmpty(){
            return params.isEmpty();
        }
        
        public void clear(){
            this.params.clear();
        }
}
