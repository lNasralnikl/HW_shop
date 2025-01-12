package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public final class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString(){
        return title + "\n" + text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String content() {
        return "Article";
    }
}
