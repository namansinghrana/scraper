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
public class Warehouse {

    int SHELF_CAPACITY = 600;
    Goods goods[];
    Type types;

    public Warehouse() {
        types = new Type();
        goods = new Goods[types.typeCount];
        for (int i = 0; i < types.typeCount; i++) {
            goods[i] = new Goods(i);
        }
    }

    // returns how many items were taken
    public synchronized int take(int index, int amount) {
        if (amount <= goods[index].quantity) {
            goods[index].decrease(amount);
            return amount;
        } else {
            int available = goods[index].quantity;
            goods[index].decrease(available);
            return available;
        }
    }

    // returns how many items were added
    public synchronized int add(int index, int amount) {
        int available = goods[index].quantity;
        int canAdd = SHELF_CAPACITY - available;
        if (canAdd >= amount) {
            goods[index].increase(amount);
            return amount;
        } else {
            goods[index].increase(canAdd);
            return canAdd;
        }
    }

    public synchronized void display() {
        System.out.println("Warehouse contents:");
        for (int i = 0; i < types.typeCount; i++) {
            System.out.println("Shelf: " + types.names[goods[i].number] + " has quantity: " + goods[i].quantity);
        }
    }
}
