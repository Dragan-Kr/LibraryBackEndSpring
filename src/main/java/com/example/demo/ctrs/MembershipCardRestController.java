package com.example.demo.ctrs;

import com.example.demo.dto.MembershipCardDTO;
import com.example.demo.jpa.MembershipCard;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.MembershipCardService;
import com.example.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MembershipCardRestController {
    @Autowired
    private MembershipCardService membershipCardService;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReaderService readerService;

    @GetMapping("membershipCard")
    public Collection<MembershipCard> getMembershipCards(){
        return membershipCardService.findAllObjects();
    }

    @GetMapping("membershipCard/{id}")
    public MembershipCard getMembershipCardById(@PathVariable("id") Integer id){
        return membershipCardService.getObjectById(id);
    }

    @PostMapping("membershipCard")
    public ResponseEntity<MembershipCard> insertMembershipCard(@RequestBody MembershipCardDTO membershipCardDTO){
      MembershipCard membershipCard = new MembershipCard();

      membershipCard.setId(membershipCardDTO.getId());
      membershipCard.setDateofissue(membershipCardDTO.getDateofissue());
      membershipCard.setDuration(membershipCardDTO.getDuration());
      membershipCard.setEmployee(employeeService.getObjectById(membershipCardDTO.getEmployeeid()));
      membershipCard.setReader(readerService.getObjectById(membershipCardDTO.getReaderid()));
      membershipCardService.saveObject(membershipCard);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("membershipCard/{id}")
    public ResponseEntity<MembershipCard> updateMembershipCard(@PathVariable("id") Integer id,@RequestBody MembershipCardDTO membershipCardDTO){
        MembershipCard membershipCard =membershipCardService.getObjectById(id);
//        membershipCard.setId(membershipCardDTO.getId());
        membershipCard.setDateofissue(membershipCardDTO.getDateofissue());
        membershipCard.setDuration(membershipCardDTO.getDuration());
        membershipCard.setEmployee(employeeService.getObjectById(membershipCardDTO.getEmployeeid()));
        membershipCard.setReader(readerService.getObjectById(membershipCardDTO.getReaderid()));
        MembershipCard updated = membershipCardService.save(membershipCard);
        return ResponseEntity.ok(updated);


    }


    @DeleteMapping("membershipCard/{id}")
    public ResponseEntity<MembershipCard> deleteMembershipCard(@PathVariable("id") Integer id){
        if(!membershipCardService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            jdbcTemplate.execute("delete  from payment where memcardid =" +id);
            jdbcTemplate.execute("delete from rent where memcardid =" +id);
            membershipCardService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
