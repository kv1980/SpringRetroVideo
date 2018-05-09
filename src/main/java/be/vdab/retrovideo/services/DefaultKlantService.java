package be.vdab.retrovideo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.entities.Klant;
import be.vdab.retrovideo.repositories.KlantRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultKlantService implements KlantService {
	private final KlantRepository repository;

	public DefaultKlantService(KlantRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Klant> findKlantenByLetters(String letters) {
		return repository.findKlantenByLetters(letters);
	}

	@Override
	public Klant findKlantById(long klantId) {
		return repository.findKlantById(klantId);
	}
}