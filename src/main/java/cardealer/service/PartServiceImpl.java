package cardealer.service;

import cardealer.domain.dtos.PartDto;
import cardealer.domain.dtos.PartRootDto;
import cardealer.domain.entities.Part;
import cardealer.repository.PartRepository;
import cardealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, ValidationUtil validationUtil, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
    }

    @Override
    public void seedParts(PartRootDto partRootDto) throws JAXBException, FileNotFoundException {
        for (PartDto partDto : partRootDto.getPartDtos()) {
            if (!this.validationUtil.isValid(partDto)){
                System.out.println("Something went wrong");
                continue;
            }

            Part entity = this.modelMapper.map(partDto, Part.class);
            entity.setSupplier(this.supplierService.getRandomSupplier());
            this.partRepository.saveAndFlush(entity);
        }
    }

    @Override
    public List<Part> getRandomParts() {
        Random random = new Random();
        List<Part> parts = new ArrayList<>();
        List<Part> partEntities = this.partRepository.findAll();

        int size = random.nextInt(10) + 10;

        for (int i = 0; i < size; i++) {
            int id = random.nextInt((int) (this.partRepository.count() - 1)) + 1;
            parts.add(partEntities.get(id));
        }

        return parts;
    }
}
