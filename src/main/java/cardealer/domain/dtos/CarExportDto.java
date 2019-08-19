package cardealer.domain.dtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportDto {

    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @XmlElement(name = "parts")
    private PartExportRootDto partExportRootDto;

    public CarExportDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartExportRootDto getPartExportRootDto() {
        return partExportRootDto;
    }

    public void setPartExportRootDto(PartExportRootDto partExportRootDto) {
        this.partExportRootDto = partExportRootDto;
    }
}
