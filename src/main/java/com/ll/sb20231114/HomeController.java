package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 컨트롤러 입니다.
public class HomeController {

    @GetMapping("/")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showMain() {
        System.out.println("안녕하세요!!!");
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b) {
        // 스프링부트에선 값이 제공되지 않을 때 null을 넣는다
        // 하지만 원시 변수형엔 null을 넣을 수 없어 오류가 난다.
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b) {
        return "a : " + a + ", b : " + b;
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            // url의 내용은 무조건 문자열이기 때문에 defaultValue는 무조건 문자로 넣어야한다.
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b
    ) {
        return "계산 결과 : %d".formatted(a + b) + " a : " + a + ", b : " + b;
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            //
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산 결과 : %f".formatted(a + b) + " a : " + a + ", b : " + b;
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            //
            @RequestParam(defaultValue = "0") String a,
            @RequestParam(defaultValue = "0") String b
    ) {
        return "계산 결과 : %f".formatted(a + b) + " a : " + a + ", b : " + b;
    }
}
