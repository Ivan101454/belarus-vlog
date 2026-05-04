package by.ivan101454.catalogueview.controllers;

import by.ivan101454.catalogueview.dtos.ArticleDTO;
import by.ivan101454.catalogueview.dtos.ArticlePayload;
import by.ivan101454.catalogueview.entities.Article;
import by.ivan101454.catalogueview.entities.Author;
import by.ivan101454.catalogueview.enums.Category;
import by.ivan101454.catalogueview.mapper.ArticleMapper;
import by.ivan101454.catalogueview.services.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = ArticlesController.class)
class ArticlesControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    ArticleService articleService;

    private final ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);

    private final List<Article> ARTICLES = new ArrayList<>(List.of(
            new Article("sky-river-2026", new Author(UUID.randomUUID(), "I.Sapozhnikov"), LocalDate.of(2026, 3, 28),
                    "Attending the new art exhibition", "sky-river-2026.md",
                    "art-activities-in-jungle.webp", Category.ART),
            new Article("easter-cake-2026", new Author(UUID.randomUUID(), "I.Sapozhnikov"), LocalDate.of(2026, 4, 3),
                    "Preparing for Easter", "cooking-easter-cake-2026.md",
                    "easter-cake.jpg", Category.EVENTS)
    ));

    @Test
    @DisplayName("Should return list of articles and correct view name")
    void shouldReturnListOfArticles() throws Exception {

        //given
        List<ArticleDTO> articleDTOS = articleMapper.articleListToArticleDTOList(ARTICLES);

        //when
        when(articleService.findAll()).thenReturn(articleDTOS);


        //then
        mockMvc.perform(get("/catalogue-view/article/list"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("articles", articleDTOS));
    }

    @Test
    void shouldReturnCreateForm() throws Exception {
        //given


        //when

        //then
        mockMvc.perform(get("/catalogue-view/article/list/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("catalogue/create"));

    }

    @Test
    void createArticle_ValidPayload_makeRedirect() throws Exception {
        //given
        String title = "New Article";
        String description = "New Article Description";
        String content = "New Article Content";
        String category = "EVENTS";
        //when

        //then
        mockMvc.perform(post("/catalogue-view/article/list/create")
                .param("title",title)
                .param("description", description)
                .param("content", content)
                .param("category", category))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/catalogue-view/article/list"));

        verify(articleService, times(1)).createArticle(any(ArticlePayload.class));
    }
}