package cardealer.service;

import cardealer.domain.dtos.CustomerDto;
import cardealer.domain.dtos.CustomerRootDto;
import cardealer.domain.entities.Customer;
import cardealer.repository.CustomerRepository;
import cardealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers(CustomerRootDto customerRootDto) {
        for (CustomerDto customerDto : customerRootDto.getCustomerDtos()) {
            if (!this.validationUtil.isValid(customerDto)){
                System.out.println("Something went wrong");
                continue;
            }

            Customer entity = this.modelMapper.map(customerDto, Customer.class);
            entity.setBirthDate(LocalDate.parse(customerDto.getBirthDate()));
            this.customerRepository.saveAndFlush(entity);
        }
    }
}
