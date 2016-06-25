package ge.edu.freeuni.sdp.iot.service.weather.core;

/**
 * Created by Tornike on 24.06.2016.
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TemperatureInfo {

    public TemperatureInfo(int celsius, int fahrenheit){
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public TemperatureInfo(){}

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    @XmlElement(name = "temp_c")
    private int celsius;

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @XmlElement(name = "temp_f")
    private int fahrenheit;


    @Override
    public int hashCode() {
        final int prime = 1000;
        int result = 1;
        result = prime * result + celsius;
        result = prime * result + fahrenheit;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TemperatureInfo other = (TemperatureInfo) obj;
        return celsius == other.getCelsius() && fahrenheit == other.getFahrenheit();
    }
}