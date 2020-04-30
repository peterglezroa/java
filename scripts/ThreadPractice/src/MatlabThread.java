import com.mathworks.engine.MatlabEngine;

public class MatlabThread implements Runnable{
	/*CHAR
	MatlabEngine matEng;
	try {
		matEng = MatlabEngine.startMatlab();
		System.out.println("Iniciando Matlab");
		matEng.eval("datax = " + data.trainingSet().toStringXs());
    	matEng.eval("datay = " + data.trainingSet().toStringYs());
    	matEng.eval("x =" + MINX + ":1:" + MAXX);
    	matEng.eval("y= " + target.toString());
    	matEng.eval("hyp= " + hyp.toString());
		matEng.eval("scatter(datax,datay); title('Graph'); hold on; plot(x,y); plot(x,hyp); hold off;", null, null); //red => y, yellow => hyp
		matEng.disconnect();
	}catch(Exception e) {System.out.println(e.getMessage());}
	/**/
	protected MatlabEngine matEng;
	
	public void run() {
		
	}
}
