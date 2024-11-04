package ru.spb.vagvagovich.utils;

/**
 * Утилиты для конвертации массивов из и в строки
 */
public class ArrayConverterUtils {
    
    /**
     * Сконвертировать входную строку в массив строк
     * @param input - входная строка
     * @return массив строк
     */
    public static String[] convertInputStringToStringArray(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        return input.replace(" ", "").split("\n");
    }
    
    /**
     * Конвертер массива чисел в строку
     * @param array - массив
     * @return строка
     */
    public static String convertIntegerArraytoString(Integer[] array) {
        StringBuilder str = new StringBuilder();
        for(int i:array) {
            str.append(i);
            str.append(", ");
        }
        if (!str.isEmpty()) {
            int index = str.lastIndexOf(", ");
            str.delete(index,index+2);
        }
        return str.toString();
    }
    
    /**
     * Конвертер массива чисел в строку
     * @param arrays - двумерный массив
     * @return строка
     */
    public static String convertIntegerArraytoString(Integer[][] arrays) {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for(Integer[] singleArray:arrays) {
            str.append("[");
            str.append(convertIntegerArraytoString(singleArray));
            str.append("]");
            str.append(", ");
        }
        if (str.indexOf("]")>0) {
            int index = str.lastIndexOf(", ");
            str.delete(index,index+2);
        }
        str.append("}");
        return str.toString();
    }
    
    /**
     * Неиспользуемый конструктор для утилитного класса
     */
    private ArrayConverterUtils() {
        //nothing
    }

}
