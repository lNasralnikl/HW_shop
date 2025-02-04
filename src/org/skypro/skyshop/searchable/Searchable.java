package org.skypro.skyshop.searchable;

public interface Searchable {


    String searchTerm();
    String content();
    default String getStringRepresentation(){
        return content() + " - " + searchTerm();
    }

    default boolean contain(String s){
        return searchTerm().contains(s);
    }

}
