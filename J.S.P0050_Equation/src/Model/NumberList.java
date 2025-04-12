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
public class NumberList {
    private float numA;
    private float numB;
    private float numC;

    public NumberList() {
    }

    public NumberList(float numA, float numB, float numC) {
        this.numA = numA;
        this.numB = numB;
        this.numC = numC;
    }

    public float getNumA() {
        return numA;
    }

    public void setNumA(float numA) {
        this.numA = numA;
    }

    public float getNumB() {
        return numB;
    }

    public void setNumB(float numB) {
        this.numB = numB;
    }

    public float getNumC() {
        return numC;
    }

    public void setNumC(float numC) {
        this.numC = numC;
    }
    
    
}
