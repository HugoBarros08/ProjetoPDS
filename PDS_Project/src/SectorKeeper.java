import exceptions.ExistentSectorException;
import exceptions.InexistentSectorException;
import java.util.ArrayList;

public class SectorKeeper
{
	ArrayList<Sector> sectors;
	
	public SectorKeeper()
	{
		sectors = new ArrayList<Sector>();
	}
	
	public void createSector(String name) throws ExistentSectorException
	{
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(name))
			{
				throw new ExistentSectorException("Já existe um setor registrado com esse nome");
			}
		}
		
		Sector newSector = new Sector(name);
		
		sectors.add(newSector);
	}
	
	public void deleteSector(String name) throws InexistentSectorException
	{
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(name))
			{
				sectors.remove(index);
				return;
			}
		}
		
		throw new InexistentSectorException("Setor inexistente");
	}
	
	public void updateSector(String name, String newName) throws ExistentSectorException, InexistentSectorException
	{
		Sector foundOne = null;
		
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(newName))
			{
				throw new ExistentSectorException("Já existe um setor registrado com o novo nome");	
			
			} else if(sectors.get(index).getName().equalsIgnoreCase(name)){
				
				foundOne = sectors.get(index);
			}
		}
		
		if(foundOne != null)
		{
			foundOne.setName(newName);
			
		} else {
			
			throw new InexistentSectorException("Setor inexistente");
		}
	}
	
	public Sector searchSector(String name) throws InexistentSectorException
	{
		for(int index = 0; index < sectors.size(); index++)
		{
			if(sectors.get(index).getName().equalsIgnoreCase(name))
			{
				return sectors.get(index);
			}
		}
		
		throw new InexistentSectorException("Setor inexistente");
	}
	
	public void schedule()
	{
		
	}
	
	public void reschedule()
	{
		
	}
}
