package com.example.demo.ctrs;

import com.example.demo.dto.*;
import com.example.demo.implem.UserDetailsServiceImpl;
import com.example.demo.jpa.Author;
import com.example.demo.jpa.Book;
import com.example.demo.jpa.Employee;
//import com.example.demo.security.TokenUtils;
import com.example.demo.jpa.Role;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;



//    @Autowired
//    TokenUtils tokenUtils;

@GetMapping("employee")
public Collection<Employee> getAuthors(){
    return employeeService.findAllObjects();
}


    @GetMapping("employee/{username}")
    public String getRoleByUsername(@PathVariable("username") String username){
        Employee a = employeeService.getPersonByUsername(username);
        Role role = a.getRoles().stream().findFirst().get();//?
        return  role.getId().toString();
    }


    @GetMapping("employee/{username}/{password}")
    public  String getUserByUsername(@PathVariable("username") String username,@PathVariable("password") String password){
        Employee a = employeeService.getPersonByUsername(username);
        if(a!=null){
            if(a.getPassword().toString().equals(password.toString())){
                return "1";
            }else{
                return "0";
            }
        }else{
            return "-1";
        }
    }


    @PostMapping("employee")
    public ResponseEntity addEmployee(@RequestBody EmployeeDTO employeeDTO) {
      Employee employee = new Employee();
      employee.setId(employeeDTO.getId());
      employee.setAddress(employeeDTO.getAddress());
      employee.setContact(employeeDTO.getContact());
      employee.setJbmg(employeeDTO.getJbmg());
      employee.setName(employeeDTO.getName());
      employee.setPassword(employeeDTO.getPassword());
      employee.setSurname(employeeDTO.getSurname());
      employee.setUsername(employeeDTO.getUsername());
      employee.setEnabled(employeeDTO.getEnabled());

      employee = employeeService.saveObject(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @GetMapping("/api/auth")
    public ResponseEntity verifySalonClientAcc(@RequestParam("code") String code) {
        Employee user = userDetailsServiceImpl.findByVerificationCode(code);
        EmployeeDTO verified = userDetailsServiceImpl.verifyUser(user);
        return new ResponseEntity(verified, HttpStatus.OK);
    }




    /**
     * API za registraciju korisnika
     *
     * @param registerDTO
     **/
    @PostMapping(value = "/api/users/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO) throws UnsupportedEncodingException, MessagingException {
        if (userDetailsServiceImpl.userExists(registerDTO.getEmail())) {
            return new ResponseEntity<>("already exist", HttpStatus.CONFLICT);
        } else {
            userDetailsServiceImpl.register(registerDTO);
           //userDetailsServiceImpl.sendVerification(registerDTO);
        }

        return new ResponseEntity(HttpStatus.OK);
    }





    @Transactional
    @DeleteMapping("employee/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        if(!employeeService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            jdbcTemplate.execute("delete from book_order where employeeid=" +id);
            jdbcTemplate.execute("delete from membership_card where employeeid ="+id);
            jdbcTemplate.execute("delete from payment where employeeid ="+id);
            jdbcTemplate.execute("delete from rent where empid ="+id);

            employeeService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



}
