package com.example.quanlytaichinh.service.role;



import com.example.quanlytaichinh.model.DTO.GetNumberOfRole;
import com.example.quanlytaichinh.model.entity.users.Role;

import java.util.Optional;

public interface IRoleService {
    Iterable<GetNumberOfRole> getAllNumberOfRole();
    Role findByName(String name);
    Iterable<Role> getAllRoles();
    Optional<Role> findById(Long id);

}
