package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.service.IMemberService;

import lombok.AllArgsConstructor;

//Indique que cette classe est un contrôleur REST pour gérer les requêtes HTTP
@RestController
//Génère un constructeur avec tous les arguments pour l'injection des dépendances
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MemberRestController {

 // Dépendance vers le service pour la logique métier des membres
 private final IMemberService memberService;

 // Gère les requêtes GET pour récupérer tous les membres
 @GetMapping("/membres")
 public List<Member> findMembres() {
     return memberService.findAll();  // Renvoie la liste de tous les membres
 }

 // Gère les requêtes GET pour récupérer un membre par ID
 @GetMapping("/membres/{id}")
 public Member findOneMemberById(@PathVariable Long id) {
     return memberService.findMember(id);  // Recherche et renvoie le membre avec l'ID fourni
 }

 // Gère les requêtes GET pour rechercher un membre par CIN
 @GetMapping("/membres/search/cin")
 public Member findOneMemberByCin(@RequestParam String cin) {
     return memberService.findByCin(cin);  // Recherche un membre par CIN
 }

 // Gère les requêtes GET pour rechercher un membre par email
 @GetMapping("/membres/search/email")
 public Member findOneMemberByEmail(@RequestParam String email) {
     return memberService.findByEmail(email);  // Recherche un membre par email
 }

 // Gère les requêtes POST pour ajouter un nouvel enseignant chercheur
 @PostMapping("/membres")
 public Member addMembre(@RequestBody EnseignantChercheur m) {
     return memberService.addMember(m);  // Ajoute un enseignant chercheur et le renvoie
 }

 // Gère les requêtes POST pour ajouter un nouvel étudiant
 @PostMapping("/etudiant")
 public Member addEtudiant(@RequestBody Etudiant e) {
     return memberService.addMember(e);  // Ajoute un étudiant et le renvoie
 }

 // Gère les requêtes DELETE pour supprimer un membre par ID
 @DeleteMapping("/membres/{id}")
 public void deleteMembre(@PathVariable Long id) {
     memberService.deleteMember(id);  // Supprime le membre correspondant à l'ID fourni
 }
 
 // Gère les requêtes PUT pour mettre à jour les informations d'un étudiant
 @PutMapping(value = "/etudiant/{id}")
 public Member updateMembre(@PathVariable Long id, @RequestBody Etudiant p) {
     p.setId(id);  // Fixe l'ID avant de mettre à jour
     return memberService.updateMember(p);  // Met à jour et renvoie l'étudiant
 }

 // Gère les requêtes PUT pour mettre à jour les informations d'un enseignant chercheur
 @PutMapping(value = "/membres/enseignant/{id}")
 public Member updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
     p.setId(id);  // Fixe l'ID avant de mettre à jour
     return memberService.updateMember(p);  // Met à jour et renvoie l'enseignant chercheur
 }
 
 @GetMapping("/fullmember/{id}")
 public Member findAFullMember(@PathVariable(name="id") Long id)
 {

 
	 Member mbr= memberService.findMember(id);
     mbr.setPubs(memberService.findPublicationparauteur(id));
     mbr.setEvents(memberService.findEvenementsByMember(id));
     mbr.setOutils(memberService.findOutilsByUser(id));
     return mbr;
 }
//@CrossOrigin
@GetMapping("/fullmembers")
public List<Member> getFullMembers()
{
   List<Member> members = memberService.findAll();
   for ( Member member: members) {
       member.setPubs(memberService.findPublicationparauteur(member.getId()));
       member.setEvents(memberService.findEvenementsByMember(member.getId()));
       member.setOutils(memberService.findOutilsByUser(member.getId()));
   }

   return members;
}

//@CrossOrigin
@GetMapping("/members/numberpublications")
public List<Number> getPublicationsPerMembers()
{
   List<Member> members = memberService.findAll();
   List<Number> nbPubsPerMember = new Vector<>();
   for ( Member member: members) {
       member.setPubs(memberService.findPublicationparauteur(member.getId()));
       nbPubsPerMember.add(member.getPubs().size());
   }

   return nbPubsPerMember;
}

@GetMapping("/members/numberoutils")
public List<Number> getOutilsPerMembers()
{
   List<Member> members = memberService.findAll();
   List<Number> nbOutilsPerMember = new Vector<>();
   for ( Member member: members) {
       member.setOutils(memberService.findOutilsByUser(member.getId()));
       nbOutilsPerMember.add(member.getOutils().size());
   }

   return nbOutilsPerMember;
}


//    @CrossOrigin
@GetMapping("/members/members-per-role")
public Map<String, Number> getNumberMembersPerRole()
{
   List<EnseignantChercheur> enseignants = memberService.getEnseignants();
   List<Etudiant> etudiants = memberService.getEtudiants();
   Map<String, Number> numberPerRole = new HashMap<>();
   numberPerRole.put("enseignant", enseignants.size());
   numberPerRole.put("etudiant", etudiants.size());

   return numberPerRole;
}

@GetMapping("/members/members-per-grade")
public Map<String, Integer> getNumberMembersPerGrade()
{
   return memberService.getNumberMembersPerGrade();

}

@GetMapping("/members/members-per-diplome")
public Map<String, Integer> getNumberMembersPerDiplome()
{
   return memberService.getNumberMembersPerDiplome();

}

@GetMapping("/members/members-per-etablissement")
public Map<String, Integer> getNumberMembersPerEtablissement()
{
   return memberService.getNumberMembersPerEtablissement();

}
@PutMapping("/members/affect-encadrant/{idEnseignant}")
public void affectEtudiantToEncadrant(@RequestBody Long idMember,
                                     @PathVariable(name="idEnseignant") Long idEnseignant){
   memberService.affectEtudiantToEncadrant(idMember,idEnseignant);
}
//@CrossOrigin
@PostMapping("/members/affect-event/{idEvent}")
public void affectMemberToEvent(@RequestBody Long idMember,
                                    @PathVariable(name="idEvent") Long idEvent)
{
   memberService.affecterMemberToEvenement(idMember, idEvent);
}

//@CrossOrigin
@PostMapping("/members/affect-tool/{idTool}")
public void affectMemberToTool(@RequestBody Long idMember,
                               @PathVariable(name="idTool") Long idTool)
{
   memberService.affecterUserToOutil(idMember, idTool);
}

//@CrossOrigin
@PostMapping("/members/affect-pub/{idPub}")
public void affectMemberToPub(@RequestBody Long idMember,
                               @PathVariable(name="idPub") Long idPub)
{
   memberService.affecterAuteurToPublication(idMember, idPub);
}

//@CrossOrigin
@GetMapping("/members/enseignants")
public List<EnseignantChercheur> getEnseignants(){
   return memberService.getEnseignants();
}

//@CrossOrigin
@GetMapping("/members/etudiants")
public List<Etudiant> getEtudiants(){
   return memberService.getEtudiants();
}

@GetMapping("/members/members-outil/{idOutil}")
public Member getMemberByOutil(@PathVariable(name="idOutil") Long idOutil){
   return memberService.findMemberByOutil(idOutil);
}

@GetMapping("/members-per-event/{idEvent}")
public List<Member> getMemberByEvent(@PathVariable (name="idEvent") Long idEvent){
   return memberService.findMembersByEvent(idEvent);
}

@DeleteMapping("/members-per-event/{idEvent}/delete")
public void deleteMemberEventsByEvent(@PathVariable (name="idEvent") Long idEvent){
   memberService.deleteMemberEventsByEventId(idEvent);
}
}
