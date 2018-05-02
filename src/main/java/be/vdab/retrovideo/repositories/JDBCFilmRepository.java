package be.vdab.retrovideo.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Film;
import be.vdab.retrovideo.exceptions.FilmNietGevondenException;

@Repository
class JDBCFilmRepository implements FilmRepository {
	private final NamedParameterJdbcTemplate template;
	private static final String UPDATE_FILM = "update films set gereserveerd=:gereserveerd where id=:id";
	private static final String SELECT_ID_BY_GENREID = "select id from films where genreId=:genreId order by titel";
	private static final String SELECT_FILM_BY_ID = "select id, titel, voorraad, gereserveerd, prijs from films where id=:id";
	private final RowMapper<Long> idRowMapper =
			(resultSet,rowNum) -> resultSet.getLong("id");
	private final RowMapper<Film> filmRowMapper =
			(resultSet,rowNum) -> new Film(resultSet.getLong("id"),resultSet.getString("titel"),resultSet.getInt("voorraad"),
										   resultSet.getInt("gereserveerd"),resultSet.getBigDecimal("prijs"));		
			
	public JDBCFilmRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public void update(Film film) {
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("id", film.getId());
		parameters.put("gereserveerd", film.getGereserveerd());
		if (template.update(UPDATE_FILM, parameters) == 0) {
			throw new FilmNietGevondenException();
		}
	}
				
	@Override
	public List<Long> findFilmIdsByGenreId(Long genreId) {
		return template.query(SELECT_ID_BY_GENREID,idRowMapper);
	}
		
	@Override
	public Film findFilmById(Long filmId) {
		return template.queryForObject(SELECT_FILM_BY_ID,Collections.singletonMap("id",filmId),filmRowMapper);
	}
}
