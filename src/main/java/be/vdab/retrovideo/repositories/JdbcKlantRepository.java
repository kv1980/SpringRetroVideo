package be.vdab.retrovideo.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.retrovideo.entities.Klant;

@Repository
class JdbcKlantRepository implements KlantRepository {
	private final NamedParameterJdbcTemplate template;
	private static final String SELECT_KLANTEN_BY_LETTERS = "select id, familienaam, voornaam, straatNummer, postcode, gemeente from klanten where familienaam like :letters order by familienaam, voornaam";
	private static final String SELECT_KLANT_BY_ID = "select id, familienaam, voornaam, straatNummer, postcode, gemeente from klanten where id=:id";
	private final RowMapper<Klant> klantRowMapper = (resultSet, rowNum) -> new Klant(resultSet.getLong("id"),
			resultSet.getString("familienaam"), resultSet.getString("voornaam"), resultSet.getString("straatNummer"),
			resultSet.getString("postcode"), resultSet.getString("gemeente"));

	public JdbcKlantRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Klant> findKlantenByLetters(String letters) {
		return template.query(SELECT_KLANTEN_BY_LETTERS, Collections.singletonMap("letters", '%'+letters+'%'),
				klantRowMapper);
	}

	@Override
	public Klant findKlantById(long klantId) {
		return template.queryForObject(SELECT_KLANT_BY_ID, Collections.singletonMap("id", klantId), klantRowMapper);
	}
}