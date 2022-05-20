# TEXTEXCEL
Text Excel Word/Spreadsheet Processing
Spreadsheet.java: A class that implements the Grid interface (provided for you)
It must contain correct implementations of the getRows() and getCols() methods based on the total numbers of rows (20) and columns (12) required in the project description.  (These methods ignore header rows and columns counting only those with cells for which a user could provide input.)  
processCommand() should return an empty string.
In this checkpoint, none of the other Grid methods will be tested, so you may put in whatever dummy implementations you like as long as they compile.
Write a Spreadsheet constructor that initializes a 2D array of cells with all elements containing EmptyCell objects.

SpreadsheetLocation.java: A class that implements the Location interface
The Location interface must be fully and correctly implemented
SpreadsheetLocation must contain a constructor taking a single String parameter 
(e.g., “D20”).
Note that the testing file expects to treat “A1” as being at row 0 and column 0.  
(The header with the letters from A-L and the number column from 1-20 are not counted when determining location.)


TextExcel.java: A class with a main method that constructs a Spreadsheet, and has the command loop 
Reads commands, calls the spreadsheet’s processCommand method to process each line of input, prints the String returned from processCommand, and repeats until “quit” is read
For this checkpoint, the only command you need to implement is “quit”.  You do not need to actually correctly implement any others, but your program must compile and run without crashing. 

EmptyCell.java: A class that implements the Cell interface 
The Cell interface must be fully and correctly implemented.  
Copy the comments from the Cell interface into the appropriate locations in your EmptyCell class.
Note that the implementations of both methods in the Cell interface can be extremely simple.
TextCell class that implements the Cell interface and stores String values.
fullCellText() returns an exact copy of the original String entered into the cell including the quotation marks. 
abbreviatedCellText() returns the abbreviated version of the text including only 10 characters.  It does not include the original quotation marks. 

Spreadsheet class:


Implement the getCell method. 
The getCell method accepts a Location, and returns the Cell at that location. 
getGridText() method
Return a single String containing the entire spreadsheet grid.  (The String will get printed in a different method, but when printed should contain the header line with the letters across the top as well as the row numbers down the side, the grid lines, and all the entries. 

RealCell super class that implements the Cell interface. 
The RealCell super class should contain a field that stores the String representing what the user entered, in the same format you will print when the user asks to inspect a single cell. (For example, “5.8” for ValueCell, “0.02” for a PercentCell, and “( 5 + 3 * A2 )” or “( sum A6-B7 )” for a FormulaCell.) 
getDoubleValue() method that returns the calculated value of the cell as a double (not a String).

Three subclasses that extend RealCell: ValueCell, PercentCell, and FormulaCell

getDoubleValue() method of the FormulaCell class such that it contains all the parsing and calculation logic required to generate a numeric result for an arithmetic formula that may or may not contain cell references and can handle the SUM and AVG methods
