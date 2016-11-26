package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    protected SmartArray smartArray;

    public SmartArrayDecorator() {

    }
    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

}
