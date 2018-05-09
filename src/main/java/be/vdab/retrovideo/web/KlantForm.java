package be.vdab.retrovideo.web;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.SafeHtml;

public class KlantForm {
	@NotEmpty
	@SafeHtml
	private String letters;

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}
}