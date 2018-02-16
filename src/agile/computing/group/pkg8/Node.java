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
    private float day;
    private float month;
    private float year;
    private String download_URL;
    private String comments;
    private boolean risSig;
    private boolean researcherSig;
    private boolean depDeanSig;
    private boolean deanSig;
    
    /*
    * Constructor for Class Node
    *
    * @authot Craig
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
    * @authot Craig
    */
    public String returnResearcher(){
        return researcher;       
    }
    
    /*
    * @return String - Document Download link
    *
    * @authot Craig
    */
    public String returnDownload_URL(){
        return download_URL;
    }
    
    /*
    * @return String - Comments for Project
    *
    * @authot Craig
    */
    public String returnComments(){
        return comments;
    }
    
     /*
    * @return Float - Day of Creation
    *
    * @authot Craig
    */
    public float returnDay(){
        return day;
    }
    
     /*
    * @return Float - Month of Creation
    *
    * @authot Craig
    */
    public float returnMonth(){
        return month;
    }
    
     /*
    * @return Float - Year of Creation
    *
    * @authot Craig
    */
    public float returnYear(){
        return year;
    }
    
     /*
    * @return Boolean -if project has been signed off by Researcher
    *
    * @authot Craig
    */
    public boolean returnResearcherSig(){
        return researcherSig;
    }
    
     /*
    * @return Boolean - if project has been signed off by RIS
    *
    * @authot Craig
    */
    public boolean returnRISSig(){
        return risSig;
    }
    
     /*
    * @return Boolean - if project has been signed off by Deputy Dean
    *
    * @authot Craig
    */
    public boolean returnDepDeanSig(){
        return depDeanSig;
    }
    
     /*
    * @return Boolean - if project has been signed off by Dean
    *
    * @authot Craig
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
    * @authot Craig
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
    * @authot Craig
    */
    public String editComments(String edit){
        comments = edit;
        return comments;
    }
    
     /*
    * @param float - new day of creation
    *
    * @return float - Day of creation
    *
    * @authot Craig
    */
    public float editDay(float edit){
        day = edit;
        return day;
    }
    
     /*
    * @param float - new Month of creation
    *
    * @return float - Month of creation
    *
    * @authot Craig
    */
    public float editMonth(float edit){
        month = edit;
        return month;
    }
    
     /*
    * @param float - new Year of creation
    *
    * @return float - Year of creation
    *
    * @authot Craig
    */
    public float editYear(float edit){
        year = edit;
        return year;
    }
    
     /*
    * @param Boolean - edit if researcher has signed project
    *
    * @return Boolean - If researcher has signed doc
    *
    * @authot Craig
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
    * @authot Craig
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
    * @authot Craig
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
    * @authot Craig
    */
    public boolean editDeanSig(boolean edit){
        deanSig = edit;
        return deanSig;
    }
}
