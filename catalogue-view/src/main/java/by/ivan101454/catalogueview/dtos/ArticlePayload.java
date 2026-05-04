package by.ivan101454.catalogueview.dtos;

import by.ivan101454.catalogueview.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArticlePayload(@NotBlank String title,@Size(min = 10, max = 60) String description,
                             @NotNull String content, @NotNull String imageName, @NotNull Category category) {
}
