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
        System.arraycopy(result, 0, printResult, 0, x);
        System.out.println(Arrays.toString(printResult));
    }

    public void getSearchTerm(String search) {
        int maxCount = 0;
        Searchable searchObject = null;
        int count;
        String str;
        String subStr = search.toLowerCase();
        for (int i = 0; i < searchables.length; i++) {
            str = searchables[i].searchTerm().toLowerCase();
            count = getMaxCount(str, subStr);
            if (count > maxCount) {
                maxCount = count;
                searchObject = searchables[i];
            }
        }
        if (searchObject != null) {
            System.out.println(searchObject);
        } else {

            try {
                if (searchObject == null) {
                    throw new IllegalArgumentException("BestResultNotFound");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("BestResultNotFound");

            }

        }


    }

    public int getMaxCount(String str, String subStr) {
        int count = 0;
        int index = 0;
        int indexSub = str.indexOf(subStr, index);

        while (indexSub != -1) {
            count++;
            index += subStr.length();
            indexSub = subStr.indexOf(str, index);
        }
        return count;
    }

    /*
    public void getSearchTerm(String substring) {
        String str;

        int maxCount = 0;
        Searchable object = null;

        for (int i = 0; i < searchables.length; i++) {

            int count = 0;
            int index = 0;
            int indSub = 0;

            str = searchables[i].searchTerm();

            while (indSub != -1) {
                count++;
                index += substring.length();
                indSub = substring.indexOf(str, index);
            }

            if (count > maxCount) {
                maxCount = count;
                object = searchables[i];
            }

        }
        if (object == null) {
            System.out.println("Поиск не дал результатов");
        } else {
            System.out.println(object);
        }
    }
*/
}
