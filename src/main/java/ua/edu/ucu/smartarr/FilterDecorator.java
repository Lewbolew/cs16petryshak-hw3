package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.LinkedList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    SmartArray smartArray;
    MyPredicate myPredicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        this.smartArray = smartArray;
        this.myPredicate = myPredicate;
    }


    @Override
    public Object[] toArray() {
        return modify();
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    @Override
    public Object[] modify() {
        LinkedList linkedList = new LinkedList();
        Object[] arr = smartArray.toArray();
        for(int i = 0; i < smartArray.size(); i++) {
            if (myPredicate.test(arr[i])) {
                linkedList.add(arr[i]);
            }
        }
        return linkedList.toArray();
    }
}
