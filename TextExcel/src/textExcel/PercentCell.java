package textExcel;

public class PercentCell extends RealCell{

	private String abbrTxt;
	private String fullTxt;
	//constructor for PercentCell
	public PercentCell (String percent) {		
		super(percent);
		fullTxt = (Double.parseDouble(percent.substring(0,percent.length()-1)))/100 + "";
		String temp = percent.substring(0,percent.indexOf("."));
		if (temp.length() < 9) {
			temp += "%          ";
			abbrTxt = temp.substring(0,10);
		}else {
		abbrTxt = temp.substring(0,9) + "%";
		
		}
	}
	
	public String abbreviatedCellText() { //getter for abbreviatedText
		return abbrTxt;
	}
	public String fullCellText() { //getter for fullText
	
		return fullTxt;
	}
	
	public double getDoubleValue() { //getter for doubleValue
		return Integer.parseInt(fullTxt);
				
	}
}
