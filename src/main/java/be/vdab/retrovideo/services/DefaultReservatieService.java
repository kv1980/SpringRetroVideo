package be.vdab.retrovideo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.retrovideo.repositories.ReservatieRepository;
import be.vdab.retrovideo.valueobjects.Reservatie;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class DefaultReservatieService implements ReservatieService {
	private final ReservatieRepository reservatieRepository;

	public DefaultReservatieService(ReservatieRepository reservatieRepository) {
		this.reservatieRepository = reservatieRepository;
	}

	@Override
	public void create(Reservatie reservatie) {
		reservatieRepository.create(reservatie);
	}
}