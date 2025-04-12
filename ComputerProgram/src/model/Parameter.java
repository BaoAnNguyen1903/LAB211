/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author OS
 */
public class Parameter {

    private String operator;
    private double memory;

    public Parameter() {
    }

    public Parameter(String operator, double memory) {
        this.operator = operator;
        this.memory = memory;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "parameter{" + "memory=" + memory + '}';
    }  
}