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
 HW5_List
        System.out.println("Результаты поиска '" + search + "':");
        if (!searchCounts.isEmpty()) {
            for(int i = 0; i < searchCounts.size(); i++){
                searched.add(searchables.get(searchCounts.get(i)));
            }
            System.out.println(searched + "\n");
        }else{
            System.out.println("Ничего не найдено\n");

        Searchable[] printResult = new Searchable[x];
 HW4
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

        for (int i = 0; i < x; i++){
            printResult[i] = result[i];>>>>>>> master
        }
    }

 master
}
