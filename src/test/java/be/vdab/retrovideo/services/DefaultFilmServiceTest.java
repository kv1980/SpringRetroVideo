package be.vdab.retrovideo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.repositories.FilmRepository;

public class DefaultFilmServiceTest {
	private DefaultFilmService service;
	@Mock 
	private FilmRepository dummyFilmRepository;
	private List<Film> filmLijst = Arrays.asList(

			);
	
	@Before
	public void before() {
		when(dummyFilmRepository.findFilmsByGenreId(1L)).thenReturn(filmLijst);
		service = new DefaultFilmService(dummyFilmRepository);
	}
	
	@Test
	public void serviceVindtDeLijstMetSauzen() {
		assertEquals(sauzenLijst,service.findAll());
		verify(dummySausRepository).findAll();
	}
}
