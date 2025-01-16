package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Member;
import com.example.demo.entities.Member_Outil;
import com.example.demo.entities.Member_Outil_Id;

import jakarta.transaction.Transactional;
//@CrossOrigin(origins = "http://localhost:4200")
public interface MemberOutilRepository extends
        JpaRepository<Member_Outil, Member_Outil_Id> {
    List<Member_Outil> findByUser(Member user);
    @Transactional
    void deleteAllByUser(Member user);




}
