package ru.spb.vagvagovich.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Тест утилиты конвертации строк
 */
public class PortUtilsTest {
    
    /**
     * Тест конвертации массива строк с числами в последжовательность чисел
     */
    @Test
    public void testConvertSimpleStringArrayToIntArray() {
        Integer[] res = PortUtils.convertStringArraysToIntArray(new String[] {"1"});
        assertNotNull(res);
        assertTrue(res.length==1);
        assertTrue(res[0]==1);
    }
    
    /**
     * Тест конвертации массива строк с числами в последжовательность чисел
     */
    @Test
    public void testConvertIntervalStringArrayToIntArray() {
        Integer[] res = PortUtils.convertStringArraysToIntArray(new String[] {"1-3"});
        assertNotNull(res);
        assertTrue(res.length==3);
        assertTrue(res[0]==1);
        assertTrue(res[1]==2);
        assertTrue(res[2]==3);
    }
    
    /**
     * Тест конвертации массива строк с числами в последжовательность чисел
     */
    @Test
    public void testConvertDuplicateStringArrayToIntArray() {
        Integer[] res = PortUtils.convertStringArraysToIntArray(new String[] {"1,2,1"});
        assertNotNull(res);
        assertTrue(res.length==2);
        assertTrue(res[0]==1);
        assertTrue(res[1]==2);
    }
    
    /**
     * Тест конвертации массива строк с числами в последжовательность чисел
     */
    @Test
    public void testConvertNoSortStringArrayToIntArray() {
        Integer[] res = PortUtils.convertStringArraysToIntArray(new String[] {"2,1"});
        assertNotNull(res);
        assertTrue(res.length==2);
        assertTrue(res[0]==1);
        assertTrue(res[1]==2);
    }
    
    /**
     * Тест конвертации массива строк с числами в последжовательность чисел
     */
    @Test
    public void testConvertDefaultStringArrayToIntArray() {
        Integer[] res = PortUtils.convertStringArraysToIntArray(new String[] {"1,3-5","2","3-4"});
        assertNotNull(res);
        assertTrue(res.length==5);
        assertTrue(res[0]==1);
        assertTrue(res[1]==2);
        assertTrue(res[2]==3);
        assertTrue(res[3]==4);
        assertTrue(res[4]==5);
    }
    
    /**
     * Тест конвертации массива строк с числами в последжовательность чисел
     */
    @Test
    public void testConvertHardStringArrayToIntArray() {
        Integer[] res = PortUtils.convertStringArraysToIntArray(new String[] {"1-5,7,9-11"});
        assertNotNull(res);
        assertTrue(res.length==9);
        assertTrue(res[0]==1);
        assertTrue(res[1]==2);
        assertTrue(res[2]==3);
        assertTrue(res[3]==4);
        assertTrue(res[4]==5);
        assertTrue(res[5]==7);
        assertTrue(res[6]==9);
        assertTrue(res[7]==10);
        assertTrue(res[8]==11);
    }
    
    /**
     * Тест конвертации массива строк с числами в декартово произведение массивов
     */
    @Test
    public void testConvertOneStringArrayToUnicGroup() {
        Integer[][] res = PortUtils.convertStringArraysUnicGroups(new String[] {"1"});
        assertNotNull(res);
        assertTrue(res.length==1);
        assertTrue(res[0].length==1);
        assertTrue(res[0][0]==1);
    }
    
    /**
     * Тест конвертации массива строк с числами в декартово произведение массивов
     */
    @Test
    public void testConvertSimpleStringArrayToUnicGroup() {
        Integer[][] res = PortUtils.convertStringArraysUnicGroups(new String[] {"1","2","3"});
        assertNotNull(res);
        assertTrue(res.length==1);
        assertTrue(res[0].length==3);
        assertArrayEquals(res[0],new Integer[]{1,2,3});
    }
    
    /**
     * Тест конвертации массива строк с числами в декартово произведение массивов
     */
    @Test
    public void testConvertDefaultStringArrayToUnicGroup() {
        Integer[][] res = PortUtils.convertStringArraysUnicGroups(new String[] {"1,3-5", "2", "3-4"});
        assertNotNull(res);
        assertTrue(res.length==8);
        assertArrayEquals(res[0],new Integer[]{1,2,3});
        assertArrayEquals(res[1],new Integer[]{1,2,4});
        assertArrayEquals(res[2],new Integer[]{3,2,3});
        assertArrayEquals(res[3],new Integer[]{3,2,4});
        assertArrayEquals(res[4],new Integer[]{4,2,3});
        assertArrayEquals(res[5],new Integer[]{4,2,4});
        assertArrayEquals(res[6],new Integer[]{5,2,3});
        assertArrayEquals(res[7],new Integer[]{5,2,4});
    }
    
}
