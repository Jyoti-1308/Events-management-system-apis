package com.manage.service.impl;

import com.manage.dto.LoginDto;
import com.manage.entities.Login;
import com.manage.repositories.LoginRepo;
import com.manage.service.SignUpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private LoginRepo loginRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LoginDto createUser(LoginDto loginDto) {
        Login loginCredentials = loginRepo.findByUsername(loginDto.getUsername());
        if (loginCredentials != null){
                return loginDto;
            }
            else{
                loginDto.setId(UUID.randomUUID().toString());
                return modelMapper.map(loginRepo.save(modelMapper.map(loginDto, Login.class)), LoginDto.class);
            }
        }
    }
