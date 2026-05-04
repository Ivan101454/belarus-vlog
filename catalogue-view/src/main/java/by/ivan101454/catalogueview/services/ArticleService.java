package by.ivan101454.catalogueview.services;

import by.ivan101454.catalogueview.dtos.ArticleDTO;
import by.ivan101454.catalogueview.dtos.ArticlePayload;
import by.ivan101454.catalogueview.entities.Article;

import java.util.List;

public interface ArticleService {

    List<ArticleDTO> findAll();

    void createArticle(ArticlePayload articlePayload);
}
