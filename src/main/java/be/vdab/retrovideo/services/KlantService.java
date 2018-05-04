package be.vdab.retrovideo.services;

import java.util.List;

import be.vdab.retrovideo.entities.Klant;

public interface KlantService {
	List<Klant> findKlantenByLetters(String letters);
	Klant findKlantById(long klantId);
}
