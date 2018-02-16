/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

/**
 *
 * @author craig
 */
public class Node {
    
    private String researcher;
    private int day;
    private int month;
    private int year;
    private String download_URL;
    private String comments;
    private boolean risSig;
    private boolean researcherSig;
    private boolean depDeanSig;
    private boolean deanSig;
    
    /*
    * Constructor for Class Node
    *
    * @author Craig
    */
    void Node(){
        this.researcher = null;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.download_URL = null;
        this.comments = null;
        this.risSig = false;
        this.researcherSig = false;
        this.depDeanSig = false;
        this.deanSig = false;
    }
    
    /*
    * @return String - Researchers Name
    *
    * @author Craig
    */
    public String returnResearcher(){
        return researcher;       
    }
    
    /*
    * @return String - Document Download link
    *
    * @author Craig
    */
    public String returnDownload_URL(){
        return download_URL;
    }
    
    /*
    * @return String - Comments for Project
    *
    * @author Craig
    */
    public String returnComments(){
        return comments;
    }
    
     /*
    * @return int - Day of Creation
    *
    * @author Craig
    */
    public int returnDay(){
        return day;
    }
    
     /*
    * @return int - Month of Creation
    *
    * @author Craig
    */
    public int returnMonth(){
        return month;
    }
    
     /*
    * @return int - Year of Creation
    *
    * @author Craig
    */
    public int returnYear(){
        return year;
    }
    
     /*
    * @return Boolean -if project has been signed off by Researcher
    *
    * @author Craig
    */
    public boolean returnResearcherSig(){
        return researcherSig;
    }
    
     /*
    * @return Boolean - if project has been signed off by RIS
    *
    * @author Craig
    */
    public boolean returnRISSig(){
        return risSig;
    }
    
     /*
    * @return Boolean - if project has been signed off by Deputy Dean
    *
    * @author Craig
    */
    public boolean returnDepDeanSig(){
        return depDeanSig;
    }
    
     /*
    * @return Boolean - if project has been signed off by Dean
    *
    * @author Craig
    */
    public boolean returnDeanSig(){
        return deanSig;
    }
    
     /*
    * @param String - new Researchers Name
    *
    * @return Researchers Name
    *
    * @authot Craig
    */
    public String editResearcher(String edit){
        researcher = edit;
        return researcher;       
    }
    
     /*
    * @param String - new download url
    *
    * @return Download URL
    *
    * @author Craig
    */
    public String editDownload_URL(String edit){
        download_URL = edit;
        return download_URL;
    }
    
     /*
    * @param String - new Comments
    *
    * @return String - Comments
    *
    * @author Craig
    */
    public String editComments(String edit){
        comments = edit;
        return comments;
    }
    
     /*
    * @param int - new day of creation
    *
    * @return int - Day of creation
    *
    * @author Craig
    */
    public int editDay(int edit){
        day = edit;
        return day;
    }
    
     /*
    * @param int - new Month of creation
    *
    * @return int - Month of creation
    *
    * @author Craig
    */
    public int editMonth(int edit){
        month = edit;
        return month;
    }
    
     /*
    * @param int - new Year of creation
    *
    * @return int - Year of creation
    *
    * @author Craig
    */
    public float editYear(int edit){
        year = edit;
        return year;
    }
    
     /*
    * @param Boolean - edit if researcher has signed project
    *
    * @return Boolean - If researcher has signed doc
    *
    * @author Craig
    */
    public boolean editResearcherSig(boolean edit){
        researcherSig = edit;
        return researcherSig;
    }
    
     /*
    * @param Boolean - edit if RIS has signed project
    *
    * @return Boolean - If RIS has signed doc
    *
    * @author Craig
    */
    public boolean editRISSig(boolean edit){
        risSig = edit;
        return risSig;
    }
    
     /*
    * @param Boolean - edit if Deputy Dean has signed project
    *
    * @return Boolean - If Deputy Dean has signed doc
    *
    * @author Craig
    */
    public boolean editDepDeanSig(boolean edit){
        depDeanSig = edit;
        return depDeanSig;
    }
    
     /*
    * @param Boolean - edit if Dean has signed project
    *
    * @return Boolean - If Dean has signed doc
    *
    * @author Craig
    */
    public boolean editDeanSig(boolean edit){
        deanSig = edit;
        return deanSig;
    }
}
