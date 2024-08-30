package com.calculator.demo.controller;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

      private String store_num1 = "";
      private String store_num2 = "";
      private String opt = ""; //STORES OPERATOR
      private String res1 = "";
      private String res2 ="";
      private String res = "";
      private String a = "hello";
     
   @RequestMapping("/home")
    public ModelAndView calculate(String del, String operator, String dot, String number) {
         double num1 = 0;
         double num2 = 0;
         double result = 0;

         ModelAndView mv = new ModelAndView();
         mv.setViewName("index.jsp");
        
         System.out.println("GH: "+dot);
         if(operator == null) {
              if(number != null) {
                   if(opt == "") {
                           store_num1 += number;
                           res1 = ""+store_num1;
                       }
                 }
           }
         else {
               if(opt == "") {
                    opt += operator;
               }
          }
   
         /* -- OPERATOR FUNCTIONALITY -- */
         if(opt != "") {
               if(number != null) {
                     store_num2 += number;
                     res2 = ""+store_num2;
               }
                switch(opt) {
                     case "+":
                        if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             result = num1 + num2;
                        }
                        break;
                     case "-":
                        if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             result = num1 - num2;
                        }
                        break;
                      case "*":
                         if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             result = num1 * num2;
                        }
                         break;
                       case "/":
                         if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             result = num1 / num2;
                        }
                       break;
                      case "%":
                         if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             result = num1 % num2;
                        }
                       break;
                      case "C":
                          store_num1 = "";
                          store_num2 = "";
                          opt = "";
                          res = "";
                          res1 = "";
                          res2 = "";
                       break;
                  }
             }
             res = res1 + ""+ opt + "" + res2;
             if(operator != null) {
             if(operator == "e'" || operator.equals("e")) {
                   System.out.println(result);
                   store_num1 = ""+result;
                   store_num2 = "";
                   opt = "";
                   res = ""+result;
                   res1 = ""+result;
                   res2 = "";
             }
            }

           if(dot != null) {
                if(dot == "d" || dot.equals("d")) {
                     if(opt == "") {
                         if(!store_num1.contains(".")) {
                              store_num1 += ".";
                          }
                      }
                     else {
                            if(!store_num2.contains(".")) {
                               store_num2 += ".";
                            }
                       }
                  }
            }
     
          if(del != null) {
             if(store_num1 != "" && opt == "") {    
                     String str = delete(store_num1);      
                     store_num1 = str;
                     res1 = store_num1;
                     res = res1 + "" + opt + "" + res2;
                     mv.addObject("value",res);
            }
           if(opt != "")   {
               if(store_num2 != "") {
                    String str = delete(store_num2);
                    store_num2 = str;
                    res2 = store_num2;
                    res = res1 + "" + opt + "" + res2;
                    mv.addObject("value",res);
                } else {
                     opt = "";
                     res = res1 + "" + res2;
                     mv.addObject("value",res);
                  }
               }
          }
    
         mv.addObject("value",res);
         System.out.println(store_num1 +" , "+ store_num2);
         return mv;
     }

    public String delete(String str) {
         StringBuilder sb = new StringBuilder(str);
         int index = sb.toString().length() - 1;
         sb.deleteCharAt(index);
         return sb.toString();
    }
}