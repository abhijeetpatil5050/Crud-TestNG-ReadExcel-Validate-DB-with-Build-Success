package com.abp.util;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelUtil {

	public static void main(String[] args){
		readTestData();
	}
	
	
	@SuppressWarnings({ "deprecation"})
	public static Object[][] readTestData(){
		//Object [][] testData = new Object[row][coln];
		Object [][] testData = new Object[6][3];
		//11 -- No of records
		//3 -- No of values in each record
		
		int rowCount = 0;
		int cellCount = 0;
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook("D://abhi.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try{
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			Iterator<Row> rows = sheet.iterator();
			
			boolean flag = true;
			
			while(rows.hasNext()){
									Row singleRow = rows.next();
									if(flag){
										flag=false; //just to skip first row
										continue;
									}
									
									System.out.println("\n");
									Iterator<Cell> cells = singleRow.iterator();
											while(cells.hasNext()){
													Cell singleCell = cells.next();
													
													if(singleCell.getCellType()==0){
														System.out.print((int)singleCell.getNumericCellValue() +" | ");
													}else if(singleCell.getCellType()==1){
														String cellValue = singleCell.getStringCellValue().equals("NA") ? null : singleCell.getStringCellValue();
													
													/*	if("S.No".equals(cellValue))
															continue;*/
														testData[rowCount][cellCount] = cellValue;
														cellCount++;
														System.out.print(cellValue +" | ");
													}else{
														System.out.println("Invalid cell type -- "+singleCell.getCellType());
													}
											}
											rowCount++;
											cellCount=0;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(workbook!=null)
					workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return testData;
	}
	
	
}


/*
 * 
 * 
 * C:\Users\Yogesh\Desktop\J#7\testdata.xlsx
 * 
 * 
 * <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>3.7</version>
</dependency>
Excel < = 2007
	HSSF -- POI

	XSSF -- POI-OoXML

>=2007
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>3.15</version>
</dependency>

 * 
 * 
 * 
 * 
 */
