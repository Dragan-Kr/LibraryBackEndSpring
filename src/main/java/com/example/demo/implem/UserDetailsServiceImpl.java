package com.example.demo.implem;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.jpa.Employee;
import com.example.demo.jpa.Role;
import com.example.demo.jpa.UsersRole;
import com.example.demo.repository.EmployeeCrudRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.security.MyUserDetails;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;



import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeCrudRepository userRepository;
    
    @Autowired
    private EmployeeRepository jpaRepository;

    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper ModelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;


    public UserDetailsServiceImpl(BCryptPasswordEncoder passwordEncoder,
                                  EmployeeCrudRepository userRepository,
                                  ModelMapper modelMapper,
                                  RoleRepository roleRepository,
                                  UserRoleRepository userRoleRepository,

                                  JavaMailSender mailSender
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.ModelMapper = modelMapper;
       this.roleRepository=roleRepository;
        this.mailSender = mailSender;
    }










    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = userRepository.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(user);
    }


////////



    public Optional<Employee> findByCode(String code) {
        return jpaRepository.findByVerificationCode(code);
    }


    public Employee findByVerificationCode(String code) {
        return findByCode(code).get();
    }

    public EmployeeDTO verifyUser(Employee employee) {
        EmployeeDTO userDTO = new EmployeeDTO();
//			visitor.setEnabled(true);
        jpaRepository.enable(employee.getId());
        userDTO.setEmail(employee.getEmail());
        userDTO.setName(employee.getName());
        userDTO.setSurname(employee.getSurname());
        return userDTO;



    }

    public boolean userExists(String email) {
        return  jpaRepository.existsByEmail(email);
    }

    public void register(RegisterDTO registerDTO) {

        // Enkodovanje sifre
        String password = passwordEncoder.encode(registerDTO.getPassword());
        registerDTO.setPassword(password);

        // Generisanje verification koda
        String randomCode = RandomString.make(64);
        registerDTO.setVerificationCode(randomCode);


        //Instanciranje korisnickih prava i korisnika
        UsersRole userAuthority = new UsersRole();
        Employee user = new Employee();

        //Mapiranje iz DTO u Entity model
        ModelMapper.map(registerDTO, user);



        //Cuvanje korisnika u bazu
        userRepository.save(user);


        // Postavljanje role
//        switch (registerDTO.getRole()) {
//            case "ADMIN":
//                userAuthority.setAuthority(securityAuthorityRepository.findOne(1L));
//                userAuthority.setUser(user);
//                securityUserAuthorityRepository.save(userAuthority);
//                break;
//            case "PROFESSOR":
//                userAuthority.setAuthority(securityAuthorityRepository.findOne(2L));
//                userAuthority.setUser(user);
//                securityUserAuthorityRepository.save(userAuthority);
//                break;
//            case "STUDENT":
//                userAuthority.setAuthority(securityAuthorityRepository.findOne(3L));
//                userAuthority.setUser(user);
//                securityUserAuthorityRepository.save(userAuthority);
//                break;
//        }

    }


}
