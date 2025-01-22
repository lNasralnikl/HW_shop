package org.skypro.skyshop.searchable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEngine {

    private final List<Searchable> searchables = new ArrayList<>();
    private final List<Searchable> searched = new ArrayList<>();

    //Добавление в поиск
    public void add(Searchable object) {
        searchables.add(object);
        }

    //Поиск по наименованию
    public void search(String search){
        int searchablesSize = searchables.size();
        List<Integer> searchCounts = new ArrayList<>();
        for (int i = 0; i < searchablesSize; i++){
            String test = searchables.get(i).searchTerm();
            if(test != null && test.toLowerCase().contains(search.toLowerCase()) && !test.isBlank() && !search.trim().isEmpty()){
                searchCounts.add(i);
            }
        }
        System.out.println("Результаты поиска '" + search + "':");
        if (!searchCounts.isEmpty()) {
            for(int i = 0; i < searchCounts.size(); i++){
                searched.add(searchables.get(searchCounts.get(i)));
            }
            System.out.println(searched + "\n");
        }else{
            System.out.println("Ничего не найдено\n");
        }
    }

}
