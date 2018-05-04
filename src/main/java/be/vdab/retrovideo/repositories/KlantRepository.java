package be.vdab.retrovideo.repositories;

import java.util.List;

import be.vdab.retrovideo.entities.Klant;

public interface KlantRepository {
	List<Klant>findKlantenByLetters(String letters);
	Klant findKlantById(long id);
}
