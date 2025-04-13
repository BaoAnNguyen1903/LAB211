/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author 84945
 */
public class SalaryHistory {
    private String wCode;
    private double oldSalary;
    private double newSalary;
    private String date;

    public SalaryHistory() {
    }

    public SalaryHistory(String wCode, double oldSalary, double newSalary, String date) {
        this.wCode = wCode;
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        this.date = date;
    }

    public String getwCode() {
        return wCode;
    }

    public void setwCode(String wCode) {
        this.wCode = wCode;
    }

    public double getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(double oldSalary) {
        this.oldSalary = oldSalary;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
}
