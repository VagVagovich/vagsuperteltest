package ru.spb.vagvagovich.model;

import ru.spb.vagvagovich.utils.PortUtils;

public class Port {

    /**
     * Массив строк
     */
    private String[] indexes;
    
    public Port(String[] indexes) {
        this.indexes = indexes;
    }
    
    public static Port createPortFromString(String input) {
        return new Port(PortUtils.convertInputStringToStringArray(input));
    }
}
