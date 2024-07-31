package com.maven.springboot.mymustache.category;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.UriEncoder;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/catweb")
public class CateWebController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("")
    public String indexHome() {
        return "index";
    }

    @GetMapping("/category_list")
    public String categoryList(Model model, @RequestParam int page, @RequestParam String searchName) {
        try {
            SearchCategoryDto searchCategoryDto = SearchCategoryDto.builder()
                    .page(page).searchName(searchName).build();
            int total = this.categoryService.countAllByNameContains(searchCategoryDto);
            List<ICategory> list = this.categoryService.findAllByNameContains(searchCategoryDto);
            searchCategoryDto.setTotal(total);
            model.addAttribute("categoryList", list);
            model.addAttribute("searchCategoryDto", searchCategoryDto);
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return "catweb/category_list";
    }


    @GetMapping("/category_add")
    public String categoryAdd(Model model) {
        try {

        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return "catweb/category_add";
    }

    @PostMapping("/category_insert")
    public String categoryInsert(@ModelAttribute CategoryDto dto, Model model) {
        try {
            if (dto.getName() == null || dto.getName().isEmpty()) {
                model.addAttribute("error_message", "이름은 비어있을 수 없습니다.");
                return "error/error_bad";
            }
            this.categoryService.insert(dto);

        } catch (Exception ex) {
            log.error(ex.toString());
            model.addAttribute("error_message", dto.getName()+"중복입니다.");
            return "error/error/bad";
        }
        return "redirect:category_list?page=1&searchName=";  // 브라우저 주소를 redirect 한다.
    }

    @GetMapping("/category_view")    // 브라우저의 URL 주소
    public String categoryOldView(Model model, @RequestParam Long id) {
        try {
            if (id == null || id <= 0) {
                model.addAttribute("error_message", "ID는 1보다 커야 합니다.");
                return "error/error_bad";  // resources/templates 폴더안의 화면파일
            }
            ICategory find = this.categoryService.findById(id);
            if (find == null) {
                model.addAttribute("error_message", id + " 데이터가 없습니다.");
                return "error/error_find";
            }
            model.addAttribute("categoryDto", find);
        } catch (Exception ex) {
            log.error(ex.toString());
            model.addAttribute("error_message", "서버 에러입니다. 관리자에게 문의 하세요.");
            return "error/error_save";  // resources/templates 폴더안의 화면파일
        }
        return "catweb/category_view";     //resources/templates 폴더안의 화면파일 찾음
    }

    @GetMapping("/category_delete")
    public String categoryDelete(Model model, @RequestParam Long id) {
        try {
            if (id == null || id <= 0) {
                model.addAttribute("error_message", "id는 1보다 커야 합니다.");
                return "error/error_bad";  // resources/templates 폴더안의 화면파일
            }
            ICategory find = this.categoryService.findById(id);
            if (find == null) {
                model.addAttribute("error_message", id + " 데이터가 없습니다.");
                return "error/error_find";
            }
            this.categoryService.delete(id);
        } catch (Exception ex) {
            log.error(ex.toString());
            model.addAttribute("error_message", "서버 에러입니다. 관리자에게 문의 하세요.");
            return "error/error_save";  // resources/templates 폴더안의 화면파일
        }
        return "redirect:category_list?page=1&searchName=";
    }

    @PostMapping("/category/update")
    public String categoryUpdate(Model model, @ModelAttribute CategoryDto dto) throws Exception {
        try {
            if (dto == null || dto.getId() <= 0 || dto.getName().isEmpty()) {
                model.addAttribute("error_message", "id는 1보다 커야하고, name 이 있어야 합니다.");
                return "error/error_bad";  // resources/templates 폴더안의 화면파일
            }
            ICategory find = this.categoryService.findById(dto.getId());
            if (find == null) {
                model.addAttribute("error_message", dto.getId() + " 데이터가 없습니다.");
                return "error/error_find";
            }
            this.categoryService.update(dto.getId(), dto);
        } catch (Exception ex) {
            log.error(ex.toString());
            model.addAttribute("error_message", dto.getName() + " 중복입니다.");
            return "error/error_save";  // resources/templates 폴더안의 화면파일
        }
        return "redirect:/catweb/category_list?page=1&searchName=";
    }


}
