package fr.univrouen.projetXML.repository;

import fr.univrouen.projetXML.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
