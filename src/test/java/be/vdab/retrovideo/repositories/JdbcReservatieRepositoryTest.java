package be.vdab.retrovideo.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.retrovideo.valueobjects.Reservatie;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcReservatieRepository.class)
public class JdbcReservatieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final String RESERVATIES = "reservaties";

	@Autowired
	private JdbcReservatieRepository repository;

	@Test
	public void create_heeft_reservatie_toegevoegd() {
		Reservatie reservatie = new Reservatie(1, 1);
		int aantalReservaties = super.countRowsInTable(RESERVATIES);
		repository.create(reservatie);
		assertEquals(aantalReservaties + 1, super.countRowsInTable(RESERVATIES));
		assertEquals(1, super.countRowsInTableWhere(RESERVATIES, "klantid =" + reservatie.getKlantId() + " AND filmid="
				+ reservatie.getFilmId() + " AND year(reservatieDatum)=" + reservatie.getReservatietijd().getYear()));
	}
}