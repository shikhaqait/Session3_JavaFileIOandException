import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadOddData {
	
	public static void ReadData() throws IOException
	{
		try {

			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\DataRead.xlsx"));
			Xls_Reader obj = new Xls_Reader(System.getProperty("user.dir") + "\\src\\DataRead.xlsx");
			int lineNum = 0;
			String line = "";
			while ((line = br.readLine()) != null) {
				lineNum++;
				if (lineNum % 2 != 0) {
					System.out.println(obj.getCellData("Sheet1", 0, lineNum));				
				}
			}
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException 
	{
		ReadData();
	}

}
