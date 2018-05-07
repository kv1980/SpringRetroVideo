package be.vdab.retrovideo.repositories;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.exceptions.FilmNotFoundException;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcFilmRepository.class)
@Sql("/insertFilms.sql")
public class JdbcFilmRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private JdbcFilmRepository repository;

	@Test
	public void update_bestaande_film() {
		Film film = new Film(idVanTestFilmA(), "Titel van testfilm A", 1, 0, BigDecimal.ONE);
		repository.update(film);
		;
		assertTrue(0 == super.jdbcTemplate.queryForObject("select gereserveerd from films where id=?", Integer.class,
				idVanTestFilmA()));
	}

	@Test(expected = FilmNotFoundException.class)
	public void update_onbestaande_film_niet() {
		Film film = new Film(-1, "Titel van testfilm A", 1, 0, BigDecimal.ONE);
		repository.update(film);
	}

	@Test
	public void findFilmsByGenreId_vindt_juiste_films() {
		List<Film> films = repository.findFilmsByGenreId(1L);
		int indexA = -1;
		for (Film film : films) {
			if (film.getTitel().equals("Titel van testfilm A")) {
				indexA = films.indexOf(film);
			}
		}
		assertFalse(indexA == -1);
	}

	@Test
	public void findFilmsByGenreId_vindt_foutieve_films_niet() {
		List<Film> films = repository.findFilmsByGenreId(1L);
		int indexC = -1;
		for (Film film : films) {
			if (film.getTitel().equals("Titel van testfilm C")) {
				indexC = films.indexOf(film);
			}
		}
		assertTrue(indexC == -1);
	}

	@Test
	public void findFilmsByGenreId_ordent_films_zoals_gevraagd() {
		List<Film> films = repository.findFilmsByGenreId(1L);
		int indexA = -1;
		int indexB = -1;
		for (Film film : films) {
			switch (film.getTitel()) {
			case "Titel van testfilm A":
				indexA = films.indexOf(film);
				break;
			case "Titel van testfilm B":
				indexB = films.indexOf(film);
				break;
			}
		}
		assertTrue(indexA < indexB);
	}

	@Test
	public void findFilmById_vindt_de_juiste_film() {
		Film film = repository.findFilmById(idVanTestFilmA());
		assertTrue(film.getId() == idVanTestFilmA());
		assertEquals(film.getTitel(), "Titel van testfilm A");
		assertTrue(film.getVoorraad() == 1);
		assertTrue(film.getGereserveerd() == 1);
		assertEquals(0, film.getPrijs().compareTo(BigDecimal.ONE));
	}

	private long idVanTestFilmA() {
		return super.jdbcTemplate.queryForObject("select id from films where titel='Titel van testfilm A'", Long.class);
	}
}