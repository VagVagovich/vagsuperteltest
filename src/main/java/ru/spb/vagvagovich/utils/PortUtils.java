package ru.spb.vagvagovich.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Утилиты для конвертации и работы с данными из класса Port
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
    
    public static Integer[] convertStringArraysToIntArray(String[] strings) {
        SortedSet<Integer> result = new TreeSet<Integer>();
        List<SortedSet<Integer>> preparedData = prepareStringArrayToWork(strings);
        for(SortedSet<Integer> oneStringData:preparedData) {
            result.addAll(oneStringData);
        }
        return (Integer[]) result.toArray();
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
                int max = Integer.parseInt(onePart.substring(index));
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
    
//    private static int[] prepareStringToWork(String str) {
//        int firstNumber = -1;
//        int secondNumber = -1;
//        StringBuilder firstNumberInStr = new StringBuilder();
//        StringBuilder secondNumberInStr = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ') {
//                // Если стоит пробел, то символ пропускается
//                continue;
//            }
//            if ((str.charAt(i) >= '0') && (str.charAt(i) <= '9')) {
//                // Если у нас цифра
//                if (firstNumber < 0) {
//                    firstNumberInStr.append(str.charAt(i));
//                } else {
//                    secondNumberInStr.append(str.charAt(i));
//                }
//                continue;
//            }
//            if (str.charAt(i) == '-') {
//                if ((firstNumberInStr.length() == 0) || (secondNumberInStr.length() > 0)) {
//                    // мы работаем лишь с натуральными числами
//                    return null;
//                }
//                firstNumber = Integer.parseInt(firstNumberInStr.toString());
//                firstNumberInStr = new StringBuilder();
//                continue;
//            }
//            if (str.charAt(i) == ',') {
//                if ((firstNumber < 0) && (firstNumberInStr.length() == 0)) {
//                    // не может быть пустых интервалов
//                    return null;
//                }
//                if (secondNumberInStr.length() > 0) {
//                    secondNumber = Integer.parseInt(secondNumberInStr.toString());
//                    secondNumberInStr = new StringBuilder();
//                } else {
//                    if (firstNumberInStr.length() == 0) {
//                        return null;
//                    }
//                    firstNumber = Integer.parseInt(firstNumberInStr.toString());
//                    secondNumber = firstNumber;
//                    firstNumberInStr = new StringBuilder();
//                }
//                IntegerInterval ii = new IntegerInterval(firstNumber, secondNumber);
//                resultInterval.include(ii);
//                firstNumber = secondNumber = -1;
//                continue;
//            }
//            return null;
//        }
//        if ((firstNumber < 0) && (firstNumberInStr.length() == 0)) {
//            return null;
//        }
//        if (secondNumberInStr.length() > 0) {
//            secondNumber = Integer.parseInt(secondNumberInStr.toString());
//        } else {
//            if (firstNumberInStr.length() == 0) {
//                return null;
//            }
//            firstNumber = Integer.parseInt(firstNumberInStr.toString());
//            secondNumber = firstNumber;
//        }
//        if (firstNumber > secondNumber) {
//            return null;
//        }
//    }

}
