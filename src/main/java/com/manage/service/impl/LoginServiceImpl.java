package com.manage.service.impl;


import com.manage.dto.LoginDto;

import com.manage.entities.Login;


import com.manage.repositories.LoginRepo;
import com.manage.service.LoginService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
@Autowired
    private LoginRepo loginRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LoginDto authenticateUser(LoginDto loginDto) {

//
//        return modelMapper.map(loginRepo.save(modelMapper.map(loginDto, Login.class)), LoginDto.class);
        Login loginCredentials = loginRepo.findByUsername(loginDto.getUsername());
        if (loginCredentials != null) {
            if(loginDto.getPassword().equals(loginCredentials.getPassword())&&(loginDto.getRole().equalsIgnoreCase((loginCredentials.getRole())))) {

                return modelMapper.map(loginCredentials, LoginDto.class);
            }
        }
  return null;

    }
//    @Override
//    public LoginDto getCustomerById(String customerId) {
//        return modelMapper.map(loginRepo.findById(customerId).get(), LoginDto.class);
//    }
//    @Override
//    public void deleteCustomer(String customerId) {
//        customerRepo.delete(customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + customerId)));
//
//
//    }
//
//    @Override
//    public CustomerDto updateCustomer(String existingCustomerId, CustomerDto customerDto) {
//        Customer customer = customerRepo.findById(existingCustomerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + existingCustomerId));
//        customer.setName(customerDto.getName());
//        customer.setEmail(customerDto.getEmail());
//        customer.setAddress(customerDto.getAddress());
//        customer.setPhone(customerDto.getPhone());
//        customer.setNotes(customerDto.getNotes());
//        return modelMapper.map(customerRepo.save(customer), CustomerDto.class);
//    }
//
//    @Override
//    public PageableResponse<CustomerDto> getAllCostumer(int pageNumber, int pageSize, String sortBy, String sortDirection) {
//        return Helper.getPageableResponse(customerRepo.findAll(PageRequest.of(pageNumber, pageSize, sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending())), CustomerDto.class);
//
//    }
//
//    @Override
//    public CustomerDto getCustomerById(String customerId) {
//        return modelMapper.map(customerRepo.findById(customerId).get(), CustomerDto.class);
//    }
}
