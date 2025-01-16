package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Member;
import com.example.demo.entities.Member_Evenement;

import jakarta.transaction.Transactional;
//@CrossOrigin(origins = "http://localhost:4200")
public interface MemberEvenRepository extends
        JpaRepository<Member_Evenement, Long> {
    List<Member_Evenement> findByMember(Member member);
    List<Member_Evenement> findByEventId(Long eventId);


    @Transactional
    void deleteAllByMember(Member member);

    @Transactional
    void deleteAllByEventId(Long id);
}
