package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import java.util.Arrays;
import java.util.LinkedList;

public class SmartArrayApp {

    public static Integer[] filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[] findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        students = repeatsDeletor(students);
        BaseArray baseArray = new BaseArray(students);
        SmartArray smartArray = new DistinctDecorator(baseArray);
        MyPredicate myPredicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                if(((Student) t).getGPA() >= 4 && ((Student) t).getYear() == 2) {
                    return true;
                }
                return false;
            }};
        MyComparator myComparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = ((Student) o1).getSurname();
                String s2 = ((Student) o2).getSurname();
                return s1.compareTo(s2);
            }};
        MyFunction myFunction = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student)t).getSurname() + " " + ((Student)t).getName();
            }};
        smartArray = new FilterDecorator(smartArray, myPredicate);
        smartArray = new SortDecorator(smartArray, myComparator);
        smartArray = new MapDecorator(smartArray, myFunction);
        Object[] result = smartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }

    static Student[] repeatsDeletor( Student[] students) {
        LinkedList<Student> linkedList = new LinkedList<>();
        for(int k = 0; k < students.length; k++) {
            linkedList.add(students[k]);
        }
        for(int i = 0; i < linkedList.size(); i++) {
            for(int j = 0; j < linkedList.size();j++) {
                if(i != j && studentComparator(linkedList.get(i), linkedList.get(j))) {
                    linkedList.remove(j);
                }
            }
        }
        Student[] result = new Student[linkedList.size()];
        for(int n = 0; n < linkedList.size(); n++) {
            result[n] = linkedList.get(n);
        }
        return result;
    }
    static boolean studentComparator(Student student1, Student student2) {
        if(student1.getGPA() == student2.getGPA() && student1.getSurname() == student2.getSurname() && student1.getYear()
                == student2.getYear() && student1.getName() == student2.getName()) {
            return true;
        }
        return false;
    }
}
