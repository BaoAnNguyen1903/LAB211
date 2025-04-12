/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author os
 */
public class Expense {
    private int ExpenseID;
    private String date;
    private int money;
    private String contentString;

    public Expense() {
    }

    public Expense(int ExpenseID, String date, int money, String contentString) {
        this.ExpenseID = ExpenseID;
        this.date = date;
        this.money = money;
        this.contentString = contentString;
    }

    public int getExpenseID() {
        return ExpenseID;
    }

    public void setExpenseID(int ExpenseID) {
        this.ExpenseID = ExpenseID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getContentString() {
        return contentString;
    }

    public void setContentString(String contentString) {
        this.contentString = contentString;
    }

    @Override
    public String toString() {
        return "Expense{" + "ExpenseID=" + ExpenseID + ", date=" + date + ", money=" + money + ", contentString=" + contentString + '}';
    }
    
}