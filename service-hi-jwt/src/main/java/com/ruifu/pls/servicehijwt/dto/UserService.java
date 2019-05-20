package com.ruifu.pls.servicehijwt.dto;

import com.ruifu.pls.servicehijwt.entity.User;

public interface UserService {
    public User create(String username, String password);
}
