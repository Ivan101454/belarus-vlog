package by.ivan101454.catalogueview.controllers;

import by.ivan101454.catalogueview.dtos.ArticleDTO;
import by.ivan101454.catalogueview.dtos.ArticlePayload;
import by.ivan101454.catalogueview.services.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/catalogue-view/article/list")
@RequiredArgsConstructor
public class ArticlesController {

    private final ArticleService articleService;

    @GetMapping
    public String listArticles(Model model) {
        List<ArticleDTO> articles = articleService.findAll();
        log.info("Listing articles" + articles);
        model.addAttribute("articles", articles);
        return "catalogue/list";
    }

    @GetMapping("/create")
    public String createArticle() {
        return "catalogue/create";
    }

    @PostMapping("/create")
    public String createArticle(@ModelAttribute ArticlePayload articlePayload) {
        articleService.createArticle(articlePayload);
        return "redirect:/catalogue-view/article/list";
    }

}
