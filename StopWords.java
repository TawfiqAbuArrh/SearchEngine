import java.io.File;
import java.util.*;
import java.io.*;


public class StopWords {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    ListOfStopWord word = new ListOfStopWord();
    
    ArrayList<Scanner> files = new ArrayList<>();    
    
    File folder = new File("C:\\Users\\Tawfiq\\Downloads\\RFCs0501-1000\\");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        File currentFile = listOfFiles[i];
            files.add(new Scanner(currentFile));
      } 

    //File file1 = new File("F:\\Document\\Moodle\\Retrieval\\New folder\\hhh.txt");
    //File file2 = new File("F:\\Document\\Moodle\\Retrieval\\Retrieval Project\\Corpus\\hi2.txt");
    //files.add(new Scanner(file1));
    //files.add(new Scanner(file2));
    
    

   
    PrintWriter writer = new PrintWriter("F:\\Document\\NetBeansProjects\\SearchEngine\\build\\classes\\To_Stemmer.txt", "UTF-8");
    for(int ii =0;ii < files.size();ii++) 
        { 
            //Integer ONE = new Integer(1);
            //Map map = new TreeMap();
            while(files.get(ii).hasNext())
            {
                int flag=1;
                String s1=files.get(ii).next();//read the words from Doc
                s1=s1.toLowerCase();
                s1 = s1.replaceAll("[0-9]","");//remove all number
                s1 = s1.replaceAll("[\'\\|/%()\\-_*][:.+?<>@,\"]","");//remove symbols
                    
                
                /*if (s1 == ".w")
                {
                s1=files.get(ii).next();*/
                for(int i=0;i<word.stopwords.length;i++)
                    if(s1.equals(word.stopwords[i]))
                        flag=0;//if the word was a stop word , go to the next word

                if(flag!=0) //if the word is not stop word
                {
                    if (s1.length() > 2)//to ignore all word less than 2 word like (.T)
                    {
                    /*
                    Integer frequency = (Integer) map.get(s1);
                    if (frequency == null) {
                        frequency = ONE;
                    } else {
                        int value = frequency.intValue();
                        frequency = new Integer(value + 1);
                    }
                    
                    map.put(s1, frequency);
                    System.out.println(map.toString());*/
                    writer.print(s1 + " ");
                    }                     
                }
                    
            }writer.print("\n");
            
        }
    writer.close();
    }
}