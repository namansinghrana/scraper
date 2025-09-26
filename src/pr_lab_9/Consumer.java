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
public class Consumer extends Thread {
    Warehouse warehouse;
    Type type;
    int MAX_CONSUMER = 50;
    int consumerNumber;
    Random generator = new Random();

    public Consumer(Warehouse warehouse, int number) {
        this.consumerNumber = number;
        this.warehouse = warehouse;
        type = new Type();
    }

    public void run() {
        int index = 0;
        int quantity = 0;
        int waitCount = 0;
        while (true) {
            if (quantity == 0) {
                index = type.randomType();
                quantity = generator.nextInt(MAX_CONSUMER) + 1;
                System.out.println("Consumer number " + consumerNumber + " placed an order for " + type.names[index]);
                quantity = quantity - warehouse.take(index, quantity);
                System.out.println("Consumer number " + consumerNumber + " has " + quantity + " left to collect");
            } else {
                quantity = quantity - warehouse.take(index, quantity);
                System.out.println("Consumer number " + consumerNumber + " has " + quantity + " left to collect");
                waitCount++;
            }
            if (quantity == 0) {
                System.out.println("Consumer number " + consumerNumber + " collected the entire order");
                waitCount = 0;
            }
            if (waitCount == 3) {
                System.out.println("Consumer number " + consumerNumber + " did not manage to collect the entire order in time");
                waitCount = 0;
                quantity = 0;
            }
            try {
                sleep(generator.nextInt(500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
