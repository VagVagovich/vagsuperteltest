package ru.spb.vagvagovich.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Тест утилиты перевода массивов чисел из и в строки
 */
public class ArrayConverterUtilsTest {
    
    /**
     * Тест исходной конвертации строки в массив строк с числами
     */
    @Test
    public void testConvertSimpleInputString() {
        String[] res = ArrayConverterUtils.convertInputStringToStringArray("1");
        assertNotNull(res);
        assertTrue(res.length==1);
        assertEquals(res[0], "1");
    }
    
    /**
     * Тест исходной конвертации строки в массив строк с числами
     */
    @Test
    public void testConvertEmptyInputString() {
        String[] res = ArrayConverterUtils.convertInputStringToStringArray("");
        assertNotNull(res);
        assertTrue(res.length==0);
    }
    
    /**
     * Тест исходной конвертации строки в массив строк с числами
     */
    @Test
    public void testConvertManyRowInputString() {
        String[] res = ArrayConverterUtils.convertInputStringToStringArray("1\n2\n3");
        assertNotNull(res);
        assertTrue(res.length==3);
        assertEquals(res[0], "1");
        assertEquals(res[1], "2");
        assertEquals(res[2], "3");
    }
    
    /**
     * Тест исходной конвертации строки в массив строк с числами
     */
    @Test
    public void testConvertDefaultInputString() {
        String[] res = ArrayConverterUtils.convertInputStringToStringArray("1,3-5\n2\n3-4");
        assertNotNull(res);
        assertTrue(res.length==3);
        assertEquals(res[0], "1,3-5");
        assertEquals(res[1], "2");
        assertEquals(res[2], "3-4");
    }

}
