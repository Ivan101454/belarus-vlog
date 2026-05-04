package by.ivan101454.catalogueview.entities;

import by.ivan101454.catalogueview.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article {

    private String title;
    private Author author;
    private LocalDate publishDate;
    private String description;
    private String content;
    private String imageName;
    private Category category;
}
