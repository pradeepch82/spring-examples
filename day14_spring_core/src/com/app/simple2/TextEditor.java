package com.app.simple2;

public class TextEditor {
	private SpellChecker adv;

	/*
	 * public TextEditor(BasicSpellChecker spellChecker123) {
	 * System.out.println("Inside TextEditor constructor." ); this.spellChecker
	 * = spellChecker123; }
	 */
	public TextEditor() {
		System.out.println("in text editor constr.");
	}

	
	
	public SpellChecker getAdv() {
		return adv;
	}



	public void setAdv(SpellChecker adv) {
		this.adv = adv;
	}



	public void spellCheck() {
		adv.checkSpelling();
	}
}