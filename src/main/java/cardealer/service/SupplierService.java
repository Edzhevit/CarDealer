package cardealer.service;

import cardealer.domain.dtos.SupplierRootDto;
import cardealer.domain.entities.Supplier;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SupplierService {
    void seedSuppliers(SupplierRootDto supplierRootDto) throws JAXBException, FileNotFoundException;

    Supplier getRandomSupplier();
}
