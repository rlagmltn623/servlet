package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();
    @AfterEach
    void afterEach(){
        memberRepository.clearStore(); //테스트 끝나면 초기화 시켜버림
    }
    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //저장하는거

        //given 이런게 주어졌을 때
        Member member = new Member("hello", 20);

        //when 이런 걸 실행 했을 때
        Member saveMember = memberRepository.save(member);

        //then 결과가 이거야 돼
        Member finMember = memberRepository.findByid(saveMember.getId());
        assertThat(finMember).isEqualTo(saveMember); //둘이 같아야 된다.

    }
    @Test
    void findAll() {
        //저장하는거

        //given 이런게 주어졌을 때
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when 이런 걸 실행 했을 때
        List<Member> result = memberRepository.findAll();

        //then 결과가 이거야 돼
        assertThat(result.size()).isEqualTo(2); //갯수 확인 하는 방법
        assertThat(result).contains(member1, member2); //result 안에 = member1, member2이 있는지
    }


    @Test
    void findByid() {
    }


    @Test
    void clearStore() {
    }
}