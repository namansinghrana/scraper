/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;
//import pr_lab_9.Magazyn;

/**
 *
 * @author student
 */
public class Lab9 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int NUM_PRODUCERS = 3;
    int NUM_CONSUMERS = 10;
    Warehouse warehouse = new Warehouse();
    Producer producers[] = new Producer[NUM_PRODUCERS];
    Consumer consumers[] = new Consumer[NUM_CONSUMERS];
    for (int i = 0; i < NUM_PRODUCERS; i++) {
      producers[i] = new Producer(warehouse, i + 1);
      producers[i].start();
    }
    for (int i = 0; i < NUM_CONSUMERS; i++) {
      consumers[i] = new Consumer(warehouse, (i + 1));
      consumers[i].start();
    }
    /* for (int i = 0; i < NUM_PRODUCERS; i++) {
      try {
        producers[i].join();
      } catch (InterruptedException e) {
        System.out.println("Main thread Interrupted");
      }
    }
    for (int i = 0; i < NUM_CONSUMERS; i++) {
      try {
        consumers[i].join();
      } catch (InterruptedException e) {
        System.out.println("Main thread Interrupted");
      }
    }*/
    try {
      Thread.sleep(5000);
    } catch (InterruptedException ex) {
      //Logger.getLogger(Lab9_rozpr.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
