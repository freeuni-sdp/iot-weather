package ge.edu.freeuni.sdp.iot.service.weather.service;

/**
 * Created by Tornike on 24.06.2016.
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TemperatureInfo {

    public TemperatureInfo(int celsius, int fahrenheit){
        this.temp_c = celsius;
        this.temp_f = fahrenheit;
    }

    public TemperatureInfo(){}


    @XmlElement(name = "temp_c")
    private int temp_c;

    @XmlElement(name = "temp_f")
    private int temp_f;

    public int getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(int temp_f) {
        this.temp_f = temp_f;
    }

    public int getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(int temp_c) {
        this.temp_c = temp_c;
    }

    @Override
    public int hashCode() {
        final int prime = 1000;
        int result = 1;
        result = prime * result + temp_c;
        result = prime * result + temp_f;
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
        return temp_c == other.getTemp_c() && temp_f == other.getTemp_f();
    }
}