import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Index 
{
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        Scanner input = new Scanner(new File("To_Indexing.txt"));
        
        PrintWriter writer = new PrintWriter("F:\\Document\\NetBeansProjects\\SearchEngine\\build\\classes\\Done.txt", "UTF-8");
        //ArrayList<DOC> docArrayList = new ArrayList<>();
        //ArrayList<DOC> docArrayList = new ArrayList<>();
        //LinkedList<DOC> Docs = new LinkedList<>();
        
        
        //Map<String,DOC> docList = new HashMap();
        
        Map<String,LinkedList<DOC>> map = new HashMap();
        //Integer ONE = new Integer(1);

        String strLine;
        int Doc_ID =1;
        //strLine = input.nextLine();
        try{
        while ((strLine = input.nextLine()) != null)   
        {
            /*boolean enter = (strLine = input.nextLine()) != null;
            System.out.println(enter);*/
            //System.out.println("Doc" + Doc_ID + " : " + strLine);
            
            Scanner line = new Scanner(strLine);
            
            
            while(line.hasNext())
            {
                //DOC doc = new DOC();
                String s1 = line.next();
                //s1=s1.toLowerCase();
                //System.out.println("\nWords = " + s1);
                if (s1.length() > 0) 
                {
                    boolean exist = map.containsKey(s1);
                    if (exist == false) {
                        
                        LinkedList<DOC> Docs = new LinkedList<>();
                        
                        //System.out.println("Inside does not exist");
                        //doc.add(new Doc((int)ONE,i))
                        //docArrayList.add(doc = new DOC(Doc_ID,ONE));
                        
                        map.put(s1, Docs);
                        //map.get(s1).clear();
                        map.get(s1).add(new DOC(Doc_ID));
                        //docList.put(s1, new DOC(Doc_ID,ONE));
                        //frequency = ONE;
                    } else {
                        //System.out.print("Does Doc_ID: " + map.get(s1).getLast().getDoc_ID()
                               // + " =?= DOC_ID: " + Doc_ID +  " ?");
                        if (map.get(s1).getLast().getDoc_ID() == Doc_ID)
                        {
                            //System.out.println(" Yes");
                            //System.out.println("Size of LinkedList : " + map.get(s1).size());
                            //System.out.println("The TF for " + Doc_ID + " : " + map.get(s1).getLast().getTF());
                            //System.out.println("The last : " + map.get(s1).getLast().getTF());
                            
                            //System.out.print(s1 + ", First TF = " + map.get(s1).getLast().getTF());
                            //Docs.getFirst().set(Doc_ID, ((Docs.getFirst().getTF())+1));
                            
                            //map.get(s1).set((map.get(s1).g-Doc_ID), new DOC(Doc_ID, ((map.get(s1).getFirst().getTF())+1)));
                            map.get(s1).getLast().set(Doc_ID, ((map.get(s1).getLast().getTF())+1));
                            //map.get(s1).set((Doc_ID-1), new DOC().set(Doc_ID, (map.get(s1).getFirst().getTF()+1)));
                            //System.out.println(" Second TF = " + (map.get(s1).getLast().getTF()));
                            //map.put(s1, Docs);
                            //map.replace(s1, Docs);
                        }
                        else
                        {
                            //System.out.println(" No");
                            //System.out.println("The Second Line else if #######");
                            //System.out.println("The Doc ID = " + Doc_ID);
                            
                            //System.out.println("Size of LinkedList : " + map.get(s1).size());
                            
                            //System.out.println("Added to LinkedList");
                            
                            
                            map.get(s1).add(new DOC(Doc_ID,1));
                            
                            //System.out.println("Size of LinkedList : " + map.get(s1).size());
                            //map.replace(s1, Docs);
                            
                            //map.
                        }
                        //int index = docArrayList.indexOf(s1);
                        //System.out.println("index of " + s1 + ": " + index);
                        //(docArrayList.get(index).getTF()+1)
                                //doc.set(Doc_ID,((docArrayList.get(index).getTF()+1)));
                                
                        //docList.get(s1).set(Doc_ID, (docList.get(s1).getTF()+1));
                                
                                //doc.set(Doc_ID,(doc.getTF()+1));
                        //doc = new DOC(Doc_ID,(doc.getTF()+1));
                        //map.get(s1)
                        //int value = frequency.intValue();
                        //frequency = new Integer(value + 1);
                        //doc = new DOC(Doc_ID,new Integer(value + 1));
                    }
                    //map.put(s1, Docs);
                    //map.put(s1, docList.get(s1));
                    /*System.out.println(s1 + " [" + map.get(s1).getDoc_ID() + "," 
                            + map.get(s1).getTF()+ "]");
                    */
                    /*System.out.println(s1 + " [" + map.get(s1).getLast().getDoc_ID()
                            + ","+ map.get(s1).getLast().getTF() + "]");
                    */
                }
            }
            Doc_ID++;
        }
            /*int count = 0;
                for(int i = 0;i < map.get(input.next()).size();i++)
                {
                    System.out.print(input.next() + " ["
                    + map.get(input.next()).get(i).getDoc_ID() + ","
                    + map.get(input.next()).get(i).getTF() + "]");
                    count++;
                    if (map.get(input.next()).size() != count)
                        System.out.print(" -> ");
                    else
                        System.out.println();
                }*/
        }catch(NoSuchElementException e) {
            for (String key: map.keySet()) {
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
                /*
                Iterator list = map.get(key).descendingIterator();
                System.out.print(key + " [");
                while(list.hasNext())
                {
                    list.next()
                    DOC pair;
                    pair.getDoc_ID();
                    pair.getValue()
                list.get(i).getClass(DOC).
                System.out.print(list.get(i).getDoc_ID());
                        + map.get(key).get(i).getDoc_ID()
                + "," + map.get(key).get(i).getTF() + "]");
                map.get(key).get(i).getDoc_ID();
                count++;
                if (map.get(key).size() != count)
                    {System.out.print(" -> ");}
                else
                    {System.out.println();
                    count = 0;}
                i++;
                }*/
        }
        
    }writer.close();
}
}