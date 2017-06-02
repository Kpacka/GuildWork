/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dto;

/**
 *
 * @author jenniferbliss
 */
public class CoinReturn {

    private int dollars = 0;
    private int Quarters = 0;
    private int dimes = 0;
    private int nickels = 0;
    private int pennies = 0;

    public void addQuarter() {
        
        Quarters++;

    }

    public void addDollar() {
        dollars++;
    }

    public void addDime() {
        dimes++;
    }

    public void addNickel() {
        nickels++;
    }

    public void addPennie() {
        pennies++;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getQuarters() {
        return Quarters;
    }

    public void setQuarters(int Quarters) {
        this.Quarters = Quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

}
