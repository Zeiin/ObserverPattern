package studentCoursesBackup.util;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
    private String results[] = new String[10]; 
    int numCount = 0;
    private String output;
    private BufferedWriter outputFile; //for writing into the file
    
    public Results(String outputFile){
        output = outputFile;
    }
    /* Lets us add results as we make them one by one */
    public void setResult(String s){
        if(numCount < 10){
        results[numCount] = s;
        numCount++;
        }
    }
    
    /* used to open our bufferedwriter */
    
    public void openWriter(String fileName){
        try{
        outputFile = new BufferedWriter(new FileWriter(fileName, true));
        }
        catch (Exception e){
            System.out.println("File not found");
        }
    }
    
    public void closeWriter(){
        try{
        outputFile.close();
        }
        catch (Exception e){
            System.out.println("File not found");
            
        }
    }
    
    public void writeLine(String s){
        try{
        outputFile = new BufferedWriter(new FileWriter(this.output, true));
        }
        catch (Exception e){
            System.out.println("File not found");
        }
        try{
            outputFile.newLine();
            outputFile.write(s);
            outputFile.close();
        }
        catch (Exception e){
            System.out.println("File not found or opened");
            
        }
    }
    
      public void writeToStdout(String s){
        System.out.println(s);
    }
}