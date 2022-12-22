package com.example.demo.service;

import com.example.demo.jpa.MembershipCard;

import java.util.Collection;

public interface MembershipCardService {
    Collection<MembershipCard> findAllObjects();

    MembershipCard getObjectById(Integer id);

    boolean existsObjectById(Integer id);

    void saveObject(MembershipCard membershipCard);

    void deleteObjectById(Integer id);

    MembershipCard save(MembershipCard membershipCard);
}
