package com.manage.service;

import com.manage.dto.LoginDto;

public interface SignUpService {
    LoginDto createUser(LoginDto loginDto);
}
