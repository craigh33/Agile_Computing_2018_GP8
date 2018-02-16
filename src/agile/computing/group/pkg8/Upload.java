/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;

/**
 *
 * @author vincentnieutin
 */
public class Upload {
    String[] supportedFormats = {"xls","xlsx"};
    
    public boolean uploadFile(File uploadPath, File file){
        boolean uploaded = false;
        
        if(!fileExists(uploadPath,file) && fileIsSupported(file.getName())){
            uploaded = true;
        }
        
        return uploaded;
    }
    
    public boolean fileExists(File path, File file){
        boolean exists = false;
        for(File f: path.listFiles()){
            if(f.getName().equals(file.getName())){
                exists = true;
                break;
            }
        }
        return exists;
    }
    
    public boolean fileIsSupported(String filename){
        boolean supported = false;
        String format = filename.split("\\.")[1];
        for(String s: supportedFormats){
            if(s.equals(format)){
                supported = true;
                break;
            }
        }
        
        return supported;
    }
}
