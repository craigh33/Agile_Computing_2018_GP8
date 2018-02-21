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
    
    private int projectID;
    private String projectName;
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
    
    /**
     * Constructor for Node Class
     * 
     * @author Craig
     */
    void Node(){
        this.projectName = null;
        this.projectID = 0;
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

    /**
     *
     * @return var - returns the projects name
     */
    public String returnProjectName(){
        String var = projectName;
        return var;       
    }
    
     /**
     *
     * @return var - returns the projects ID number
     */
    public int returnProjectID(){
        int var = projectID;
        return var;       
    }
    
    /**
     *
     * @return var - returns the projects researchers name
     */
    public String returnResearcher(){
        String var = researcher;
        return var;       
    }

    /**
     *
     * @return var - returns the file download link
     */
    public String returnDownload_URL(){
        String var = download_URL;
        return var;
    }

    /**
     *
     * @return var - returns any comments about the project
     */
    public String returnComments(){
        String var = comments;
        return var;
    }

    /**
     *
     * @return var - the day of the project creation
     */
    public int returnDay(){
        int var = day;
        return var;
    }

    /**
     *
     * @return var - the month of the project creation
     */
    public int returnMonth(){
        int var = month;
        return var;
    }

    /**
     *
     * @return var - the year of the project creation
     */
    public int returnYear(){
        int var = year;
        return var;
    }
    
    /**
     *
     * @return var - if it has been signed or not by the Reaearcher
     */
    public boolean returnResearcherSig(){
        Boolean var = researcherSig;;
        return var;
    }

    /**
     *
     * @return var - if it has been signed or not by the RIS
     */
    public boolean returnRISSig(){
        Boolean var = risSig;
        return var;
    }

    /**
     *
     * @return var - if it has been signed or not by the Deputy Dean
     */
    public boolean returnDepDeanSig(){
        Boolean var = depDeanSig;
        return var;
    }

    /**
     *
     * @return var - if it has been signed or not by the Dean
     */
    public boolean returnDeanSig(){
        Boolean var = deanSig;
        return var;
    }

    /**
     *
     * @param edit - What the new project name is
     * @return edit - What the new projectname is
     */
    public String editProjectName(String edit){
        projectName = edit;
        return edit;       
    }
    
    /**
     *
     * @param edit - What the new Project ID is
     * @return edit - The project ID
     */
    public int editProjectID(int edit){
        projectID = edit;
        return edit;       
    }
    
    /**
     *
     * @param edit - What the researchers name will be changed to
     * @return edit - What the new researcher name is
     */
    public String editResearcher(String edit){
        researcher = edit;
        return edit;       
    }

    /**
     *
     * @param edit - What the download link will be changed to
     * @return edit - What the new download link is
     */
    public String editDownload_URL(String edit){
        download_URL = edit;
        return edit;
    }

    /**
     *
     * @param edit - What the comments will be changed to
     * @return edit - What the new comments will be
     */
    public String editComments(String edit){
        comments = edit;
        return edit;
    }

    /**
     *
     * @param edit - What day the project was created
     * @return edit - What the creation day is
     */
    public int editDay(int edit){
        day = edit;
        return edit;
    }

    /**
     *
     * @param edit - What month the project was created
     * @return edit - What the creation month is
     */
    public int editMonth(int edit){
        month = edit;
        return edit;
    }

    /**
     *
     * @param edit - What year the project was created
     * @return edit - What the creation year is
     */
    public int editYear(int edit){
        year = edit;
        return edit;
    }

    /**
     *
     * @param edit - if the document has been signed or not by the researcher
     * @return edit - if it now has been signed or not by researcher
     */
    public boolean editResearcherSig(boolean edit){
        researcherSig = edit;
        return edit;
    }

    /**
     *
     * @param edit - if the document has been signed or not by the RIS
     * @return edit - if it now has been signed or not by RIS
     */
    public boolean editRISSig(boolean edit){
        risSig = edit;
        return edit;
    }

    /**
     *
     * @param edit - if the document has been signed or not by the Deputy Dean
     * @return edit - if it now has been signed or not by Deputy Dean
     */
    public boolean editDepDeanSig(boolean edit){
        depDeanSig = edit;
        return edit;
    }

    /**
     *
     * @param edit - if the document has been signed or not by the Dean
     * @return edit - if it now has been signed or not by the Dean
     */
    public boolean editDeanSig(boolean edit){
        deanSig = edit;
        return edit;
    }
}
