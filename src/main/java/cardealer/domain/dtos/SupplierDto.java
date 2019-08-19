package cardealer.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierDto {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "is-imported")
    private Boolean isImported;

    public SupplierDto() {
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public Boolean isImported() {
        return isImported;
    }

    public void setImported(Boolean imported) {
        isImported = imported;
    }
}
