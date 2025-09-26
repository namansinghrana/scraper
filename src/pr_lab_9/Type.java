/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;
import java.util.Random;
/**
 *
 * @author student
 */
public class Type {
    int tomato = 0;
    int cucumber = 1;
    int onion = 2;
    String names[] = {"tomato", "cucumber", "onion"};
    Random generator = new Random();
    int typeCount = 3;
    public int randomType() {
        return generator.nextInt(typeCount);
    }
}
