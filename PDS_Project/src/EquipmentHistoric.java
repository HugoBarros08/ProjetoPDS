import java.util.Date;

public class EquipmentHistoric
{
	private int historicId;
	private String log;
	private Date date;
	
	public void equipmentHistoric(int id, String log, Date date)
	{
		this.historicId = id;
		this.log = log;
		this.date = date;
	}
	
	public int getHistoricId()
	{
		return this.historicId;
	}
	
	public void setHistoricId(int id)
	{
		this.historicId = id;
	}
	
	public String getLog()
	{
		return this.log;
	}
	
	public void setLog(String log)
	{
		this.log = log;
	}
}
