package be.vdab.retrovideo.services;

public interface ReserveringService {
	boolean isGereserveerd(Long klantId, Long filmId);
}