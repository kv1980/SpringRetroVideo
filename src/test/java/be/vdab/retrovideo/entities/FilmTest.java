package be.vdab.retrovideo.entities;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class FilmTest {
	private Film film;
	
	@Before
	public void before() {
		film = new Film(1L,1L,"Titel testfilm",10,BigDecimal.TEN);
		film.setGereserveerd(1);
	}
	
	@Test
	public void geefCorrecteAantallenNaReservatie() {
		assertEquals(10,film.getVoorraad());
		assertEquals(1,film.getGereserveerd());
		assertEquals(9,film.toonBeschikbareExemplaren());
	}
	
	@Test
	public void geefCorrecteGegevens() {
		assertEquals(1L,film.getId());
		assertEquals(1L,film.getGenreId());
		assertEquals("Titel testfilm",film.getTitel());
		assertEquals(BigDecimal.TEN,film.getPrijs());
	}
}
