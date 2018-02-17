/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import javax.swing.TransferHandler;

/**
 *
 * @author craig
 */
public class GUI {
    
    JFrame login = new JFrame();
    JFrame main = new JFrame();
    JFrame edit = new JFrame();
    
    void loginScreen() {
       
       JButton b = new JButton("login");//Creates new Button
       b.setBounds(130,100,100,40);//Sets size of button
       
       login.add(b);//Adds button to Frame
       
       login.setSize(400,500);//size of frame
       login.setLayout(null);//no layout manager
       login.setVisible(true);//makes it visible
       
       b.setMnemonic(KeyEvent.VK_A);
      b.setTransferHandler(new TransferHandler("text"));
      b.addActionListener((ActionEvent event) -> 
        {
            login.setVisible(false);//makes it visible
            mainScreen();
        }
        );
       }
    
     /*
    * @param 
    *
    * @return 
    *
    * @authot Craig
    */
    void mainScreen(){
      main.setSize(400,500);//size of frame
      main.setLayout(null);//no layout manager
      main.setVisible(true);//makes it visible
      
      JButton b = new JButton("Edit");//Creates new Button
      main.add(b);
      
      b.setBounds(130,100,100,40);//Sets size of button
      b.setMnemonic(KeyEvent.VK_A);
      b.setTransferHandler(new TransferHandler("text"));
      b.addActionListener((ActionEvent event) -> 
        {
            main.setVisible(false);//makes it visible
            editScreen();
        }
        );
    }
    
    /**
     * 
     */
    void editScreen(){
        edit.setSize(400,500);//size of frame
        edit.setLayout(null);//no layout manager
        edit.setVisible(true);//makes it visible
        
    }
}
