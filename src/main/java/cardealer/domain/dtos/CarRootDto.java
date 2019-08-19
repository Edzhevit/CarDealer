package cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarRootDto {

    @XmlElement(name = "car")
    private CarDto[] carDtos;

    public CarRootDto() {
    }

    public CarDto[] getCarDtos() {
        return carDtos;
    }

    public void setCarDtos(CarDto[] carDtos) {
        this.carDtos = carDtos;
    }
}
