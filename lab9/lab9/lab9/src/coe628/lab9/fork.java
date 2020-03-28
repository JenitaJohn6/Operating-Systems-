/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe628.lab9;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jjmar
 */
public class fork {
    
     Semaphores p = new Semaphores(1);
     int id; 
    
     public fork(int id){
         this.id = id;
     }
     
     int getId(){
         return (id+1);
     }
     
    // Everytime a philosopher grabs a fork the semaphore ready gets decremented, indicating that a resource is used 
    
        void get_fork(int i){
        try {
            p.down(); 
        } catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
        }
         }
    // Every time a philosopher puts his fork back, the sempahore is incremented, indicating that a resource is now available. 
        
        void put_fork(int i){
         try {
             p.up();  
         } catch (InterruptedException ex) {
             Logger.getLogger(fork.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        
        boolean isFree(){
            return p.getvalue()> 0;
        }
    
    
}
