package be.vdab.retrovideo.repositories;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.valueobjects.Reservatie;

@Repository
class JdbcReservatieRepository implements ReservatieRepository {
	private final SimpleJdbcInsert insert;

	JdbcReservatieRepository(DataSource dataSource) {
		this.insert = new SimpleJdbcInsert(dataSource);
		insert.withTableName("reservaties");
	}

	@Override
	public void create(Reservatie reservatie) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("klantid", reservatie.getKlantId());
		kolomWaarden.put("filmid", reservatie.getFilmId());
		kolomWaarden.put("reservatieDatum", reservatie.getReservatietijd());
		insert.execute(kolomWaarden);
	}
}