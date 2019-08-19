package cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootDto {

    @XmlElement(name = "supplier")
    private SupplierDto[] supplierDtos;

    public SupplierRootDto() {
    }

    public SupplierDto[] getSupplierDtos() {
        return supplierDtos;
    }

    public void setSupplierDtos(SupplierDto[] supplierDtos) {
        this.supplierDtos = supplierDtos;
    }
}
