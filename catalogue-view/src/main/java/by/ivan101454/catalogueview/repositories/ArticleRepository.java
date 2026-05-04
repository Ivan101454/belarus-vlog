package by.ivan101454.catalogueview.repositories;

import by.ivan101454.catalogueview.entities.Article;

import java.util.List;

public interface ArticleRepository {

    List<Article> findAllArticles();

    void save(Article article);
}
