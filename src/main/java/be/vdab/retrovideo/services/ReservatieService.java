package be.vdab.retrovideo.services;

import java.util.Optional;

import be.vdab.retrovideo.valueobjects.Reservatie;

public interface ReservatieService {
	void create(Reservatie reservatie);
	Optional<Reservatie> read(Reservatie reservatie);
}
