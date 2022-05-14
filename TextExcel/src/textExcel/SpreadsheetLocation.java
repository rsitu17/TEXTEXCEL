package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
	
	
    @Override
    public int getRow() //getter for rows
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol() //getter for columns
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocation(String cellName) //constructor that takes in a string and calculated the row and column
    {
    	row = Integer.parseInt(cellName.substring(1))-1;
    	col = cellName.toUpperCase().charAt(0) - 'A';
    }

}
