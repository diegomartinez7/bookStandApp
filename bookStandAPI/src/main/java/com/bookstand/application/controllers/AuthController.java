package com.bookstand.application.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstand.application.models.MensajeModel.Mensaje;
import com.bookstand.application.models.RolModel.Rol;
import com.bookstand.application.models.RolModel.RolesEnum;
import com.bookstand.application.models.UsuarioModel.Usuario;
import com.bookstand.application.models.UsuarioModel.DTOs.LoginReqDTO;
import com.bookstand.application.models.UsuarioModel.DTOs.SignupReqDTO;
import com.bookstand.application.models.UsuarioModel.DTOs.UserInfoResDTO;
import com.bookstand.application.repositories.RolRepository;
import com.bookstand.application.repositories.UsuarioRepository;
import com.bookstand.application.security.jwt.JwtUtils;
import com.bookstand.application.security.services.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginReqDTO loginRequest) {
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword())
            );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
            .body(new UserInfoResDTO(
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles
            ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupReqDTO signUpRequest) {
        if (usuarioRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new Mensaje("Error: El nombre de usuario ya existe"));
        }

        if (usuarioRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new Mensaje("Error: El email ya fue registrado"));
        }

        Usuario user = new Usuario(
            signUpRequest.getNombre(),
            signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            encoder.encode(signUpRequest.getPassword())
        );

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Rol> roles = new HashSet<>();

        if (strRoles == null) {
            // Rol rolUsuario = rolRepository.findByNombre(RolesEnum.ROL_USUARIO)
            Rol rolUsuario = rolRepository.findByNombre(RolesEnum.ROL_USUARIO.name())
                .orElseThrow(() -> new RuntimeException("Error: No se encontró el rol"));
            roles.add(rolUsuario);
        }
        else {
            strRoles.forEach(rol -> {
                switch (rol) {
                    case "admin":
                        System.out.println("ENTRE AL ROL DE ADMIN");
                        // Rol rolAdmin = rolRepository.findByNombre(RolesEnum.ROL_ADMIN)
                        Rol rolAdmin = rolRepository.findByNombre(RolesEnum.ROL_ADMIN.name())
                            .orElseThrow(() -> new RuntimeException("Error: No se encontró el rol"));
                        roles.add(rolAdmin);
                    break;
                    default:
                        // Rol rolUsuario = rolRepository.findByNombre(RolesEnum.ROL_USUARIO)
                        Rol rolUsuario = rolRepository.findByNombre(RolesEnum.ROL_USUARIO.name())
                            .orElseThrow(() -> new RuntimeException("Error: No se encontró el rol"));
                        roles.add(rolUsuario);
                }
            });
        }
        user.setRoles(roles);
        usuarioRepository.save(user);
        return ResponseEntity.ok(new Mensaje("Registro exitoso de usuario"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body(new Mensaje("Sesión cerrada"));
    }
}