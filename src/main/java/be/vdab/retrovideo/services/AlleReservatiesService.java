package be.vdab.retrovideo.services;

import java.util.List;

import be.vdab.retrovideo.valueobjects.Reservatie;

public interface AlleReservatiesService {
	String voerAlleReservatiesUit(List<Reservatie> reservaties);
}
