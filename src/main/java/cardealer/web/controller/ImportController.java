package cardealer.web.controller;

import cardealer.domain.dtos.CarRootDto;
import cardealer.domain.dtos.CustomerRootDto;
import cardealer.domain.dtos.PartRootDto;
import cardealer.domain.dtos.SupplierRootDto;
import cardealer.service.CarService;
import cardealer.service.CustomerService;
import cardealer.service.PartService;
import cardealer.service.SupplierService;
import cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Controller
public class ImportController {

    private final static String SUPPLIERS_XML_FILE_PATH = "D:\\SoftUni\\Projects\\Hibernate\\CarDealer\\src\\main\\resources\\files\\suppliers.xml";
    private final static String PARTS_XML_FILE_PATH = "D:\\SoftUni\\Projects\\Hibernate\\CarDealer\\src\\main\\resources\\files\\parts.xml";
    private final static String CARS_XML_FILE_PATH = "D:\\SoftUni\\Projects\\Hibernate\\CarDealer\\src\\main\\resources\\files\\cars.xml";
    private final static String CUSTOMERS_XML_FILE_PATH = "D:\\SoftUni\\Projects\\Hibernate\\CarDealer\\src\\main\\resources\\files\\customers.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final XmlParser xmlParser;

    @Autowired
    public ImportController(SupplierService supplierService, PartService partService,
                            CarService carService, CustomerService customerService, XmlParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.xmlParser = xmlParser;
    }


    public String seedSuppliers() throws JAXBException, FileNotFoundException {

        SupplierRootDto supplierRootDto = this.xmlParser.parseXml(SupplierRootDto.class, SUPPLIERS_XML_FILE_PATH);

        this.supplierService.seedSuppliers(supplierRootDto);
        return "Suppliers imported";
    }

    public String seedParts() throws JAXBException, FileNotFoundException {

        PartRootDto partRootDto = this.xmlParser.parseXml(PartRootDto.class, PARTS_XML_FILE_PATH);

        this.partService.seedParts(partRootDto);
        return "Parts imported";
    }

    public String seedCars() throws JAXBException, FileNotFoundException {

        CarRootDto carRootDto = this.xmlParser.parseXml(CarRootDto.class, CARS_XML_FILE_PATH);

        this.carService.seedCars(carRootDto);
        return "Cars imported";
    }

    public String seedCustomers() throws JAXBException, FileNotFoundException {

        CustomerRootDto customerRootDto = this.xmlParser.parseXml(CustomerRootDto.class, CUSTOMERS_XML_FILE_PATH);

        this.customerService.seedCustomers(customerRootDto);
        return "Customers imported";
    }
}
