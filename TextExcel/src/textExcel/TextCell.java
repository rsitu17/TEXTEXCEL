package textExcel;

public class TextCell implements Cell 
{
	private String contain;
	
    public TextCell(String text) {
        this.contain = text;
    }

    @Override
    public String abbreviatedCellText() {

    	String[] s = this.contain.split("\"");
    	if (s.length == 0 ) return "          ";
    	String contain = s[1];
    	if(contain.length() > 10) {
    		contain = contain.substring(0, 10);
    		
    	} else {
    		for (int i = contain.length(); i < 10; i = contain.length())
    			contain += " ";
    	}
    	return contain;
    	}


    @Override
    public String fullCellText() {
        // adds quotes before and after for syntax of tests
        //return "\"" + contain + "\"";
    	return contain;
    }

}


