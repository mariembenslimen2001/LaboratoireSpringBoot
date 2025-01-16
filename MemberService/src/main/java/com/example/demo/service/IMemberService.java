package com.example.demo.service;



import java.util.List;
import java.util.Map;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;

public interface IMemberService {
    //Crud sur les membres
    public Member addMember(Member m);
    public void deleteMember(Long id) ;
    public Member updateMember(Member p) ;
    public Member findMember(Long id) ;
    public List<Member> findAll();

    //Filtrage par propriété
    public Member findByCin(String cin);
    public Member findByEmail(String email);
    public List<Member> findByNom(String nom);

    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);

    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String etablissement);

    public Member findMemberById(Long id);

    public List<Etudiant> findByEncadrant(EnseignantChercheur enseignantChercheur);



    public void affectEtudiantToEncadrant(Long id_etd, Long id_ens);

    // publication auteur
    public void affecterAuteurToPublication(Long idauteur, Long idpub);

    public List<PublicationBean> findPublicationparauteur (Long idauteur);
    
 // outil user
    public void affecterUserToOutil(Long userid, Long outilid);
    public List<OutilBean> findOutilsByUser (Long userid);
    public Member findMemberByOutil(Long outil_id);
    // evenement member
    public void affecterMemberToEvenement(Long memberid, Long evenid);
    public List<EvenementBean> findEvenementsByMember (Long memberid);
    public List<EnseignantChercheur> getEnseignants();
    public List<Etudiant> getEtudiants();
    public List<Member> findMembersByEvent(Long eventId);
    public void deleteMemberEvenementsByMemberId(Long memberId);
    public void deleteMemberPubsByMemberId(Long memberId);
    public void deleteMemberToolsByMemberId(Long memberId);
    public void setEncadrantToNull(EnseignantChercheur enseignantChercheur);
    public void deleteMemberEventsByEventId(Long id);
    public Map<String,Integer> getNumberMembersPerGrade();
    public Map<String,Integer> getNumberMembersPerDiplome();
    public Map<String,Integer> getNumberMembersPerEtablissement();


    
}

