import java.io.File;
import java.util.Scanner;


public class Read_searchFile {
    static Scanner x;
    public static void main(String[] args){
        String filepath = "E:/bookticket.txt";
        String removeTerm;
        removeTerm(filepath, removeTerm);  
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        
    }
}
