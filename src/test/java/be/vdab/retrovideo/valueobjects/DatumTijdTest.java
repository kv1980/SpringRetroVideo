package be.vdab.retrovideo.valueobjects;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class DatumTijdTest {
	private LocalDateTime tijdstip;
	private String tijdstipString;
	private DatumTijd datumTijdType1;
	private DatumTijd datumTijdType2;
	
	
	@Before
	public void before() {
		tijdstip = LocalDateTime.of(2001, 2, 3, 4, 5, 6);
		tijdstipString = "2001-02-03 04:05:06";
		datumTijdType1 = new DatumTijd(tijdstip);
		datumTijdType2 = new DatumTijd(tijdstipString);
	}
	
	@Test
	public void getWaarde_geeft_correcte_LocalDateTime_terug_na_ingave_datumTijd_als_LocalDateTime() {
		assertEquals(tijdstip,datumTijdType1.getWaarde());
	}
	
	@Test
	public void getWaarde_geeft_correcte_LocalDateTime_terug_na_ingave_datumTijd_als_String() {
		assertEquals(tijdstip,datumTijdType2.getWaarde());
	}
	
	@Test
	public void toString_geeft_correcte_String_terug_na_ingave_datumTijd_als_LocalDateTime() {
		assertEquals(tijdstipString,datumTijdType1.toString());
	}
	
	@Test
	public void toString_geeft_correcte_String_terug_na_ingave_datumTijd_als_String() {
		assertEquals(tijdstipString,datumTijdType2.toString());
	}
}
