package com.app.simple3;

public class TextEditor {
   private BasicSpellChecker spellChecker;
   private BasicSpellChecker spellChecker2;
   private BasicSpellChecker spellChecker3;
   
   
   public TextEditor() {
System.out.println("TextEditor created....");
   }
   
   public TextEditor(BasicSpellChecker spellChecker123) {
      System.out.println("Inside TextEditor constructor." );
      this.spellChecker = spellChecker123;
   }
   
  
  public BasicSpellChecker getSpellChecker() {
	return spellChecker;
} 
   
   public BasicSpellChecker getSpellChecker2() {
	return spellChecker2;
}




public void setSpellChecker2(BasicSpellChecker spellChecker2) {
	this.spellChecker2 = spellChecker2;
}




public BasicSpellChecker getSpellChecker3() {
	return spellChecker3;
}




public void setSpellChecker3(BasicSpellChecker spellChecker3) {
	this.spellChecker3 = spellChecker3;
}


public void setSpellChecker(BasicSpellChecker spellChecker) {
	this.spellChecker = spellChecker;
}



public void spellCheck() {
      spellChecker.checkSpelling();
   }
}