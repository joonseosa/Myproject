package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //entity manager 는 entity를 저장,조회,수정,삭제 가능하게함
    private final EntityManager em;


    //삽입
    public void save(Member member){
        em.persist(member);
    }

    //단건조회
    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    //전체조회
    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }

    // 이름으로 선택조회
    public  List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name=:name",Member.class)
                .setParameter("name",name)
                .getResultList();

    }


}
