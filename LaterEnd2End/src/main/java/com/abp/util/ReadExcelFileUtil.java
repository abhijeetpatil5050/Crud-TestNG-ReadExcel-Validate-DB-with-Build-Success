package com.abp.util;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFileUtil {
	
	public static void main(String[] args) throws Exception {
	
		FileInputStream file = new FileInputStream("D://abhi.xlsx");
		XSSFWorkbook wbk = new XSSFWorkbook(file);
		Sheet sht=wbk.getSheet("Sheet1");
		
		
		Iterator itr1=sht.iterator();	//setted first iterator itr1
		while(itr1.hasNext())
		{
			Row rowitr=(Row)itr1.next();
			
			
					Iterator itr2=rowitr.iterator();//setted second iterator itr2
					while(itr2.hasNext())
					{
						Cell colmitr=(Cell)itr2.next();
					
					
							//now read the contents
							switch (colmitr.getCellType()) 
							{
								case Cell.CELL_TYPE_NUMERIC:
									System.out.println(colmitr.getNumericCellValue());
									break;

								case Cell.CELL_TYPE_STRING:
									System.out.println(colmitr.getStringCellValue());
									break;
									
							}//switch ends here
							
					
					
					}//inner while ends
		
		}//outer while ends
		
		
		
	}
	
	
}
