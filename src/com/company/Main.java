package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, String[]> dictionary = new HashMap<>();


        dictionary.put("работать", new String[]{"делать", "трудиться", "заниматься",
                "мучиться", "коптеть", "корпеть",
                "возиться", "заниматься", "служить",
                "вкалывать", "впахивать", "действовать"});

        dictionary.put("радость", new String[]{"восторг", "упоение", "отрада",
                "веселье", "ликование",
                "жизнерадостность", "забава", "потеха",
                "утеха", "развлечение", "увеселение"});

        dictionary.put("учиться", new String[]{"зубрить", "научиться", "узнавать",
                "прочитывать", "твердить", "готовиться",
                "нахватывать", "изучать", "усваивать"});

        dictionary.put("плакать", new String[]{"вопеть", "рыдать", "реветь",
                "скулить", "хлипать", "хныкать",
                "кантата", "кантата", "ария"});

        dictionary.put("имя", new String[]{"название", "прозвище",
                "идентификация", "звание", "известность", "признание",});

        Set<String> setKey = dictionary.keySet();
        List<String> arrayListOfSynonyms = new ArrayList<>();
        Map<String, String[]> dictionary0 = new HashMap<>();

        for (String key : setKey) {
            
            Collections.addAll(arrayListOfSynonyms, dictionary.get(key));

            for (int i = 0; i < arrayListOfSynonyms.size(); i++) {
                String newKey = arrayListOfSynonyms.get(i);
                arrayListOfSynonyms.remove(i);
                arrayListOfSynonyms.add(key);

                Object[] o = arrayListOfSynonyms.toArray();
                String[] s = new String[o.length];
                for (int j = 0; j < s.length - 1; j++) {
                    s[j] = (String) o[j];
                }

                dictionary0.put(newKey, s);
                arrayListOfSynonyms.clear();
                Collections.addAll(arrayListOfSynonyms, dictionary.get(key));
            }
        }

        dictionary0.putAll(dictionary);
        do {

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("введите  синоним ");
            String[] strings = dictionary0.get(scanner.nextLine());
            if (strings != null)
                System.out.println(strings[random.nextInt(strings.length - 1)]);
            else
                System.out.println("такого слова не существует");
            System.out.println("______________________________________________");
        } while (true);
    }


}