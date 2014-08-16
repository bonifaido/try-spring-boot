package me.nandork.simple.parser;

import me.nandork.simple.model.Article;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ConditionalOnProperty("crawler.index.hu")
public class IndexHuArticleParser implements ArticleParser {

    @Override
    public List<Article> apply(Element body) {
        Elements articles = body.select("article");
        return articles.stream().map(article -> {
            String title = body.select("a").text();
            String text = body.select("span").text();
            return new Article(title, text);
        }).collect(Collectors.toList());
    }
}
