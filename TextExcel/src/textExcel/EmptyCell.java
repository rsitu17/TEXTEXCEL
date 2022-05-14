package textExcel;

public class EmptyCell implements Cell 
{
	@Override
	public String abbreviatedCellText() // Getter for abbreviated text
	{
		return "          "; //spreadsheet text cell display and must have a length of 10
	}

	@Override
	public String fullCellText() //Getter for full text
	{					//individual cell inspection, not truncated or padded
		return ""; 
	}
}