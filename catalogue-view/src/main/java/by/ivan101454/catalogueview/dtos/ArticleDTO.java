package by.ivan101454.catalogueview.dtos;

import by.ivan101454.catalogueview.enums.Category;

public record ArticleDTO(String title, String description, String imageName, Category category) {
}
