package be.vdab.retrovideo.repositories;

import java.util.Optional;

import be.vdab.retrovideo.valueobjects.Reservatie;

public interface ReservatieRepository {
	void create(Reservatie reservatie);
	Optional<Reservatie> read(Reservatie reservatie);
}
