package cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRootDto {

    @XmlElement(name = "customer")
    private CustomerDto[] customerDtos;

    public CustomerRootDto() {
    }

    public CustomerDto[] getCustomerDtos() {
        return customerDtos;
    }

    public void setCustomerDtos(CustomerDto[] customerDtos) {
        this.customerDtos = customerDtos;
    }
}
