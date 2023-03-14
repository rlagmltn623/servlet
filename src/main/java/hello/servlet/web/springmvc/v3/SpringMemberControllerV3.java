package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members") //이렇게하면  아래에 Mapping 줄일 수 있음
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping(value = "/new-form", method = RequestMethod.GET) // 이렇게만 사용하면 post get 모두 사용되기 때문에 method를 통해 막아야한다.
    @GetMapping("/new-form")
    public String newForm(){
        return  "new-form";
        // return new ModelAndView("new-form"); 기존에 있던 거
    }


    //@RequestMapping(value = "/save", method = RequestMethod.POST) // 데이터를 저장해야 하기 때문에 Post를 사용한다.
    @PostMapping("/save")
    //public ModelAndView Save(HttpServletRequest request, HttpServletResponse response) 기존에 있던거
    public String Save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model){

        Member member = new Member(username,age);
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }

    //@RequestMapping(method = RequestMethod.GET)//단순 조회이기때문에 GET로 한다.
    @GetMapping
    public String List(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
