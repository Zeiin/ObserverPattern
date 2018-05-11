package studentCoursesBackup.util;
import java.io.BufferedReader;
import java.io.FileReader;


public class FileProcessor{
    
    BufferedReader inputFile;
    
    public FileProcessor(String fileName){
        try{
        inputFile = new BufferedReader(new FileReader(fileName));
        }
        catch (Exception e){
            System.out.println("File not found");
            
        }
    }
    
    public String readLine(){
        try{
            return inputFile.readLine();
        }
        catch (Exception e){
            System.out.println("File not found or opened");
        }
        return "";
        
    }
    
    
    
}