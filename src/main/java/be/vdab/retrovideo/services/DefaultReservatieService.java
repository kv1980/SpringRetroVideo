package be.vdab.retrovideo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.repositories.ReservatieRepository;
import be.vdab.retrovideo.valueobjects.Reservatie;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class DefaultReservatieService implements ReservatieService{
	private ReservatieRepository repository;

	public DefaultReservatieService(ReservatieRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(Reservatie reservatie) {
		repository.create(reservatie);
	}
}