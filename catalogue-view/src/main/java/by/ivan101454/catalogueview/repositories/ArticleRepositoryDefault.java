package by.ivan101454.catalogueview.repositories;

import by.ivan101454.catalogueview.entities.Article;
import by.ivan101454.catalogueview.enums.Category;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepositoryDefault implements ArticleRepository {

    private final static List<Article> articles = List.of(
            new Article("sky-river-2026", "I.Sapozhnikov", LocalDate.of(2026, 3, 28),
                    "Attending the new art exhibition", "sky-river-2026.md",
                    "art-activities-in-jungle.webp", Category.ART),
            new Article("easter-cake-2026", "I.Sapozhnikov", LocalDate.of(2026, 4, 3),
                    "Preparing for Easter", "easter-2026.md",
                    "cottage-mixture-for-cakes.jpg", Category.EVENTS)
    );

    @Override
    public List<Article> findAllArticles() {
        return articles;
    }
}
