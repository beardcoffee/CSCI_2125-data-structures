/**
 * A simple file util for hw3
 *
 * @author Brian
 * @version homework3
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.*;

public class FileUtil{

	private ArrayList<String> testList = new ArrayList<String>();
	private String file;

	/**
	 * @param fileName name of the input file
 	 */
	public FileUtil(String fileName){
		this.file = fileName;

	}//end constructor

	/**
 	 * Converts the file content into an Array
	 */
	public ArrayList<String> fileToArray(){
		try{
			File input = new File(file);
			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			String s;

			while((s = br.readLine()) != null){
    			testList.add(s);
			}
		}catch(IOException e){
			System.exit(1);
		}

		return testList;
	}//end method fileToArray

	/**
	 * Converts array of strings into file 
	 *
	 * @param a input arraylist to be converted to file
	 */
	public void arrayToFile(ArrayList<String> a){
		File out = new File("out.txt");
		if(out.exists()){
			try{
				out.delete();
			}catch(Exception e){
				System.exit(1);
			}
		}
		try{
			FileWriter wr = new FileWriter("out.txt");
			for(int i = 0; i < a.size(); i++){
				String s = a.get(i);
				wr.write(s);
				if(i < a.size() - 1){
					wr.write("\n");
				}
			}
			wr.close();
		}catch(Exception e){
			System.exit(1);
		}

	}//end method arrayToFile

}//end clas FileUtil
