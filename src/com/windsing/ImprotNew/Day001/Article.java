package com.windsing.ImprotNew.Day001;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fch96 on 2017/4/12.
 */
public class Article {
    private String title;
    private String autor;
    private List<String> tags;

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public List<String> getTags() {
        return tags;
    }

    private Article(String title,String autor,List<String> tags){
        this.title = title;
        this.autor = autor;
        this.tags = tags;
    }

    List<Article> articles = new ArrayList<Article>();
    public Article getFirstJavaArticle(){
        for(Article article:articles){
            if(article.getTags().contains("Java")){
                return article;
            }
        }
        return null;
    }

}
