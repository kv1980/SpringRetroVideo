package be.vdab.retrovideo.repositories;

import static org.junit.Assert.*;

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

import be.vdab.retrovideo.entities.Klant;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcKlantRepository.class)
@Sql("/insertKlanten.sql")
public class JdbcKlantRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private JdbcKlantRepository repository;

	@Test
	public void findKlantenByLetters_vindt_juiste_klanten() {
		List<Klant> klanten = repository.findKlantenByLetters("test1");
		for (Klant klant : klanten) {
			assertTrue(klant.getFamilienaam().toLowerCase().contains("test1"));
		}
	}

	@Test
	public void findKlantenByLetters_vindt_onjuiste_klanten_niet() {
		List<Klant> klanten = repository.findKlantenByLetters("test1");
		for (Klant klant : klanten) {
			assertFalse(klant.getFamilienaam().toLowerCase().contains("test2"));
		}
	}

	@Test
	public void findKlantenByLetters_ordent_klanten_zoals_gevraagd() {
		List<Klant> klanten = repository.findKlantenByLetters("test1");
		int indexA = -1;
		int indexB = -1;
		for (Klant klant : klanten) {
			switch (klant.getFamilienaam()) {
			case "Test1familienaamA":
				indexA = klanten.indexOf(klant);
				break;
			case "Test1familienaamB":
				indexB = klanten.indexOf(klant);
				break;
			}
		}
		assertTrue(indexA != -1);
		assertTrue(indexB != -1);
		assertTrue(indexA < indexB);
	}

	@Test
	public void findKlantById_vindt_de_juiste_klant() {
		Klant klant = repository.findKlantById(idVanC());
		assertEquals(klant.getFamilienaam(), "Test2familienaam");
	}

	private long idVanC() {
		return super.jdbcTemplate.queryForObject("select id from klanten where familienaam='Test2familienaam'",
				Long.class);
	}
}