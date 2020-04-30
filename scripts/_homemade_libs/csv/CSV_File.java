package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSV_File {

	protected String file;
	protected List<List<String>> contents;
	public CSV_File(String file) {
		this.file = file;
		this.pullContents();
	}
	
	protected void pullContents() {
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		    //System.out.println(records.toString());
		    this.contents = records;
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public List<List<String>> getContents(){
		return contents;
	}
	
	public String toString() {
		if(contents == null) {
			return "Empty file or failed to get contents";
		}else {
			String string = "";
			Iterator<List<String>> content_itr = contents.iterator();
			while(content_itr.hasNext()) {
				List<String> rows = content_itr.next();
				Iterator<String> rows_itr = rows.iterator();
				while(rows_itr.hasNext()) {
					String cell = rows_itr.next();
					string += cell + ',';
				}
				string += "\n";
			}
			return string;
		}
	}
}
