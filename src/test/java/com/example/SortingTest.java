package com.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class SortingTest{
    @Test
    public void bubbleSort_oneElement_sortedCorrectly(){
        int[] expectedData = {1};
        Sorting sorter = new Sorting(expectedData);
        sorter.sort(SortType.BUBBLE);
        assertArrayEquals(expectedData, sorter.getData());
    }

    @Test
    public void bubbleSort_twoElements_sortedCorrectly(){
        int[] data = {2,1};
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.BUBBLE);

        int[] expectedData = {1,2};
        int[] actualData = sorter.getData();

        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void bubblesort_multipleElements_sortedCorrectly(){
        int[] data = {9, 4, 2, 8, 1, 3, 5, 6, 7};
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.BUBBLE);

        int[] expectedData = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actualData = sorter.getData();

        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void bubbleSort_multipleRandomElements_sortedCorrectly(){
        Random random = new Random();
        List<Integer> randomData = new ArrayList<Integer>();
        int dataLength = random.nextInt(10);
        for (int i = 0; i < dataLength; i++){
            randomData.add(random.nextInt(10));
        }
        int[] data = randomData.stream().mapToInt(i -> i).toArray();
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.BUBBLE);

        int[] actualData = sorter.getData();
        assertArraySorted(actualData);
    }

    private void assertArraySorted(int[] data){
        for (int i = 0; i < data.length-1; i++){
            assertTrue(data[i] <= data[i+1]);
        }
    }

    @Test
    public void mergeSort_oneElement_sortedCorrectly(){
        int[] expectedData = {1};
        Sorting sorter = new Sorting(expectedData);
        sorter.sort(SortType.MERGE);

        int[] actualData = sorter.getData();
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void mergeSort_twoElements_SortedCorrectly(){
        int[] expectedData = {2,1};
        Sorting sorter = new Sorting(expectedData);
        sorter.sort(SortType.MERGE);

        int[] actualData = sorter.getData();
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void mergeSort_multipleElements_sortedCorrectly(){
        int[] data = {9, 4, 2, 8, 1, 3, 7, 6, 5};
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.MERGE);

        int[] expectedData = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actualData = sorter.getData();

        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void mergeSort_multipleElementsRandomlyGenerated_sortedCorrectly(){
        Random random = new Random();
        List<Integer> randomData = new ArrayList<Integer>();
        int dataLength = random.nextInt(10);
        for (int i = 0; i < dataLength; i++){
            randomData.add(random.nextInt(10));
        }
        int[] data = randomData.stream().mapToInt(i -> i).toArray();
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.MERGE);

        int[] actualData = sorter.getData();
        assertArraySorted(actualData);
    }

    @Test
    public void quickSort_oneElement_sortedCorrectly(){
        int[] expectedData = {1};
        Sorting sorter = new Sorting(expectedData);
        sorter.sort(SortType.QUICK);

        int[] actualData = sorter.getData();
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void quickSort_twoElements_sortedCorrectly(){
        int[] expectedData = {2,1};
        Sorting sorter = new Sorting(expectedData);
        sorter.sort(SortType.QUICK);

        int[] actualData = sorter.getData();
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void quickSort_multipleElements_sortedCorrectly(){
        int[] data = {9, 4, 2, 8, 1, 3, 7, 6, 5};
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.QUICK);

        int[] expectedData = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actualData = sorter.getData();

        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void quickSort_multipleRandomElements_sortedCorrectly(){
        Random random = new Random();
        List<Integer> randomData = new ArrayList<Integer>();
        int dataLength = random.nextInt(10);
        for (int i = 0; i < dataLength; i++){
            randomData.add(random.nextInt(10));
        }
        int[] data = randomData.stream().mapToInt(i -> i).toArray();
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.QUICK);

        int[] actualData = sorter.getData();
        assertArraySorted(actualData);
    }

    @Test
    public void insertionSort_oneElement_sortedCorrectly(){
        int[] expectedData = {1};
        Sorting sorter = new Sorting(expectedData);
        sorter.sort(SortType.INSERTION);

        int[] actualData = sorter.getData();
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void insertionSort_twoElements_sortedCorrectly(){
        int[] expectedData = {2,1};
        Sorting sorter = new Sorting(expectedData);
        sorter.sort(SortType.INSERTION);

        int[] actualData = sorter.getData();
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void insertionSort_multipleElements_sortedCorrectly(){
        int[] data = {9, 4, 2, 8, 1, 3, 7, 6, 5};
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.INSERTION);

        int[] expectedData = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actualData = sorter.getData();

        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void insertionSort_multipleRandomElements_sortedCorrectly(){
        Random random = new Random();
        List<Integer> randomData = new ArrayList<Integer>();
        int dataLength = random.nextInt(10);
        for (int i = 0; i < dataLength; i++){
            randomData.add(random.nextInt(10));
        }
        int[] data = randomData.stream().mapToInt(i -> i).toArray();
        Sorting sorter = new Sorting(data);
        sorter.sort(SortType.INSERTION);

        int[] actualData = sorter.getData();
        assertArraySorted(actualData);
    }
}
