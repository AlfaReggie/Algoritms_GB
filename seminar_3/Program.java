package org.example.seminar_3;

public class Program {
    public static void main(String[] args) {

        Employee employee1 = new Employee("CCCCCCC", 24);
        Employee employee2 = new Employee("DDDDDDD", 25);

        LinkedListTest<Employee> employeeLinkedListTest = new LinkedListTest<>();
        employeeLinkedListTest.addFirst(new Employee("AAAAaaaa", 21));
        employeeLinkedListTest.addFirst(new Employee("Bbbbbbb", 22));
        employeeLinkedListTest.addFirst(employee1);
        employeeLinkedListTest.addFirst(new Employee("AAAAaaaa", 29));
        employeeLinkedListTest.addFirst(new Employee("Bbbbbbb", 28));
        employeeLinkedListTest.addFirst(new Employee("EEEeee", 21));
        employeeLinkedListTest.addFirst(new Employee("Ffffff", 22));

//        boolean res = employeeLinkedListTest.contains(employee1);

        System.out.println(employeeLinkedListTest);

//        employeeLinkedListTest.sort(new EmployeeComparator(SortType.Ascending));
        employeeLinkedListTest.reverse();

        System.out.println(employeeLinkedListTest);
    }
}
