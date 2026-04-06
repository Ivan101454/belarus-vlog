package by.ivan101454.catalogueview.services;

import by.ivan101454.catalogueview.dtos.ArticleDTO;
import by.ivan101454.catalogueview.entities.Article;
import by.ivan101454.catalogueview.mapper.ArticleMapper;
import by.ivan101454.catalogueview.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceDefault implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<ArticleDTO> findAll() {
        return ArticleMapper.INSTANCE.articleListToArticleDTOList(articleRepository.findAllArticles());
    }
}
