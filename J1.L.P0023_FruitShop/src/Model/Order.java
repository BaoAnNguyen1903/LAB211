/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84945
 */
public class Order {
    private List<OrderItem> items;
    private String customer;

    public Order() {
        items = new ArrayList<>();
    }

    public Order(List<OrderItem> items, String customer) {
        this.items = items;
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public void addItem(OrderItem item) {
        items.add(item);
    }
    
    public double getTotalAmount(){
        double total = 0;
        for(OrderItem item : items){
            total += item.getAmount();
        }
        return total;
    }

}
