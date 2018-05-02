package be.vdab.retrovideo.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import be.vdab.retrovideo.entities.Genre;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JDBCGenreRepository.class)
@Sql("/insertGenre.sql")
public class JDBCGenreRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final String GENRES = "genres";
	@Autowired
	private JDBCGenreRepository repository;
	
	@Test 
	public void vindAlleGenresGesorteerdOpNaam() {
		List<Genre> genres = repository.findAll();
		assertEquals(super.countRowsInTable(GENRES),genres.size());
		int indexA = 0;
		int indexB = 0;
		for (Genre genre : genres) {
			if(genre.getNaam().equals("testgenre A")) {
				indexA = genres.indexOf(genre);
			}
			if(genre.getNaam().equals("testgenre B")) {
				indexB = genres.indexOf(genre);
			}
		}
		assertTrue(indexA<indexB);		
	}
}
