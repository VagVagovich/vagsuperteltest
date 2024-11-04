package ru.spb.vagvagovich.model;

import ru.spb.vagvagovich.utils.PortUtils;

/**
 * Класс хранения данных о числах
 */
public class Port {

    /**
     * Массив строк с числами
     */
    private final String[] indexes;
    
    /**
     * Создать элемент типа Port из строки для ввода
     * @param input входная строка
     * @return элемент типа Port
     */
    public static Port createPortFromString(String input) {
        return new Port(PortUtils.convertInputStringToStringArray(input));
    }
    
    /**
     * Создать класс хранения данных о числах
     * @param indexes - сами числа
     */
    private Port(String[] indexes) {
        this.indexes = indexes;
    }

    /**
     * Получить массив строк с числами
     * @return массив строк с числами
     */
    public String[] getIndexes() {
        return indexes;
    }
}
