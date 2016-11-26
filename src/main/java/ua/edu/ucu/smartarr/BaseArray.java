package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;

    public BaseArray(Object[] array) {
        this.array = array;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public String operationDescription() {
        return "Certain decorator";
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public Object[] modify() {
        return new Object[0];
    }
}
