package be.vdab.retrovideo.web;

import javax.validation.constraints.NotEmpty;

public class KlantForm {
	@NotEmpty
	private String letters;

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}	
}