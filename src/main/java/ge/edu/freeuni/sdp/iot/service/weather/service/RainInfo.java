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
        this.value = value;
    }

    @XmlElement (name = "rain")
    private String value; // "yes" or "no"

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        if (value == null)
            return 0;
        else
            return value.hashCode();
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
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.getValue()))
            return false;
        return true;
    }
}