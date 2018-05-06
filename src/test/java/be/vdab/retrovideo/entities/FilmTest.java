package be.vdab.retrovideo.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class FilmTest {
	private Film film;
	
	@Before
	public void before() {
		film = new Film(1L,"Titel testfilm",10,9,BigDecimal.TEN);
	}
	
	@Test
	public void toonBeschikbareExemplaren_geeft_het_correcte_aantal_beschikbare_exemplaren() {
		assertEquals(1,film.toonBeschikbareExemplaren());
	}
	
	@Test
	public void na_reservatie_is_het_aantal_gereserveerde_exemplaren_met_1_verhoogd() {
		film.reserveer();
		assertEquals(10,film.getGereserveerd());
	}
	
	@Test
	public void isBeschikbaar_geeft_true_als_er_nog_beschikbare_exemplaren_zijn() {
		assertTrue(film.isBeschikbaar());
	}
	
	@Test
	public void isBeschikbaar_geeft_false_als_er_geen_beschikbare_exemplaren_meer_zijn() {
		film.reserveer();
		assertFalse(film.isBeschikbaar());
	}	
}
