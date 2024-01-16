package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {

    @DataProvider(name="logindata")
	String[][] Dp_getcelldata() throws IOException
    {
		String path="C:\\eclipse\\opencart\\Testdata\\Copy of Opencart_LoginData.xlsx";
        ExcelUtility file=new ExcelUtility(path);
    	  int row_number=file.getRowCount("Sheet1");
    		int cell_count=file.getCellCount("Sheet1",0);
	    String a[][]=new String[row_number][cell_count];
		for(int r=1;r<=row_number;r++) 
		    {
			
			for(int c=0;c<cell_count;c++)
			     {
				String celldata=file.getCellData("Sheet1", r, c);
				 a[r-1][c]=celldata;
				 }
			}
		return a;
	 }
}
