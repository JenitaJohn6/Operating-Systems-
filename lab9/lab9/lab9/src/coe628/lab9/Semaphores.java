/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe628.lab9;

/**
 *
 * @author jjmar
 */
public class Semaphores {
    
        private int value;

    /**
     * Create a semaphore.
     * @param value The initial value of the Semaphore ( must be &ge; 0).
     */
    public Semaphores(int value) {
        this.value = value;
    }
    /**
     * Increment the number of available resources.  This method never blocks.
     * It may wakeup a Thread waiting for the Semaphore. 
     */
    public synchronized void up()throws InterruptedException{
        
       this.value++;                      //Increment the number of resources 
        if(this.value == 0){               // if the value is zero, there may be something waiting 
            notify();
        }
        
    }
    
    /**
     * Request a resource. If no resources are available, the calling Thread
     * block until a resource controlled by the Semaphore becomes available.
     */
    public synchronized void down() throws InterruptedException{
        
        this.value--;                   // decrement the number of resources
        if(this.value < 0){             // if negative wait
            wait();
        }         
    }
    
    public synchronized int getvalue(){
        return value;
    }
    
}
