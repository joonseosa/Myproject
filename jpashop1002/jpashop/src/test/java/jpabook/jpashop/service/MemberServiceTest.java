package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception{

        //given (주어진 조건)
        Member member = new Member();
        member.setName("Seo");

        //when (이렇게하면~ )
        Long saveId=memberService.join(member);


        //then  (이렇게 된다~)
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));



    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("Seo");

        Member member2 = new Member();
        member2.setName("Seo");

        //when
        memberService.join(member1);
        memberService.join(member2);     // 이름이 같은 seo 이기때문에 중복 예외처리 발생


        //then
        fail("예외가 발생해야합니다");





    }




}