package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	private Cell[][] sheet = new Cell [getRows()][getCols()];

	@Override
	public String processCommand(String command)
	{
		if(command.equals("")) 
			return "";	//returns nothing (empty string)
		String[] spltCommand = command.split(" ",3);
		spltCommand[0].toUpperCase();
		if (command.contains("=")){
			
			Location loc = new SpreadsheetLocation(spltCommand[0]); 
			if (command.endsWith("\"")) // Text Cell
				sheet[loc.getRow()][loc.getCol()] = new TextCell(spltCommand[2]);
		else if (spltCommand[2].contains("%")) //PercentCell
			sheet[loc.getRow()][loc.getCol()] = new PercentCell(spltCommand[2]);
		else if (spltCommand[2].contains("(")) //FormulaCell
			sheet[loc.getRow()][loc.getCol()] = new FormulaCell(spltCommand[2],this);
		else
			sheet[loc.getRow()][loc.getCol()] = new ValueCell (spltCommand[2]);//(spltCommand[2]); //ValueCell
		
	
			return getGridText();
			

		}
		if (command.toLowerCase().contains("clear")){
			if (command.equalsIgnoreCase("clear")) {
				for (int i = 0; i < this.sheet.length; i++) {
					for (int j = 0; j < this.sheet[i].length; j++) {
						this.sheet[i][j] = new EmptyCell();
					}
				}
			} else {
				Location clearLoc = new SpreadsheetLocation(command.substring(command.indexOf(" ") + 1).toUpperCase());
				this.sheet[clearLoc.getRow()][clearLoc.getCol()] = new EmptyCell();
			}
			return getGridText();
		}
		else if(command.length() <=3) {
			Location cellLoc = new SpreadsheetLocation(command.toUpperCase());
			return getCell(cellLoc).fullCellText();
		}
		return "";
		
	}

	public Spreadsheet() {
		this.sheet = new Cell[getRows()][getCols()];
		for (int i = 0; i <getRows(); i++) {
			for (int j = 0; j < getCols(); j++)
			{
				sheet[i][j] = new EmptyCell();
			
			}
		}
	}
	@Override
	public int getRows()
	{
		
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		if (loc.getRow()<0 || loc.getRow() >= getRows()||
				loc.getCol() < 0 || loc.getCol() >= getCols())
			return null;
		loc.getRow();
		loc.getCol();
		return this.sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
//		String retValue = "";
//
//        // First line
//    
//	
		String text = "   ";
		for(char C = 'A'; C < 'L' + 1; C++) {
			text += "|" + C + "         ";
			
		}
		text += "|\n";
		for (int r = 0; r < getRows(); r++) {   
			if ( r + 1 <10) text += (r + 1) + "  ";
			else text += (r + 1) +  " ";
			for (int c = 0; c< getCols(); c++) {
				text += "|" + this.sheet[r][c].abbreviatedCellText();
			}
			text += "|\n";
		}
		return text;
		}
		}


