package com.maven.springboot.mymustache.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j  // log를 만들어 준다
@Controller // Web용 Controller이다. 화면을 리턴하거나 redirect 할 때 유용하다
@RequestMapping("/catajx")   // Controller가 요청받는 url 앞부분이다.
public class CategoryAjxController {

    @GetMapping("category_ajx_list")
    // GET method로 /catajx/~~~~~~~~~ url 주소로 접속하면 해당 메소드가 실행한다.
    public String category_ajx_list() {
        return "catajx/category_ajx_list";
        //화면 템플릿 엔진의 화면파일경로/화면파일명
    }
}
