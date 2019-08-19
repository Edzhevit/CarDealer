package cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartRootDto {

    @XmlElement(name = "part")
    private PartDto[] partDtos;

    public PartRootDto() {
    }

    public PartDto[] getPartDtos() {
        return partDtos;
    }

    public void setPartDtos(PartDto[] partDtos) {
        this.partDtos = partDtos;
    }
}
