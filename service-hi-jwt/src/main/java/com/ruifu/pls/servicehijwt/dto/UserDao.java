package com.ruifu.pls.servicehijwt.dto;

import com.ruifu.pls.servicehijwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
