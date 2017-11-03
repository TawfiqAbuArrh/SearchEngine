import java.io.File;
import java.util.*;
import java.io.*;


public class StopWords {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    
        //Creat an object of ListOfStopWord, that contains all the stop word 
    ListOfStopWord word = new ListOfStopWord();
        
        //To Store All files in ArrayList
    ArrayList<Scanner> files = new ArrayList<>();    
    
        /*This is the working directory
        // I Download the curpos from "https://www.rfc-editor.org/retrieve/bulk/"
        // and i choose 501-1000 file and delete the PDF and AutoCad file, just keep the *.txt file
        */
    File folder = new File("C:\\Users\\******\\Downloads\\RFCs0501-1000\\");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        File currentFile = listOfFiles[i];
            files.add(new Scanner(currentFile));
      } 
   
        /* This where the result file will go
        // I saved it in the same folder of class of NetBeans Project
        */
    PrintWriter writer = new PrintWriter("***\\Document\\NetBeansProjects\\SearchEngine\\build\\classes\\To_Stemmer.txt", "UTF-8");
    for(int ii =0;ii < files.size();ii++) 
        { 
            while(files.get(ii).hasNext())
            {
                int flag=1;
                String s1=files.get(ii).next();//read the words from Doc
                s1=s1.toLowerCase();
                s1 = s1.replaceAll("[0-9]","");//remove all number
                s1 = s1.replaceAll("[\'\\|/%()\\-_*][:.+?<>@,\"]","");//remove symbols
                    
                
                for(int i=0;i<word.stopwords.length;i++)
                    if(s1.equals(word.stopwords[i]))
                        flag=0;//if the word was a stop word , go to the next word

                if(flag!=0) //if the word is not stop word
                    if (s1.length() > 2)//to ignore all word less than 2 word like (".T")
                        writer.print(s1 + " ");
                    
            }writer.print("\n");
        }
    writer.close();
    }
}
