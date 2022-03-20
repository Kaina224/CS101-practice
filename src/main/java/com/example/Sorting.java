package com.example;

import java.util.Arrays;

public class Sorting {
    private int[] data;

    public Sorting(int[] data){
        this.data = data;
    }

    public void sort(SortType mode){
        switch(mode){
            case BUBBLE:
                bubbleSort();
            case MERGE:
                mergeSort(this.data, 0, data.length);
            case INSERTION:
                insertionSort();
            case QUICK:
                quickSort();
        }
    }

    private void bubbleSort(){
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length - 1; j++){
                if (data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    private void mergeSort(int[] data, int beginningIndex, int endIndex){
        int middleIndex = beginningIndex + (endIndex - beginningIndex)/2;
        if(middleIndex != beginningIndex){
            mergeSort(data, beginningIndex, middleIndex);
            mergeSort(data, middleIndex, endIndex);
            merge(data, beginningIndex, middleIndex, endIndex);
        } 
    }

    private void merge(int[] data, int beginningIndex, int middleIndex, int endIndex){
        int subarraySizeOne = middleIndex - beginningIndex;
        int subarraySizeTwo = endIndex - middleIndex;

        int[] leftArray = Arrays.copyOfRange(data, beginningIndex, beginningIndex + subarraySizeOne);
        int[] rightArray = Arrays.copyOfRange(data, middleIndex, middleIndex + subarraySizeTwo);

        int i = 0, j = 0;
        int k = beginningIndex;

        while (i < subarraySizeOne && j < subarraySizeTwo){
            if (leftArray[i] <= rightArray[j]){
                data[k] = leftArray[i];
                i++;
            }
            else{
                data[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < subarraySizeOne){
            data[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < subarraySizeTwo){
            data[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void insertionSort(){

    }

    private void quickSort(){

    }

    public int[] getData(){
        return data;
    }
}
