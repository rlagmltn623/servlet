package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
동시성 문제가 고려되어 있지 않음, 실무에서는 concurrentHashMap, AtomicLong 사용고려
*/
public class MemberRepository {
   private static Map<Long, Member> store = new HashMap<>();//데이터 저장을 키 id,
   private static long sequence = 0L;

   //싱글 톤 생성
    private static final MemberRepository instance = new MemberRepository();

    //무족건 얘로 조회 하게 만듬듬
   public static MemberRepository getInstance(){
        return instance;
    }
    //싱글 톤 만들 때 private 막아야함
    private MemberRepository(){

    }

    public Member save(Member member){
       member.setId(++sequence);
       store.put(member.getId(), member);
       return member;
    }

    public Member findByid(Long id){
       return store.get(id);
    }

    public List<Member> findAll(){
       return new ArrayList<>(store.values()); //store에 있는 값을 모두 잡아 준다.
        //store 자체를 보호하기 위해

    }

    public void clearStore(){
       store.clear();

    }
}
