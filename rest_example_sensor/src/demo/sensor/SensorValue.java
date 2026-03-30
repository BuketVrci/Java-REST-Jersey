package demo.sensor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Instant;

@XmlRootElement(name = "battery")
public class SensorValue {
	@XmlElement
	@XmlJavaTypeAdapter(MyInstantAdapter.class)
	public Instant time;
	public double value;
	public String capacity;

	public SensorValue() {
		time = Instant.now();
		value = 100;
		capacity = "43.2 Wh";
	}
	
	public double reduceValue() {
		double difference = Math.random() * 5;
		System.out.println("Reducing value by " + difference);
		value = value - difference;
		return value;
	}

	@Override
	public String toString() {
		return "SensorValue{" +
				"time=" + time +
				", value=" + value +
				", capacity=" + capacity + "}";
	}
}
