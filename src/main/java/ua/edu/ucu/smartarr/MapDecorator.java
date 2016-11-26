package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction myFunction;
    private SmartArray smartArray;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        this.smartArray = smartArray;
        this.myFunction = myFunction;
    }


    @Override
    public Object[] modify() {
        Object[] arr = smartArray.toArray();
        Object[] modifiedArray = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            modifiedArray[i] = myFunction.apply(arr[i]);
        }
        return modifiedArray;
    }
    @Override
    public Object[] toArray() {

        return modify();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }


}
