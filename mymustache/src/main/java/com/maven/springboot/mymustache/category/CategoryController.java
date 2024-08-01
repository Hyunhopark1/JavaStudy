package com.maven.springboot.mymustache.category;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j  // log를 만들어준다.
@RestController // Restfull API 용 Controller이다. JSON 문자형식으로 요청/응답 한다.
@RequestMapping("/ct") // 컨트롤러가 처리할 url의 앞부분
public class CategoryController {

    @Autowired  //Springboot가  CategoryServiceImpl 데이터형으로 객체를 자동 생성
//    private CategoryServiceImpl categoryService;
    private CategoryServiceImpl categoryService;

    @PostMapping  //POST method , url : /ct
    public ResponseEntity<ICategory> insert(@RequestBody CategoryDto dto) {
        try {
            if ( dto == null ) {
                return ResponseEntity.badRequest().build();
            }
            ICategory result = this.categoryService.insert(dto);
            if ( result == null ) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ICategory>> getAll() {
        try {
            List<ICategory> result = this.categoryService.getAllList();
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            if ( id == null ) {
                return ResponseEntity.badRequest().build();
            }
            Boolean result = this.categoryService.delete(id);
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ICategory> update(@PathVariable Long id, @RequestBody CategoryDto dto) {
        try {
            if ( id == null || dto == null ) {
                return ResponseEntity.badRequest().build();
            }
            ICategory result = this.categoryService.update(id, dto);
            if ( result == null ) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ICategory> findById(@PathVariable Long id) {
        try {
            if ( id == null || id <= 0 ) {
                return ResponseEntity.badRequest().build();
            }
            ICategory result = this.categoryService.findById(id);
            if ( result == null ) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/nm/{searchName}")
    public ResponseEntity<List<ICategory>> findAllByNameContains(@PathVariable String searchName) {
        try {
            if ( searchName == null || searchName.isEmpty() ) {
                return ResponseEntity.badRequest().build();
            }
            SearchCategoryDto searchCategoryDto = SearchCategoryDto.builder()
                    .searchName(searchName).page(1).build();
            List<ICategory> result = this.categoryService.findAllByNameContains(searchCategoryDto);
            if ( result == null || result.size() <= 0 ) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/searchName")
    public ResponseEntity<SearchCategoryDto> findAllByNameContains(@RequestBody SearchCategoryDto searchCategoryDto) {
        try {
            if ( searchCategoryDto == null ) {
                return ResponseEntity.badRequest().build();
            }
            int total = this.categoryService.countAllByNameContains(searchCategoryDto);
            List<ICategory> list = this.categoryService.findAllByNameContains(searchCategoryDto);
            if ( list == null ) {
                return ResponseEntity.notFound().build();
            }
            searchCategoryDto.setTotal(total);
            searchCategoryDto.setDataList(list);
            return ResponseEntity.ok(searchCategoryDto);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/countName")
    public ResponseEntity<Integer> countAllByNameContains(@RequestBody SearchCategoryDto searchCategoryDto) {
        try {
            if ( searchCategoryDto == null ) {
                return ResponseEntity.badRequest().build();
            }
            int total = this.categoryService.countAllByNameContains(searchCategoryDto);
            return ResponseEntity.ok(total);
        } catch ( Exception ex ) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
