package org.skypro.skyshop.searchable;

import java.util.Arrays;

public class SearchEngine {

    private final Searchable[] searchables;
    private final int maxSearcheQuantity;
    private int objectNum;

    public SearchEngine(int maxSearcheQuantity) {
        this.searchables = new Searchable[maxSearcheQuantity];
        this.maxSearcheQuantity = maxSearcheQuantity;
    }

    public void add(Searchable object) {
        if (objectNum >= maxSearcheQuantity) {
            System.out.println("Массив заполнен");
        } else {
            searchables[objectNum] = object;
            objectNum++;
        }
    }

    public void search(String search) {
        Searchable[] result = new Searchable[searchables.length];
        int x = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].contain(search)) {
                result[x] = searchables[i];
                x++;
            }
        }
        Searchable[] printResult = new Searchable[x];
        for (int i = 0; i < x; i++){
            printResult[i] = result[i];
        }

        System.out.println(Arrays.toString(printResult));
    }

}
