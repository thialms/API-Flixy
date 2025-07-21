package br.com.flixy.mapper;

import br.com.flixy.controller.request.CategoryRequest;
import br.com.flixy.controller.response.CategoryResponse;
import br.com.flixy.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
