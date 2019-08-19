package cardealer.service;

import cardealer.domain.dtos.CarExportRootDto;
import cardealer.domain.dtos.CarRootDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CarService {

    void seedCars(CarRootDto carRootDto) throws JAXBException, FileNotFoundException;

    CarExportRootDto exportCars();
}
