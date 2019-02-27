
package chapter_1;


public class Employee implements Comparable<Employee>{
    private String name ; 
    private String department ; 
    private double salary ;
    public static int count ; 
    public Employee(){
        count++;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    
    public double getSalaryWithBouns(double bouns) {
        return salary*bouns;
    }
    
    public static int getCount() {
        return count;
    }

    @Override
    public int compareTo(Employee t) {
        return this.getName().compareTo(((Employee) t).getName());
    }

    
    
    
}
