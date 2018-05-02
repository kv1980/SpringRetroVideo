package be.vdab.retrovideo.entities;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class FilmTest {
	private Film film;
	
	@Before
	public void before() {
		film = new Film(1L,"Titel testfilm",10,1,BigDecimal.TEN);
		film.verhoogAantalGereserveerdMetEen();
	}
	
	@Test
	public void geefCorrecteAantallenNaReservatie() {
		assertEquals(10,film.getVoorraad());
		assertEquals(2,film.getGereserveerd());
		assertEquals(8,film.toonBeschikbareExemplaren());
	}
	
	@Test
	public void geefCorrecteGegevens() {
		assertEquals(1L,film.getId());
		assertEquals("Titel testfilm",film.getTitel());
		assertEquals(BigDecimal.TEN,film.getPrijs());
	}
}
