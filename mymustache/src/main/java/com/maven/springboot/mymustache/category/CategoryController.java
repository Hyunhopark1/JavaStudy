package com.maven.springboot.mymustache.category;


import com.maven.springboot.mymustache.SearchAjaxDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j  // log 를 만들어 준다.
@RestController // RestFul API 용 Controller 이다. JSON 문자형식으로 요청/응답 한다.
@RequestMapping("/ct")  // Controller 의 url 앞부분이다.
public class CategoryController {
    @Autowired  // SpringBoot 가 CategoryServiceImpl 데이터형으로 객체를 자동 생성한다.
    private CategoryServiceImpl categoryService;

    @PostMapping    // POST method : /ct
    public ResponseEntity<ICategory> insert(@RequestBody CategoryDto dto) {
        // ResponseEntity<데이터형> : http 응답을 http 응답코드와 리턴데이터형으로 묶어서 응답한다.
        // @RequestBody CategoryDto dto : JSON 문자열로 요청을 받는다.
        //      다만 JSON 문자열의 데이터가 CategoryDto 데이터형이어야 한다.
        try {
            if ( dto == null ) {
                return ResponseEntity.badRequest().build(); // error 응답
            }
            ICategory result = this.categoryService.insert(dto);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            if ( result == null ) {
                return ResponseEntity.badRequest().build(); // error 응답
            }
            return ResponseEntity.ok(result);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }

    @GetMapping     // GET method : /ct
    public ResponseEntity<List<ICategory>> getAll() {
        // ResponseEntity<데이터형> : http 응답을 http 응답코드와 리턴데이터형으로 묶어서 응답한다.
        // List<ICategory> 데이터형 리턴은 배열 데이터를 JSON 문자열로 표현하여 리턴한다.
        // [{"id":값, "name":"값"}, {"id":값, "name":"값"}, {"id":값, "name":"값"}, ...]
        try {
            List<ICategory> result = this.categoryService.getAllList();
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            return ResponseEntity.ok(result);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }

    @DeleteMapping("/{id}")     // DELETE method : /ct/번호
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        // ResponseEntity<데이터형> : http 응답을 http 응답코드와 리턴데이터형으로 묶어서 응답한다.
        // @PathVariable Long id : URL 주소의 /ct/번호 => {id} id 변수의 값으로 요청된다.
        try {
            if ( id == null ) {
                return ResponseEntity.badRequest().build();// error 응답
            }
            Boolean result = this.categoryService.delete(id);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            return ResponseEntity.ok(result);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }

    @PatchMapping("/{id}")     // PATCH method : /ct/번호
    public ResponseEntity<ICategory> update(@PathVariable Long id, @RequestBody CategoryDto dto) {
        // ResponseEntity<데이터형> : http 응답을 http 응답코드와 리턴데이터형으로 묶어서 응답한다.
        // @PathVariable Long id : URL 주소의 /ct/번호 => {id} id 변수의 값으로 요청된다.
        // @RequestBody CategoryDto dto : JSON 문자열로 요청을 받는다.
        //      다만 JSON 문자열의 데이터가 CategoryDto 데이터형이어야 한다. {"id":값, "name":"값"}
        try {
            if ( id == null || dto == null ) {
                return ResponseEntity.badRequest().build(); // error 응답
            }
            ICategory result = this.categoryService.update(id, dto);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            if ( result == null ) {
                return ResponseEntity.notFound().build(); // error 응답
            }
            return ResponseEntity.ok(result);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ICategory> findById(@PathVariable Long id) {
        try {
            if ( id == null || id <= 0 ) {
                return ResponseEntity.badRequest().build(); // error 응답
            }
            ICategory result = this.categoryService.findById(id);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            if ( result == null ) {
                return ResponseEntity.notFound().build(); // error 응답
            }
            return ResponseEntity.ok(result);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }

    @GetMapping("/nm/{searchName}") // POST method : /ct/nm/문자열{searchName}
    public ResponseEntity<List<ICategory>> findAllByNameContains(@PathVariable String searchName) {
        // ResponseEntity<데이터형> : http 응답을 http 응답코드와 리턴데이터형으로 묶어서 응답한다.
        // List<ICategory> 데이터형 리턴은 배열 데이터를 JSON 문자열로 표현하여 리턴한다.
        // @PathVariable String searchName : URL 주소의 /ct/nm/문자열 => {searchName} searchName 변수의 값으로 요청된다.
        try {
            if ( searchName == null || searchName.isEmpty() ) {
                return ResponseEntity.badRequest().build(); // error 응답
            }
            SearchAjaxDto searchAjaxDto = SearchAjaxDto.builder()
                    .searchName(searchName).page(1).build();
            List<ICategory> result = this.categoryService.findAllByNameContains(searchAjaxDto);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            // findAllByNameContains 쿼리 문장을 만들때 orderByWord, searchName, rowsOnePage, firstIndex 값을
            // 활용하여 쿼리 문장을 만들고 실행한다.
            if ( result == null || result.size() <= 0 ) {
                return ResponseEntity.notFound().build(); // error 응답
            }
            return ResponseEntity.ok(result);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }

    @PostMapping("/searchName") // POST method : /ct/searchName
    public ResponseEntity<SearchAjaxDto> findAllByNameContains(@RequestBody SearchAjaxDto searchAjaxDto) {
        // ResponseEntity<데이터형> : http 응답을 http 응답코드와 리턴데이터형으로 묶어서 응답한다.
        // SearchAjaxDto 데이터형를 JSON 문자열로 표현하여 리턴한다.
        // @RequestBody SearchAjaxDto searchAjaxDto : JSON 문자열로 요청을 받는다.
        //      다만 JSON 문자열의 데이터가 SearchAjaxDto 데이터형이어야 한다.
        //      {"searchName":"값", "sortColumn":"값", "sortAscDsc":"값", "page":값}
        try {
            if ( searchAjaxDto == null ) {
                return ResponseEntity.badRequest().build();
            }
            int total = this.categoryService.countAllByNameContains(searchAjaxDto);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            // 검색식의 searchName 으로 찾은 데이터 행수를 리턴받는다. 화면의 페이지 계산에 사용된다.
            List<ICategory> list = this.categoryService.findAllByNameContains(searchAjaxDto);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            // findAllByNameContains 쿼리 문장을 만들때 orderByWord, searchName, rowsOnePage, firstIndex 값을
            // 활용하여 쿼리 문장을 만들고 실행한다.
            if ( list == null ) {
                return ResponseEntity.notFound().build(); // error 응답
            }
            searchAjaxDto.setTotal(total);
            // SearchAjaxDto 응답결과에 total 을 추가한다.
            searchAjaxDto.setDataList(list);
            // SearchAjaxDto 응답결과에 List<ICategory> 을 추가한다.
            return ResponseEntity.ok(searchAjaxDto);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }

    @PostMapping("/countName")  // POST method : /ct/countName
    public ResponseEntity<Integer> countAllByNameContains(@RequestBody SearchAjaxDto searchAjaxDto) {
        // ResponseEntity<데이터형> : http 응답을 http 응답코드와 리턴데이터형으로 묶어서 응답한다.
        // @RequestBody SearchAjaxDto searchAjaxDto : JSON 문자열로 요청을 받는다.
        //      다만 JSON 문자열의 데이터가 SearchAjaxDto 데이터형이어야 한다.
        //      {"searchName":"값"}
        try {
            if ( searchAjaxDto == null ) {
                return ResponseEntity.badRequest().build(); // error 응답
            }
            int total = this.categoryService.countAllByNameContains(searchAjaxDto);
            // 최종 목적지인 Mybatis 쿼리를 DB 에 실행하고 결과를 리턴 받는다.
            // countAllByNameContains 쿼리 문장을 만들때 searchName 값을 활용하여 쿼리 문장을 만들고 실행한다.
            // 데이터 행수를 리턴한다.
            return ResponseEntity.ok(total);
            // 200 OK 와 result 데이터를 응답한다.
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build(); // error 응답
        }
    }
}
