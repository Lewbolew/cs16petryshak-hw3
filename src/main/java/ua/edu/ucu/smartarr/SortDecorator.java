package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    SmartArray smartArray;
    MyComparator myComparator;

    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        this.smartArray = smartArray;
        this.myComparator = myComparator;
    }

    @Override
    public Object[] toArray() {
        return modify();
    }

    @Override
    public String operationDescription() {
        return "Sort decorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    @Override
    public Object[] modify() {
        Object[] arr = smartArray.toArray();
        Arrays.sort(arr, myComparator);
        return arr;
    }
}
