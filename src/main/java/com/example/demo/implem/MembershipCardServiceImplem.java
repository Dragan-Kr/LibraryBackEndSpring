package com.example.demo.implem;

import com.example.demo.jpa.MembershipCard;
import com.example.demo.repository.MembershipCardRepository;
import com.example.demo.service.MembershipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MembershipCardServiceImplem implements MembershipCardService {
    @Autowired
    private MembershipCardRepository membershipCardRepository;


    @Override
    public Collection<MembershipCard> findAllObjects() {
        return membershipCardRepository.findAll();
    }

    @Override
    public MembershipCard getObjectById(Integer id) {
        return membershipCardRepository.getOne(id);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return membershipCardRepository.existsById(id);
    }

    @Override
    public void saveObject(MembershipCard membershipCard) {
        membershipCardRepository.save(membershipCard);
    }

    @Override
    public void deleteObjectById(Integer id) {
        membershipCardRepository.deleteById(id);
    }

    @Override
    public MembershipCard save(MembershipCard membershipCard) {
        return membershipCardRepository.save(membershipCard);
    }


}
