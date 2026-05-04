package by.ivan101454.catalogueview.mapper;

import by.ivan101454.catalogueview.dtos.ArticleDTO;
import by.ivan101454.catalogueview.dtos.ArticlePayload;
import by.ivan101454.catalogueview.dtos.AuthorDTO;
import by.ivan101454.catalogueview.entities.Article;
import by.ivan101454.catalogueview.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    ArticleDTO articleToArticleDTO(Article article);
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "publishDate", ignore = true)
    @Mapping(target = "content", ignore = true)
    Article articleDtoArticle(ArticleDTO articleDTO);

    AuthorDTO authorToAuthorDTO(Author author);
    @Mapping(target = "authorId", ignore = true)
    Author authorDtoAuthor(AuthorDTO authorDTO);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "publishDate", ignore = true)
    Article articlePayloadtoArticle(ArticlePayload articlePayload);

    List<ArticleDTO> articleListToArticleDTOList(List<Article> articles);
}
