package be.vdab.retrovideo.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.valueobjects.Reservatie;

@Repository
class JdbcReservatieRepository implements ReservatieRepository {
	private final NamedParameterJdbcTemplate template;
	private final SimpleJdbcInsert insert;
	private static final String READ = "select klantId, filmId, reservatieTijd where klantId=:klantId AND filmId=:filmId AND reservatieTijd=:reservatietijd";
	private final RowMapper<Reservatie> reservatieRowMapper = (resultSet,rowNum) -> 
		new Reservatie(resultSet.getLong("klantId"),resultSet.getLong("filmId"),resultSet.getTimestamp("reservatieTijd").toLocalDateTime());
	
	
	JdbcReservatieRepository(NamedParameterJdbcTemplate template, DataSource dataSource){
		this.template = template;
		this.insert = new SimpleJdbcInsert(dataSource);
		insert.withTableName("reservaties");
	}

	@Override
	public void create(Reservatie reservatie) {
		Map<String,Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("klantid",reservatie.getKlantId());
		kolomWaarden.put("filmid",reservatie.getFilmId());
		kolomWaarden.put("reservatieDatum",reservatie.getReservatietijd());
		insert.execute(kolomWaarden);
	}

	@Override
	public Optional<Reservatie> read(Reservatie reservatie) {
		try {
			Map<String,Object> parameters = new HashMap<>();
			parameters.put("klantid",reservatie.getKlantId());
			parameters.put("filmid",reservatie.getFilmId());
			parameters.put("reservatieDatum",reservatie.getReservatietijd());
			return Optional.of(template.queryForObject(READ,parameters,reservatieRowMapper));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}
}