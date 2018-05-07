package be.vdab.retrovideo.repositories;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
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

import be.vdab.retrovideo.valueobjects.DatumTijd;
import be.vdab.retrovideo.valueobjects.Reservatie;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcReservatieRepository.class)
@Sql("/insertReservatie.sql")
public class JdbcReservatieRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
	private static final String RESERVATIES = "reservaties";
	
	@Autowired
	private JdbcReservatieRepository repository;
	
	@Test
	public void create_heeft_reservatie_toegevoegd() {
		DatumTijd tijdstip = new DatumTijd(LocalDateTime.now());
		Reservatie reservatie = new Reservatie(1,1,tijdstip);
		int aantalReservaties = super.countRowsInTable(RESERVATIES);
		repository.create(reservatie);
		assertEquals(aantalReservaties+1,super.countRowsInTable(RESERVATIES));
		assertEquals(1,super.countRowsInTableWhere(RESERVATIES,"klantid ="+reservatie.getKlantId()+" AND filmid="+reservatie.getFilmId()+" AND reservatieDatum='"+reservatie.getReservatietijd().toString()+"'"));
	}
	
	@Test
	public void readBestaandeReservatie() {
		DatumTijd tijdstip = new DatumTijd("2001-02-03 04:05:06");
		Reservatie reservatie = new Reservatie(1L,1L,tijdstip);
		assertTrue(repository.read(reservatie).isPresent());
	}
	
	@Test
	public void readOnbestaandeReservatieNiet() {
		Reservatie reservatie = new Reservatie(-1L,-1L,new DatumTijd("2001-02-03 04:05:06"));
		assertFalse(repository.read(reservatie).isPresent());
	}
	
	
}