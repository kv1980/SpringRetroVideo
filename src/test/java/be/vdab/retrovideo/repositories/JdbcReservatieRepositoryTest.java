package be.vdab.retrovideo.repositories;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

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
public class JdbcReservatieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
	private static final String RESERVATIES = "reservaties";
	
	@Autowired
	private JdbcReservatieRepository repository;
	
	@Test
	public void create_heeft_reservatie_toegevoegd() {
		int aantalReservaties = super.countRowsInTable(RESERVATIES);
		LocalDateTime tijdstip = LocalDateTime.of(2018, 5, 7, 8, 15, 0);
		String tijdstiptekst = "2018-05-06 08:15:00";
		Reservatie reservatie = new Reservatie(1,1,tijdstip);
		repository.create(reservatie);
		assertEquals(aantalReservaties+1,super.countRowsInTable(RESERVATIES));
		assertEquals(1,super.countRowsInTableWhere(RESERVATIES, "klantid="+reservatie.getKlantId()+" AND filmid="+reservatie.getFilmId()+" AND reservatieDatum="+tijdstiptekst));
	}
}