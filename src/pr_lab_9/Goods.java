/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;

/**
 *
 * @author student
 */
public class Goods {
    int quantity;
    int number;
    public Goods(int index) {
        this.quantity = 0;
        this.number = index;
    }
    public int increase(int amount) {
        quantity = quantity + amount;
        return this.quantity;
    }
    public int decrease(int amount) {
        quantity = quantity - amount;
        return this.quantity;
    }
}
