import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class LockedMeSprint_2 {
private static void addFile(String filename) {
		
		File file = new File(MY_DIR + "\\" +  filename + ".txt");
		
		if(file.exists()) {
			System.out.println("The file '" + filename + "' already exists.");
			System.out.println("\n");
		} else {
			try {
				System.out.println("File created at location: " + file.getAbsolutePath());
				System.out.println("\n");
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
	}
	
	private static void deleteFile(String filename) {
		File file = new File(MY_DIR + "\\" + filename + ".txt");
		
		if(file.exists()) {
			file.delete();
			System.out.println("Deleted the file.");
			System.out.println("\n");
		} else {
			System.out.println("That file doesn't exist.");
			System.out.println("\n");
		}
	}
	
	private static void setMatch(boolean b) {
		App.matchFlag = b;
	}
	
	private static int searchFiles() {
		
		System.out.println("\n");
		System.out.println("Please enter a filename you would like to search for (Include file extension):");
		String temp = scan.nextLine();
		boolean matches = false;
		
		//Input validation
		while(temp.isEmpty()) {
			System.out.println("Error! Please enter a valid filename you would like to search for (Include file extension):");
			temp = scan.nextLine();
		}
		
		
		File[] files = new File(MY_DIR).listFiles();
        for(File file : files) {
        	 if (!file.isFile()) {
        		 //System.out.println("cont...");
                 continue;
             }
        	if(file.getName().toLowerCase().contains(temp.toLowerCase())) {
        		if(file.getName().equalsIgnoreCase(temp)) {
        			return 2;
        		}
        		System.out.println("Similar match found: " + file.getName());
        		return 1;
        	}
        	
        	matches = Pattern.matches(temp, file.getName());
        	
       		if(matches) {       	
       			//System.out.println("It matched!");
       			if(file.getName().equalsIgnoreCase(temp)) {
       				//System.out.println("IT SUPER MATCHED");
       				//"perfect match"
       				return 2;
        		}
       			System.out.println("Similar match found: " + file.getName());
       			return 1;
        	}
        }
		
		return 0;
	}

	private static boolean getMatchFlag() {
		return App.matchFlag;
	}

}
