package org.skypro.skyshop.searchable;

import java.util.*;

public class SearchEngine {

    //private final List<Searchable> searchables = new ArrayList<>();
    private final List<Searchable> searched = new ArrayList<>();
    private final Map<String, List<Searchable>> searchables = new TreeMap<>();


    //Добавление в поиск
    public void add(Searchable object) {
        if (!searchables.containsKey(object.searchTerm())) {
            searchables.put(object.searchTerm(), new ArrayList<>());
        }
        searchables.get(object.searchTerm()).add(object);
    }


    //Добить Карту, посмотреть тип для сортировки

    //Поиск по наименованию через дерево
    public void search(String search) {

        boolean searchFounded = true;

        if (search.isBlank() || search.isEmpty()) {
            return;
        }
        System.out.println("Результаты поиска '" + search + "':");
        for (Map.Entry m : searchables.entrySet()) {

            if (m.getKey().toString().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(m.getKey() + " " + m.getValue());
            }
        }
        System.out.println();
    }


    //Поиск по наименованию старый
    /*
    public void search(String search) {
        int searchablesSize = searchables.size();
        List<Integer> searchCounts = new ArrayList<>();
        for (int i = 0; i < searchablesSize; i++) {
            String test = searchables.get(i).searchTerm();
            if (test != null && test.toLowerCase().contains(search.toLowerCase()) && !test.isBlank() && !search.trim().isEmpty()) {
                searchCounts.add(i);
            }
        }
        System.out.println("Результаты поиска '" + search + "':");
        if (!searchCounts.isEmpty()) {
            for (int i = 0; i < searchCounts.size(); i++) {
                searched.add(searchables.get(searchCounts.get(i)));
            }
            System.out.println(searched + "\n");
        } else {
            System.out.println("Ничего не найдено\n");
        }
    }

     */

}
