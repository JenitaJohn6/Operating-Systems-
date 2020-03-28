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
public class Main {
    
    static int philosopher = 5;
    static DiningPhilosophers philosophers[] = new DiningPhilosophers[philosopher];
    static fork forks[] =  new fork[philosopher];
    
    public static void main (String argv[]){
        
        // creates five forks 
        for(int i = 0; i < philosopher; i++){
            forks[i] = new fork(i);
        }
        
        //creates five philosophers 
        for(int i = 0; i < (philosopher-1); i++){
            fork leftfork = forks[i];
            fork rightfork = forks[(i+1)%5];
           
                philosophers[i] = new DiningPhilosophers(i,rightfork,leftfork);
            } 
        
        philosophers[(philosopher-1)] = new DiningPhilosophers((philosopher-1),forks[0],forks[(philosopher-1)]);
            
            for (int p = 0; p < philosopher; p++){
            Thread t = new Thread(philosophers[p]);
            t.start();
            }
        
        while(true){
            try {
                Thread.sleep(1000);  // sleep 1 sec
                
                boolean deadlock = true; // check for deadlock
                for(fork f : forks){
                    if (f.isFree()){
                        deadlock = false;
                        break;
                    }
                }
                
                if(deadlock){
                    Thread.sleep(1000);
                    System.out.println("Deadlock");
                    break;
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Exit the program!");
        System.exit(0);
    }
}
