/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

/**
 *
 * @author KylePackard
 */
public class InsufficientStockException extends Exception {
  
        public InsufficientStockException(String message) {
        super(message);
    }

    public InsufficientStockException(String message,
            Throwable cause) {
        super(message, cause);
    }
        
}
