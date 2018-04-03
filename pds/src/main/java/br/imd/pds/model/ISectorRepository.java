package br.imd.pds.model;

public interface ISectorRepository {
	public void createSector();
	public void deleteSector();
	public void updateSector();
	public Sector searchSector();
	public void schedule();
	public void reschedule();
}
