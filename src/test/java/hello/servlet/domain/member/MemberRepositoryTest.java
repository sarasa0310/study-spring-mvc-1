package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("회원 저장")
    void save() {
        // given
        Member member = new Member("jimmy", 20);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(memberRepository.findById(savedMember.getId())).isEqualTo(savedMember);
    }

    @Test
    @DisplayName("모두 조회")
    void findAll() {
        // given
        Member member1 = new Member("jimmy", 20);
        Member member2 = new Member("dabin", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> actual = memberRepository.findAll();

        // then
        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual).contains(member1, member2);
    }

}