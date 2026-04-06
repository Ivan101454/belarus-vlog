package by.ivan101454.catalogueview.controllers;

import by.ivan101454.catalogueview.dtos.ArticleDTO;
import by.ivan101454.catalogueview.entities.Article;
import by.ivan101454.catalogueview.services.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/catalogue-view/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String ListArticles(Model model) {
        List<ArticleDTO> articles = articleService.findAll();
        log.info("Listing articles" + articles);
        model.addAttribute("articles", articles);
        return "catalogue/list";
    }
}
