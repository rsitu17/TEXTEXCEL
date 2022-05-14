package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell {
	private static final String RealCell = null;
	private String fullTxt;
	private String abbrTxt;
	private Spreadsheet sheet;
	
	//constructor for FormulaCell
	public FormulaCell(String userInput, Spreadsheet spreadsheet) {
		super(userInput);
		fullTxt = userInput;
		abbrTxt = fullTxt;
		sheet = spreadsheet;
		
	}
	
	public String abbreviatedCellText() { //getter for abbreviated text, returns a copy of the cell in getDoubleValue(), then truncate to 10 characters
		abbrTxt = getDoubleValue() + "          ";
		abbrTxt = abbrTxt.substring(0,10);
		return abbrTxt;

	}
	
	public String fullCellText() { //getter for full text
		return fullTxt;
	}
	
	public double getDoubleValue() { //method that handles calculations, return double value of the formula, cell references, and avg and sum commands
		String formula = fullTxt.substring(2,fullTxt.length()-2);
		String[] spltEqn = formula.split(" ");
		double total = 0.0;
		
		if(spltEqn[0].equalsIgnoreCase("avg") || spltEqn[0].equalsIgnoreCase("sum")) { //checks if it is avg or sum command
			spltEqn[1] = spltEqn[1].toUpperCase();
			
			Location loc1 = new SpreadsheetLocation(spltEqn[1].substring(0,spltEqn[1].indexOf('-')));
			Location loc2 = new SpreadsheetLocation(spltEqn[1].substring(spltEqn[1].indexOf('-') + 1 ));
			int count = 0;
			
			for (int i = loc1.getCol(); i <= loc2.getCol(); i++) { //loop through cells
				for (int j = loc1.getRow(); j <= loc2.getRow(); j++ ) {
					Location currentLoc = new SpreadsheetLocation("" + ((char) (i + 'A')) +""+(j + 1));
					total += (((RealCell) sheet.getCell(currentLoc)).getDoubleValue());
					count++;
				}
			}
			 
			if (spltEqn[0].equalsIgnoreCase("avg")) { //check if command was "avg"
				//int totalNum = (loc2.getCol() - loc1.getCol() + 1) * (loc2.getRow() - loc1.getRow() + 1);
				total /= count;
			}
			return total;
		}
		else {
			for (int i = 0; i <spltEqn.length; i +=2) { //handles cell references
				if(spltEqn[i].charAt(0) - 'A' >= 0) {
					Location refLoc = new SpreadsheetLocation(spltEqn[i]);
					spltEqn[i] = ((RealCell) sheet.getCell(refLoc)).getDoubleValue() + "";
					
				}
			}
			total = Double.parseDouble(spltEqn[0]);
			for (int i =1; i < spltEqn.length; i +=2) { // solving formula with order of operations (1st loop checks for multiplication or division in loop)
				
				if(spltEqn[i].equals("*")) {
					total *= Double.parseDouble(spltEqn[i + 1]);
					//spltEqn[i + 1] = (Double.parseDouble(spltEqn[i - 1]) * Double.parseDouble(spltEqn[i + 1])) + "";
					//spltEqn[i] = spltEqn[i -2];
					//spltEqn[i - 1] = "0";
				} else if (spltEqn[i].equals("/")) {
					total /= Double.parseDouble(spltEqn[i + 1]);
					//spltEqn[i + 1] = (Double.parseDouble(spltEqn[i - 1]) / Double.parseDouble(spltEqn[i + 1])) + "";
					//spltEqn[i] = spltEqn[i - 2];
					//spltEqn[i - 1] = "0";
					
				}
				else if(spltEqn[i].equals("+")) {
					total += Double.parseDouble(spltEqn[i + 1]);
				} else if(spltEqn[i].equals("-")) {
					total -= Double.parseDouble(spltEqn[i + 1]);
				}
			}
			return total;
		}
	}
	
//	public static boolean isNumeric(String str) {
//		try {
//			Double.parseDouble(str);
//			return true;
//		}catch (NumberFormatException e) {
//			return false;
//		}
//	}
}
