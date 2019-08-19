package cardealer.web.controller;

import cardealer.domain.dtos.CarExportRootDto;
import cardealer.service.CarService;
import cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class ExportController {

    private final CarService carService;
    private final XmlParser xmlParser;

    @Autowired
    public ExportController(CarService carService, XmlParser xmlParser) {
        this.carService = carService;
        this.xmlParser = xmlParser;
    }

    public String exportCars() throws JAXBException, IOException {
        CarExportRootDto carExportRootDto = this.carService.exportCars();
        this.xmlParser.exportToXml(carExportRootDto, CarExportRootDto.class, "D:\\SoftUni\\Projects\\Hibernate\\CarDealer\\src\\main\\resources\\output\\cars-and-parts.xml");
        return "Cars exported";
    }


}
