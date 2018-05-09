package be.vdab.retrovideo.services;

public interface ReserveringService {
	boolean isGereserveerd(long klantId, long filmId);
	String getKlantnaam(long klantId);
}