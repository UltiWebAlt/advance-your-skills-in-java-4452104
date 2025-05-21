package com.example.ch2;

public class Answer {
    // Java code​​​​​​‌‌​‌​‌‌​​​​​​​​‌‌​‌‌​​​‌​ below
// Write your answer here, and then test your code.
// Your job is to refactor the datacontainer class and create an instance in the createStringDataContainer() method.


    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Return a DataContainer instances for Strings
    public static void main(String[] args) {
        // Create a DataContainer with String for the parameterized type
        // Give it the value "Hello"
        DataContainer<String> stringDataContainer = createStringDataContainer();
        System.out.println(stringDataContainer.getValue());
    }

    static public DataContainer<String> createStringDataContainer() {
        // Alter this code to return a DataContainer with String for the parameterized type
        // Give it the value "Hello"
        return new DataContainer<String>("Hello");
    }

}
// refactor this class to use a generic instead of Object
class DataContainer<T> {
    private T value;

    public DataContainer(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

