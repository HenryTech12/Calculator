package com.calculator.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

     public double add(double num1, double num2) {
         return num1 + num2;
     }

    public double subtract(double num1, double num2) {
        return num1 - num2;
   }

    public double divide (double num1, double num2) {
       return num1 / num2;
    }

  public double multiply(double num1, double num2) {
      return num1 * num2;
  }
  public double getMod(double num1, double num2) {
       return num1 % num2;
   }
  public String delete(String str) {
         StringBuilder sb = new StringBuilder(str);
         int index = sb.toString().length() - 1;
         sb.deleteCharAt(index);
         return sb.toString();
    }
}