package textExcel;


public class RealCell implements Cell {
	
	private String value;
	
	public RealCell(String value) {
		this.value = value;
	}

	
	public String abbreviatedCellText() {
    	return (getDoubleValue() + "          ").substring(0,10);
	}
	public String fullCellText() {
		return value ;
		
		
	}
	public  double getDoubleValue() {
		return Double.parseDouble(this.value);
	}
	
}
