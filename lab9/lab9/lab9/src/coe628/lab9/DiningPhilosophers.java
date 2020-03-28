/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe628.lab9;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenita john
 */

public class DiningPhilosophers extends Thread{
    
    int n;
    fork leftfork;
    fork rightfork; 
    static int completed = 0;
    
    public DiningPhilosophers(int num, fork left, fork right){
        n = num ;
        leftfork = left;
        rightfork = right;       
    }
    
    @Override
    public void run(){
        
        while(true){
            
          // think
           think();
            leftfork.get_fork(n+1); 
            System.out.println(" Fork "+ leftfork.getId() + " taken by Philosopher " + (n+1) );    
            rightfork.get_fork(n+1);
            System.out.println(" Fork "+ rightfork.getId() + " taken by Philosopher " + (n+1) );    
            eat();
            System.out.println(" Philosopher " + (n+1) + " completed his dinner" );    
              System.out.println(" Philosopher " + (n+1) + " released fork " + leftfork.getId());  
            leftfork.put_fork(n+1);
             System.out.println(" Philosopher " + (n+1) + " released fork " +  rightfork.getId());  
            rightfork.put_fork(n+1);
            completed++;
            System.out.println("Till now num of philosophers completed dinner are " + completed ); 
            if(completed == 5){
                System.exit(0);
            }
             think();
        }
    }
    
    
    void think(){
     int sleepTime = ThreadLocalRandom.current().nextInt(0,1000);
        try {
        //System.out.println(" Philosopher " + (n+1) + " is thinking" );  
            Thread.sleep(sleepTime);            
        } catch (InterruptedException ex) {
           ex.printStackTrace(System.out);
        }
    }
    void eat(){
        int sleepTime = ThreadLocalRandom.current().nextInt(0,1000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
  
   
}
