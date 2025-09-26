/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Producer extends Thread {
    Warehouse warehouse;
    int producerNumber;
    Type type = new Type();
    int MAX_PRODUCER = 199;
    Random generator = new Random();

    public Producer(Warehouse warehouse, int number) {
        this.warehouse = warehouse;
        this.producerNumber = number;
    }

    public void run() {
        int counter = 0;
        int index = 0;
        int quantity = 0;
        int waitCount = 0;
        while (true) {
            if (quantity == 0) {
                index = type.randomType();
                quantity = generator.nextInt(MAX_PRODUCER) + 1;
                System.out.println("Producer number " + producerNumber + " produced " + quantity + " " + type.names[index]);
                quantity = quantity - warehouse.add(index, quantity);
                System.out.println("Producer number " + producerNumber + " has " + quantity + " left to deliver");
            } else {
                quantity = quantity - warehouse.add(index, quantity);
                System.out.println("Producer number " + producerNumber + " has " + quantity + " left to deliver");
                waitCount++;
            }
            if (quantity == 0) {
                System.out.println("Producer number " + producerNumber + " delivered the entire order");
                waitCount = 0;
            }
            if (waitCount == 3) {
                System.out.println("Producer number " + producerNumber + " did not manage to deliver the entire order in time");
                waitCount = 0;
                quantity = 0;
            }
            counter++;
            if (counter == 5) {
                warehouse.display();
                counter = 0;
            }
             try {
                sleep(generator.nextInt(500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
