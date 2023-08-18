package shop.mtcoding.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.ajax.DTO.TechResponse;
import shop.mtcoding.ajax.model.Category;
import shop.mtcoding.ajax.model.CategoryRepository;
import shop.mtcoding.ajax.model.Tech;
import shop.mtcoding.ajax.model.TechRepository;

@Controller
public class TechController {

    @Autowired
    private TechRepository techRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/test/tech/v3")
    public @ResponseBody List<Tech> techV3() {
        List<Tech> techList = techRepository.findByCategoryId(1);
        return techList; // messageconverter 발동 - json 변환
    }

    @GetMapping("/test/tech/v1")
    public @ResponseBody TechResponse.MainDTO techV1() {
        List<Category> categoryList = categoryRepository.findAll();
        List<Tech> techList = techRepository.findByCategoryId(1);
        System.out.println("=================================");
        TechResponse.MainDTO mainDTO = new TechResponse.MainDTO(categoryList, techList);
        return mainDTO; // messageconverter 발동 - json 변환
    }

    @GetMapping("/test/tech/v2")
    public @ResponseBody List<Tech> techV2() {
        // List<Category> CategoryList = categoryRepository.findAll();
        // findByCategoryId() << 직접 만들어야함
        List<Tech> techList = techRepository.findByCategoryId(1);
        // messageconverter 발동해서 json변환
        // Entity를 Getter로 호출하므로 Lazy로드가 실행됨
        return techList;
        // Entity를 호출하지 않고, 필요한 데이터만 뽑아내기 위해서 DTO를 만들어야함
    }

    // 1. 빈 껍데기 디자인을 준다. (데이터 없음)
    @GetMapping("/tech")
    public String tech() {
        System.out.println();
        return "main";
    }

    @GetMapping("/api/category")
    public @ResponseBody List<Category> category() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/tech")
    public @ResponseBody List<Tech> techApi(
            @RequestParam(defaultValue = "2") Integer categoryId) {
        return techRepository.findByCategoryId(categoryId);
    }
}
