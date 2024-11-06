package com.example.quanlytaichinh.service.role;


import com.example.quanlytaichinh.model.DTO.GetNumberOfRole;
import com.example.quanlytaichinh.model.entity.users.Role;
import com.example.quanlytaichinh.model.entity.users.RoleName;
import com.example.quanlytaichinh.repo.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        try {
            RoleName roleName = RoleName.valueOf(name); // Chuyển đổi String sang RoleName
            return roleRepository.findByName(roleName); // Gọi phương thức với RoleName
        } catch (IllegalArgumentException e) {
            // Xử lý nếu tên không hợp lệ
            return null; // Hoặc xử lý theo cách khác
        }
    }

    @Override
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Iterable<GetNumberOfRole> getAllNumberOfRole() {
        return roleRepository.getAllNumberOfRole();
    }
}
