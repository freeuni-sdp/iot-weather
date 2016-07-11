package ge.edu.freeuni.sdp.iot.service.weather.service;

/**
 * Created by Tornike on 24.06.2016.
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RainInfo {

    public RainInfo(){

    }

    public RainInfo(String value){
        this.rain = value;
    }

    @XmlElement (name = "rain")
    private String rain; // "yes" or "no"

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    @Override
    public int hashCode() {
        if (rain == null)
            return 0;
        else
            return rain.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RainInfo other = (RainInfo) obj;
        if (rain == null) {
            if (other.rain != null)
                return false;
        } else if (!rain.equals(other.getRain()))
            return false;
        return true;
    }
}