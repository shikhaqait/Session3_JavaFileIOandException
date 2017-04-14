import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MrmCount {
	
	public static void bufferRead() throws NameContainNumberException, NameContainsInvalidCharsException
	{
		try
		{
			Xls_Reader obj = new Xls_Reader(System.getProperty("user.dir") + "\\src\\booze_party.xlsx");
			//System.out.println(System.getProperty("user.dir") + "\\src\\booze_party.xlsx");
			
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("src\\mrm_party.txt"));
			String line1 = "";
			int lineNum = 1;
			while ((line1 = br.readLine()) != null) {
				if (line1.matches("[a-z]+")) {
					System.out.print(line1);
					System.out.print("\n");
					obj.setCellData("Sheet1", lineNum, line1); //Writing data by calling file Xls_Reader.java
				} else if (line1.matches(".*\\d+.*")) {
					throw new NameContainNumberException("NameContainsNumberException");
				}
				else {
					System.out.println("cotains special");
					throw new NameContainsInvalidCharsException("NameContainsInvalidCharsException");
				}
				lineNum++;
				if (lineNum++ > 100) {
					break;
				}
			}

		}
			  catch(IOException e)
			  {
			   System.out.println(e);
			  }
			 }

			 public static void main(String[] args) throws NameContainNumberException, NameContainsInvalidCharsException {
			  bufferRead();
			 }

			}


