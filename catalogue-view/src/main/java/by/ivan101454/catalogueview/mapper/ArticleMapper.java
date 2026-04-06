package by.ivan101454.catalogueview.mapper;

import by.ivan101454.catalogueview.dtos.ArticleDTO;
import by.ivan101454.catalogueview.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    ArticleDTO articleToArticleDTO(Article article);
    Article articleDtoArticle(ArticleDTO articleDTO);

    List<ArticleDTO> articleListToArticleDTOList(List<Article> articles);
}
