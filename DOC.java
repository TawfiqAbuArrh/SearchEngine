public class DOC 
{
    private int Doc_ID;
    private int TF;
    
    public DOC (int Doc_ID)
    {
        this.Doc_ID = Doc_ID;
        TF = 1;
    }

    public DOC (int Doc_ID,int TF)
    {
        this.Doc_ID = Doc_ID;
        this.TF = TF;
    }
    
    public void set (int Doc_ID,int TF)
    {
        this.Doc_ID = Doc_ID;
        this.TF = TF;
    }
    
    public int getDoc_ID ()
    {
        return Doc_ID;
    }
    
    public int getTF()
    {
        return TF;
    }
}