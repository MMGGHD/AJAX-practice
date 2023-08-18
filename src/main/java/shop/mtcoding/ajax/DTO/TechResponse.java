package shop.mtcoding.ajax.DTO;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.ajax.DTO.TechResponse.MainDTO.TechDTO;
import shop.mtcoding.ajax.model.Category;
import shop.mtcoding.ajax.model.Tech;

public class TechResponse {

    // MainDTO << 들고있어야할 데이터가 2건
    // CategoryDTO 조회값을 받고
    // TechDTO 조회값을 받아서 MainDTO에 넣는다.
    @Getter
    @Setter
    public static class MainDTO {
        private List<CategoryDTO> categories;
        private List<TechDTO> techs;

        public MainDTO(List<Category> categories, List<Tech> techs) {
            this.categories = categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
            this.techs = techs.stream().map(TechDTO::new).collect(Collectors.toList());
        }

        @Getter
        @Setter
        public class CategoryDTO {
            private Integer id;
            private String name;

            public CategoryDTO(Category category) {
                this.id = category.getId();
                this.name = category.getName();
            }
        }

        @Getter
        @Setter
        public class TechDTO {
            private Integer id;
            private String name;

            public TechDTO(Tech tech) {
                this.id = tech.getId();
                this.name = tech.getName();
            }
        }
    }

}
