package cardealer.service;

import cardealer.domain.dtos.*;
import cardealer.domain.entities.Car;
import cardealer.domain.entities.Part;
import cardealer.repository.CarRepository;
import cardealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final PartService partService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCars(CarRootDto carRootDto) throws JAXBException, FileNotFoundException {
        for (CarDto carDto : carRootDto.getCarDtos()) {
            if (!this.validationUtil.isValid(carDto)){
                System.out.println("Something went wrong");
                continue;
            }

            Car entity = this.modelMapper.map(carDto, Car.class);
            entity.setParts(this.partService.getRandomParts());
            this.carRepository.saveAndFlush(entity);
        }
    }

    @Override
    public CarExportRootDto exportCars() {
        List<Car> entities = this.carRepository.findAll();
        List<CarExportDto> carExportDtos = new ArrayList<>();
        for (Car entity : entities) {
            CarExportDto carExportDto = this.modelMapper.map(entity, CarExportDto.class);
            List<PartExportDto> partExportDtos = new ArrayList<>();
            for (Part part : entity.getParts()) {
                PartExportDto partExportDto = this.modelMapper.map(part, PartExportDto.class);
                partExportDtos.add(partExportDto);
            }
            PartExportRootDto partExportRootDto = new PartExportRootDto();
            partExportRootDto.setPartExportDtos(partExportDtos);
            carExportDto.setPartExportRootDto(partExportRootDto);

            carExportDtos.add(carExportDto);
        }

        CarExportRootDto carExportRootDto = new CarExportRootDto();
        carExportRootDto.setCarExportDtos(carExportDtos);

        return carExportRootDto;
    }
}
