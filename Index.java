import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Index 
{
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        //path and name of file to run Indexing on it.
        Scanner input = new Scanner(new File("To_Indexing.txt"));
        
        //Path of file that the result will save to it.
        PrintWriter writer = new PrintWriter("***\\Document\\NetBeansProjects\\SearchEngine\\build\\classes\\Done.txt", "UTF-8");
        
        
        /*A LinkedList of type of DOC Class that have a two value: Doc_ID and TF
        //and communicate with it by getter and setter
        */
        Map<String,LinkedList<DOC>> map = new HashMap();

        String strLine;
        int Doc_ID =1;

        try{
        while ((strLine = input.nextLine()) != null)   
        {
            Scanner line = new Scanner(strLine);
            
            while(line.hasNext())
            {
                String s1 = line.next();
                if (s1.length() > 0) 
                {
                    boolean exist = map.containsKey(s1);
                    if (exist == false) {
                        
                        LinkedList<DOC> Docs = new LinkedList<>();
                        
                        map.put(s1, Docs);
                        map.get(s1).add(new DOC(Doc_ID));
                    } 
                    else 
                    {
                        if (map.get(s1).getLast().getDoc_ID() == Doc_ID)
                            map.get(s1).getLast().set(Doc_ID, ((map.get(s1).getLast().getTF())+1));

                        else
                            map.get(s1).add(new DOC(Doc_ID,1));
                    }
                }
            }
            Doc_ID++;
        }
            
        }catch(NoSuchElementException e) {
            for (String key: map.keySet()) 
            {
                int i = 0 , count = 1;
                writer.print(key + " -> ");
                for(int j = 1 ;j <= map.get(key).size();j++)
                {
                    writer.print("[" + map.get(key).get(i).getDoc_ID()
                          +","  + map.get(key).get(i).getTF() + "]");
                    
                    
                    if (map.get(key).size() != count)
                        {
                            writer.print(" -> ");
                            count++;
                        }
                    else
                        writer.println();
                    
                    i++;
                }
            }
        }writer.close();
    }
}
