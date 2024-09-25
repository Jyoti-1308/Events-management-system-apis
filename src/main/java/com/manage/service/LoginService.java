package com.manage.service;

import com.manage.dto.LoginDto;

public interface LoginService {
    LoginDto authenticateUser(LoginDto loginDto);
}
