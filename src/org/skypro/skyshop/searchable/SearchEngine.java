package org.skypro.skyshop.searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> searchables = new TreeSet<>(new ReverseStringComparator());

    public static class ReverseStringComparator implements Comparator<Searchable> {

        @Override
        public int compare(Searchable o1, Searchable o2) {
            int first = o1.searchTerm().length();
            int second = o2.searchTerm().length();
            if (first == second) {
                return o1.searchTerm().compareTo(o2.searchTerm());
            } else {
                return Integer.compare(second, first);
            }
        }

    }

    //Добавление в поиск
    public void add(Searchable object) {
        searchables.add(object);
    }

    //Поиск по наименованию
    public void search(String search) {

        if (search.isBlank() || search.isEmpty()) {
            throw new IllegalArgumentException("Предмет поиска не может быть пустым или состоять из пробелов");
        }
        System.out.println("Результаты поиска '" + search + "':");
        List<Searchable> founded = searchables.stream()
                .filter(searchable -> searchable.searchTerm().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));

        if (founded.isEmpty()) {
            System.out.println("Ничего не найдено\n");
        } else {
            founded.forEach(n -> System.out.println(n.content() + ": " + n.searchTerm()));
        }
        System.out.println();
    }

}
