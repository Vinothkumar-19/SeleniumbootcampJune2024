package org.testngwithbaseclassexcelintegration.copy;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExceldata extends Baseclass {
	public static String[][] readData() throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook(".\\data\\testdata.xlsx");

		XSSFSheet ws=wb.getSheet("Sheet1");

		int rowcount=ws.getLastRowNum();

		int cellcount=ws.getRow(rowcount).getLastCellNum();

String [][] data =new String [rowcount][cellcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++) {

				String value =ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=value;

			}
		}
		wb.close();
		return data;

	}

}

