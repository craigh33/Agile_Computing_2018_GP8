/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author craig
 */
public class GUI {

    /*
    * @author Craig
    *
    * Class To run Interface
    *
    * Returns nothing
    */
    void loginScreen() {
       JFrame f = new JFrame();//creates new frame
       
       JButton b = new JButton("click");//Creates new Button
       b.setBounds(130,100,100,40);//Sets size of button
       
       f.add(b);//Adds button to Frame
       
       f.setSize(400,500);//size of frame
       f.setLayout(null);//no layout manager
       f.setVisible(true);//makes it visible
       }
    
     /*
    * @param 
    *
    * @return 
    *
    * @authot Craig
    */
    void mainScreen(){
        
    }
    
     /*
    * @param
    *
    * @return 
    *
    * @authot Craig
    */
    void list(){
        
    }
}
