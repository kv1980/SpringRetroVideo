package be.vdab.retrovideo.web;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
class DefaultMandje implements Serializable, Mandje {
	private static final long serialVersionUID = 1L;
	private final Set<Long> filmIds = new LinkedHashSet<>();

	@Override
	public void addFilmId(long filmId) {
		filmIds.add(filmId);
	}

	@Override
	public Set<Long> getFilmIds() {
		return filmIds;
	}
}