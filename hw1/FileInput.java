import java.io.File;
/**
 * A recursive file pre-processor.
 * @author Brian
 * @version hw1_2
 */ 

public class FileInput{

	public static void main(String[] args){
		if(args.length <= 1){

			System.out.println("Error: please use the proper args syntax!");
			System.out.println("Example: java FileInput <input> <output>");

		}else if(args.length > 2){

			System.out.println("Error: Too many args or invalid syntax!");
			System.out.println("Example: java FileInput <input> <output>");			

		}else if(args.length == 2){
			try{
				File input = new File(args[0]);
				if(input.exists() && input.isFile()){

					FileProcessor processor = new FileProcessor(args[1]);
					System.out.printf("Pre-processing: %s\n", args[0]);
					processor.process(input);
					System.out.printf("Complete! Output file: %s\n", args[1]);

				}else{

					System.out.printf("Error: %s does not exist.", args[0]);

				}	
			}catch(Exception e){
				System.exit(1);
			}
		}else {

			System.out.println("Unknown error, exiting.");

		}
	}
}