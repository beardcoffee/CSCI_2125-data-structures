import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
/**
 * A recursive file pre-processor.
 * @author Brian
 * @version hw1_2
 */ 

public class FileProcessor{

	private File output; //file we will output the pre-processed input
	private ArrayList<String> usedFiles = new ArrayList<String>(); //used for duplicates


	FileProcessor(String output){
			this.output = new File(output);
			createFile();
	}//end constructor

	/**
	 * Checks if output file already exists
	 * Deletes if there is and creates new 
	 * output file.
	 */
	private void createFile(){
		try{
			if(output.exists()){
				output.delete();
			}
			output.createNewFile();
		}catch(IOException e){
			System.out.println("Failed creating output file.");
		}		
	}//end method createFile

	/**
	 *
	 * @param input The file we will be inputting to be pre-processed.
	 *        		used for any files that must be included as well.
	 */
	public void process(File input){
		FileWriter fw = null;	
		FileReader fr = null;
		BufferedReader br = null;	
		BufferedWriter bw = null;
		try{
			usedFiles.add(input.getName());

			fr = new FileReader(input);
			fw = new FileWriter(output, true); //append
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			String currentLine;

			while((currentLine = br.readLine()) != null){
				if(currentLine.startsWith("#")){

					String[] include = currentLine.split("\\s+");

					for (int i = 0; i < 2; i++){
						include[i] = include[i].replaceAll("[^\\w]", "");
					}

					if(duplicateCheck(include[1])){
						File includeThis = new File(include[1]);

						process(includeThis);
					}
				}else{
					bw.write(currentLine + "\n");
				}			
			}
			br.close();
			bw.close();	
		}catch(IOException e){
			e.printStackTrace();
		}
	}//end method process

	private boolean duplicateCheck(String fileToCheck){
		for(String used : usedFiles){
			if(used.equals(fileToCheck)){
				return false;
			}
		}
		return true;
	}//end method duplicateCheck

}//end class FileProcessor