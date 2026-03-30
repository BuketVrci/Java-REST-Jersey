package demo.sensor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("robot")  //robot/
public class RobotResource {
	
	private SensorValue sensorValue;
	
	public RobotResource() {
		sensorValue = new SensorValue();
	}
	
	@GET
	@Path("battery") //can be deleted
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SensorValue getSensorValue() {
		sensorValue.reduceValue();
		System.out.println("GET/robot/battery : " + sensorValue);
		return sensorValue;
	}
	
	@GET
	@Path("battery")
	@Produces({MediaType.TEXT_PLAIN})
	public String getSensorValueInCSV() {
		sensorValue.reduceValue();
		System.out.println("GET/robot/battery (in CSV) : " + sensorValue);
		return sensorValue.time + "," + sensorValue.value + "," + sensorValue.capacity;
	}
	
}
