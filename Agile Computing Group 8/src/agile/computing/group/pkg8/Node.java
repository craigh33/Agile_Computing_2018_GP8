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
    
    public String returnResearcher(){
        return researcher;       
    }
    
    public String returnDownload_URL(){
        return download_URL;
    }
    
    public String returnComments(){
        return comments;
    }
    
    public float returnDay(){
        return day;
    }
    
    public float returnMonth(){
        return month;
    }
    
    public float returnYear(){
        return year;
    }
    
    public boolean returnResearcherSig(){
        return researcherSig;
    }
    
    public boolean returnRISSig(){
        return risSig;
    }
    
    public boolean returnDepDeanSig(){
        return depDeanSig;
    }
    
    public boolean returnDeanSig(){
        return deanSig;
    }
    
    public String editResearcher(String edit){
        researcher = edit;
        return researcher;       
    }
    
    public String editDownload_URL(String edit){
        download_URL = edit;
        return download_URL;
    }
    
    public String editComments(String edit){
        comments = edit;
        return comments;
    }
    
    public float editDay(float edit){
        day = edit;
        return day;
    }
    
    public float editMonth(float edit){
        month = edit;
        return month;
    }
    
    public float editYear(float edit){
        year = edit;
        return year;
    }
    
    public boolean editResearcherSig(boolean edit){
        researcherSig = edit;
        return researcherSig;
    }
    
    public boolean editRISSig(boolean edit){
        risSig = edit;
        return risSig;
    }
    
    public boolean editDepDeanSig(boolean edit){
        depDeanSig = edit;
        return depDeanSig;
    }
    
    public boolean editDeanSig(boolean edit){
        deanSig = edit;
        return deanSig;
    }
}
