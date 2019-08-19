package cardealer.service;

import cardealer.domain.dtos.SupplierDto;
import cardealer.domain.dtos.SupplierRootDto;
import cardealer.domain.entities.Supplier;
import cardealer.repository.SupplierRepository;
import cardealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Random;

@Service
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedSuppliers(SupplierRootDto supplierRootDto) throws JAXBException, FileNotFoundException {
        for (SupplierDto supplierDto : supplierRootDto.getSupplierDtos()) {
            if (!this.validationUtil.isValid(supplierDto)){
                System.out.println("Something went wrong!");
                continue;
            }

            Supplier entity = this.modelMapper.map(supplierDto, Supplier.class);
            this.supplierRepository.saveAndFlush(entity);
        }
    }

    @Override
    public Supplier getRandomSupplier() {
        Random random = new Random();
        int id = random.nextInt((int) (this.supplierRepository.count() - 1)) + 1;
        return this.supplierRepository.findById(id).orElse(null);
    }
}
