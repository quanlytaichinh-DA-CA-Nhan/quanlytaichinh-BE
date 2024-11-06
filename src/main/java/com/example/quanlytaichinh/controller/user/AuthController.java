package com.example.quanlytaichinh.controller.user;

import com.example.quanlytaichinh.config.service.JwtResponse;
import com.example.quanlytaichinh.config.service.JwtService;
import com.example.quanlytaichinh.service.user.UserService;
import com.example.quanlytaichinh.model.entity.users.Role;
import com.example.quanlytaichinh.model.entity.users.RoleName;
import com.example.quanlytaichinh.model.entity.users.User;
import com.example.quanlytaichinh.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Encrypt the password
        String pw = passwordEncoder.encode(user.getPassword());
        user.setPassword(pw);

        // Set default roles to "ROLE_USER"
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findByName(RoleName.ROLE_USER.toString());

        if (role != null) {
            roles.add(role);
        } else {
            return new ResponseEntity<>("Role not found", HttpStatus.BAD_REQUEST);
        }

        user.setRoles(roles);

        // Set balance only if it is null; otherwise, use the provided balance
        if (user.getBalance() == null) {
            user.setBalance(0.0); // Default balance
        }

        // Save user to the database
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED); // Use CREATED status for successful registration
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Đối với JWT, không cần thực hiện gì ở server, chỉ cần xóa token ở client
        return ResponseEntity.ok("Đăng xuất thành công!");
    }



}