package cardealer.service;

import cardealer.domain.dtos.PartRootDto;
import cardealer.domain.entities.Part;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface PartService {

    void seedParts(PartRootDto partRootDto) throws JAXBException, FileNotFoundException;

    List<Part> getRandomParts();

}
