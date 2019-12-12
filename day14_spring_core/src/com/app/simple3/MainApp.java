package com.app.simple3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("beans3.xml");

      TextEditor te1 = (TextEditor) context.getBean("textEditor");
     // TextEditor te2 = (TextEditor) context.getBean("textEditor");
      //TextEditor te3 = (TextEditor) context.getBean("textEditor");

      System.out.println(te1.getSpellChecker());
      System.out.println(te1.getSpellChecker2());
      System.out.println(te1.getSpellChecker3());
     
      
      //te1.spellCheck();
   }
}