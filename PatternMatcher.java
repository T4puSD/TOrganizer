import java.util.regex.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
//import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
class PatternMatcher{
	//private static String pattern= "(.*).(mp3|MP3|wav|WAV|wma|WMA|ogg|OGG|midi|MIDI|mp4|MP4|mkv|MKV|avi|AVI|flv|FLV|wmv|WMV|mov|MOV|ts|TS|zip|ZIP|7z|7Z|rar|RAR|txt|TXT|pdf|PDF)" ;
	private static String patternDocuments = "(.*).(pdf|PDF|doc|DOC|docx|DOCX|txt|TXT|csv|CSV)";
	private static String patternAudios = "(.*).(mp3|MP3|wav|WAV|wma|WMA|ogg|OGG|midi|MIDI)";
	private static String patternVideos = "(.*).(mp4|MP4|mkv|MKV|avi|AVI|flv|FLV|wmv|WMV|mov|MOV|ts|TS)";//|ts|TS)";
	private static String patternCompressedFiles = "(.*).(zip|ZIP|7z|7Z|rar|RAR|tar)";

	private static ArrayList<File> fileListArray = new ArrayList<>();
	
	// public void addNewPatternType(String pattern){
	// 	this.pattern = pattern;
	// }
	
//generating the file list
	public static void GenerateFileList(String source){
		
		try{
	
			File f = new File(source);
			

			File[] listfile = f.listFiles();

			for(File file: listfile){
				fileListArray.add(file);
			}

			//l.forEach(path->{System.out.println( path.getName());});

			fileListArray.forEach(path->{
				try{
					new PatternMatcher().isMatched(path);
				}catch(Exception e){
					//System.out.println("\n\n Exception forEach : "+e); //if direcotory is found/file not found then isMatched method thorows exception null pointer
				}
			});
		}catch(Exception e){
			//System.out.println("\n\nException generatefilelist : "+e);
			throw e; //this exception will need to be handle from the contex it is called
		}
	}
	

//executing move operation	
	public void isMatched(File sourcePath) throws Exception{

		String fileName = null;


		try{
			fileName = sourcePath.getName();
		} catch( Exception e){
			System.out.println("\n\nException isMathced :"+e);
		}
		//System.out.println(fileName);
		//ArrayList<String> traversedFiles = new ArrayList<>();

		// Pattern p = Pattern.compile(pattern);
		// Matcher m = p.matcher(fileName);

		Pattern pdocuments = Pattern.compile(patternDocuments);
		Pattern paudios = Pattern.compile(patternAudios);
		Pattern pvideos = Pattern.compile(patternVideos);
		Pattern pcompressed = Pattern.compile(patternCompressedFiles);

		Matcher mdocuments = pdocuments.matcher(fileName);
		Matcher maudios = paudios.matcher(fileName);
		Matcher mvideos = pvideos.matcher(fileName);
		Matcher mcompressed = pcompressed.matcher(fileName);

		//if(m.find()){
			//System.out.println("Found Value: "+m.group(0));
			//System.out.println("Found Value: "+m.group(1));
			//System.out.println("Found Value: "+m.group(2));
			//System.out.println("Found Value: "+m.group(3));
			
			//traversedFiles.add(m.group(0));


		//Decide which folder the file needed to be copied
			File f = null;

			if(mdocuments.find()){
				f = new File(sourcePath.getParent()+File.separator+"TDOCUMENTS");
				f.mkdir();

				//traversedFiles.add(m.group(0));

				// Files.move(sourcePath.toPath(),
				// 	new File(sourcePath.getParent()+File.separator+f.getName()+File.separator+fileName).toPath(),StandardCopyOption.REPLACE_EXISTING);
			}

			if(mvideos.find()){
				f = new File(sourcePath.getParent()+File.separator+"TVIDEOS");
				f.mkdir();

				//traversedFiles.add(m.group(0));
				// if(!sourcePath.isDirectory()){
				// 	Files.move(sourcePath.toPath(),
				// 		new File(sourcePath.getParent()+File.separator+f.getName()+File.separator+fileName).toPath(),StandardCopyOption.REPLACE_EXISTING);
				// }
			}

			if(maudios.find()){
				f = new File(sourcePath.getParent()+File.separator+"TAUDIOS");
				f.mkdir();

				//traversedFiles.add(m.group(0));

				// Files.move(sourcePath.toPath(),
				// 	new File(sourcePath.getParent()+File.separator+f.getName()+File.separator+fileName).toPath(),StandardCopyOption.REPLACE_EXISTING);
			}

			if(mcompressed.find()){
				f = new File(sourcePath.getParent()+File.separator+"TCOMPRESSEDFILES");
				f.mkdir();

				//traversedFiles.add(m.group(0));

				// Files.move(sourcePath.toPath(),
				// 	new File(sourcePath.getParent()+File.separator+f.getName()+File.separator+fileName).toPath(),StandardCopyOption.REPLACE_EXISTING);
			}
		//finally moving file using Files.move
			 if(!sourcePath.isDirectory()){
				 	Files.move(sourcePath.toPath(),
				 		new File(sourcePath.getParent()+File.separator+f.getName()+File.separator+fileName).toPath(),StandardCopyOption.REPLACE_EXISTING);
				 }

		//} else {
		//	System.out.println("NO MATCH : \t"+fileName);
			//return false;
		//}
	}

}

class PatternDemo{
	public static void main(String[] args) {
		PatternMatcher p = new PatternMatcher();

		System.out.println("Enter the Directory Path:\t");
		Scanner sc = new Scanner(System.in);
		String source = sc.nextLine();
		try{
			p.GenerateFileList(source);
		} catch(Exception e){
			System.out.println("Exception in main: "+e);
		}
	}
}