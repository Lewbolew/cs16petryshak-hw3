package ua.edu.ucu.smartarr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private BaseArray baseArray;

    public DistinctDecorator() {

    }
    public DistinctDecorator(BaseArray baseArray) {
        this.baseArray = baseArray;
    }


    @Override
    public Object[] toArray() {
        return baseArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator";
    }

    @Override
    public int size() {
        return baseArray.size();
    }

    @Override
    public Object[] modify() {
        Set<Object> set = new HashSet();
        Object[] array = baseArray.toArray();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        Object[] newArray = new Object[set.size()];
        Iterator it = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            newArray[i] = it.next();
        }
        return newArray;
    }


}
