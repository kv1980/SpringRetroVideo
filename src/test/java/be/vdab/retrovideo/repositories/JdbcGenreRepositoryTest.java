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

import be.vdab.retrovideo.entities.Genre;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcGenreRepository.class)
@Sql("/insertGenres.sql")
public class JdbcGenreRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final String GENRES = "genres";
	@Autowired
	private JdbcGenreRepository repository;
	
	@Test 
	public void find_all_genres_geordend_op_naam() {
		List<Genre> genres = repository.findAll();
		assertEquals(super.countRowsInTable(GENRES),genres.size());
		int indexA = -1;
		int indexB = -1;
		for (Genre genre : genres) {
			if(genre.getNaam().equals("testgenre A")) {
				indexA = genres.indexOf(genre);
			}
			if(genre.getNaam().equals("testgenre B")) {
				indexB = genres.indexOf(genre);
			}
		}
		assertFalse(indexA==-1);
		assertFalse(indexB==-1);
		assertTrue(indexA<indexB);		
	}
}
