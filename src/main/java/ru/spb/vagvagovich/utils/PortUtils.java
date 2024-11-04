package ru.spb.vagvagovich.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Утилиты для конвертации и работы с данными из класса Port
 * @author VagVagovich
 */
public class PortUtils {
    
    /**
     * Сконвертировать входную строку в массив строк
     * @param input - входная строка
     * @return массив строк
     */
    public static String[] convertInputStringToStringArray(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        return input.split("/n");
    }
    
    /**
     * Сконвертировать массив строк с числами в массив чисел
     * @param strings - исходный массив строк
     * @return массив чисел
     */
    public static Integer[] convertStringArraysToIntArray(String[] strings) {
        SortedSet<Integer> result = new TreeSet<Integer>();
        List<SortedSet<Integer>> preparedData = prepareStringArrayToWork(strings);
        for(SortedSet<Integer> oneStringData:preparedData) {
            result.addAll(oneStringData);
        }
        return result.toArray(new Integer[result.size()]);
    }
    
    public static Integer[][] convertStringArraysUnicGroups(String[] strings) {
        List<SortedSet<Integer>> preparedData = prepareStringArrayToWork(strings);
        int allSize = 1;
        //TODO Предусмотреть что массив срок может быть пуст и тогда будет сбой
        for(SortedSet<Integer> oneStringData:preparedData) {
            allSize = allSize * oneStringData.size();
        }
        Integer[][] res = new Integer[allSize][preparedData.size()];
        for(int i=0; i<allSize; i++) {
            int currentSdvig = allSize;
            for(int j=0; j<preparedData.size(); j++) {
                currentSdvig = currentSdvig/preparedData.get(j).size();
                int index = (i/currentSdvig) % preparedData.get(j).size();
                res[i][j] =  (Integer) preparedData.get(j).toArray()[index];
            }
        }
        return res;
    }
    
    private static List<SortedSet<Integer>> prepareStringArrayToWork(String[] strings) {
        List<SortedSet<Integer>> res = new ArrayList<SortedSet<Integer>>();
        for (String str:strings) {
            res.add(prepareStringToWork(str));
        }
        return res;
    }
    
    private static SortedSet<Integer> prepareStringToWork(String str) {
        SortedSet<Integer> collection = new TreeSet<Integer>();
        for (String onePart:str.split(",")) {
            if (onePart.contains("-")) {
                int index = onePart.indexOf('-');
                int min = Integer.parseInt(onePart.substring(0, index));
                int max = Integer.parseInt(onePart.substring(index+1));
                for (int i=min;i<=max;i++) {
                    collection.add(i);
                }
            } else {
                int number = Integer.parseInt(onePart);
                collection.add(number);
            }
        }
        return collection;
    }
    
    /**
     * Неиспользуемый конструктор для утилитного класса
     */
    private PortUtils() {
        //nothing
    }
    
}
