package com.yaco.Logger.Dto;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yaco.Logger.Dto.UserRepository;
import com.yaco.Logger.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<UserRepository> findAllProjectedBy();
}
