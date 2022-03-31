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
                quickSort(this.data, 0, data.length - 1);
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

        mergeSubArrays(beginningIndex, 
                       leftArray, 
                       rightArray, 
                       data, 
                       subarraySizeOne, 
                       subarraySizeTwo);
    }

    private void mergeSubArrays(int beginningIndex,
                                int[] leftArray, 
                                int[] rightArray, 
                                int[] data,
                                int subarraySizeOne, 
                                int subarraySizeTwo){
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
        for (int i = 0; i < data.length; i++){
            for (int j = i; j > 0; j--){
                if(data[j] > data[j - 1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
    }

    private void quickSort(int[] data, int beginningIndex, int endIndex){
        if (beginningIndex < endIndex){
            int partitionIndex = partition(data, beginningIndex, endIndex);
            quickSort(data, beginningIndex, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, endIndex);
        }
    }

    private int partition(int[] data, int beginningIndex, int endIndex){
        int middleIndex = beginningIndex + (endIndex - beginningIndex)/2;
        if (middleIndex != beginningIndex && middleIndex != endIndex){
            findMedian(data, beginningIndex, middleIndex, endIndex);
        }
        int pivot = data[middleIndex];
        int i = beginningIndex;
        int j = endIndex;
        while(j > i){
            if (data[i] > data[j]){
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            if (data[i] <= pivot){
                i++;
            }
            if (data[j] > pivot){
                j--;
            }
        }
        return j;
    }

    private void findMedian(int[] data, 
                           int beginningIndex, 
                           int middleIndex, 
                           int endIndex){
        int low = data[beginningIndex];
        int medium = data[middleIndex];
        int high = data[endIndex];
        
        if ((low <= medium && low >= high)){
            data[beginningIndex] = high;
            data[middleIndex] = low;
            data[endIndex] = medium;
        }
        else if((low >= medium && low <= high)){
            data[beginningIndex] = medium;
            data[middleIndex] = low;
            data[endIndex] = high;
        }
        else if ((medium <= low && medium >= high)){
            data[beginningIndex] = high;
            data[middleIndex] = medium;
            data[endIndex] = low;
        }
        else if ((medium >= low && medium <= high)){
            data[beginningIndex] = low;
            data[middleIndex] = medium;
            data[endIndex] = high;
        }
        else if (high >= low && high <= medium){
            data[beginningIndex] = low;
            data[middleIndex] = high;
            data[endIndex] = medium;
        }
        else{
            data[beginningIndex] = medium;
            data[middleIndex] = high;
            data[endIndex] = low;
        }
    }

    public int[] getData(){
        return data;
    }
}
