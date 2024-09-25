package com.manage.controllers;

import com.manage.dto.LoginDto;


import com.manage.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@CrossOrigin(origins = "*")
public class SignUpController {
@Autowired
private SignUpService signUpService;

    @PostMapping
    public ResponseEntity<LoginDto> createEventUser(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(signUpService.createUser(loginDto), HttpStatus.OK);
    }


//    @DeleteMapping("/{customerId}")
//    public ResponseEntity<ApiResponse> removeCustomer(@PathVariable String customerId) {
//        customerService.deleteCustomer(customerId);
//        return new ResponseEntity<>(ApiResponse.builder().response("customer deleted successfully").status(true).httpStatus(HttpStatus.ACCEPTED).build(), HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<PageableResponse<CustomerDto>> getAllCustomer(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
//                                                                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
//                                                                        @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
//                                                                        @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {
//        return new ResponseEntity<>(customerService.getAllCostumer(pageNumber, pageSize, sortBy, sortDirection), HttpStatus.OK);
//    }
//
//    @GetMapping("/{customerId}")
//    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String customerId) {
//        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
//    }
//
//
//    @PutMapping("/{customerId}")
//    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String customerId, @Valid @RequestBody CustomerDto customerDto) {
//        return new ResponseEntity<>(customerService.updateCustomer(customerId, customerDto), HttpStatus.OK);
//    }

}
