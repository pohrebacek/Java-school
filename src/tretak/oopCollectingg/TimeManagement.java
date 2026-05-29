package tretak.oopCollectingg;

import java.util.LinkedList;
import java.util.Queue;

public class TimeManagement {   //přidělim tasky zaměstnancům podle jejich freetime
    public static void main(String[] args) {
        //ArrayList<Employee> employeeArrayList = new ArrayList<>();
        //employeeArrayList.add(new Employee("kok", 60, 50));
        //Queue<Employee> employees = new LinkedList<>(employeeArrayList);

        Queue<Employee> employees = new LinkedList<>();
        employees.add(new Employee("kok1", 500, 40));
        employees.add(new Employee("kok2", 400, 30));
        employees.add(new Employee("kok3", 300, 20));

        //employees.peek();
        //employees.poll();
        //employees.offer(null);

        Queue<Task> tasks = new LinkedList<>();
        tasks.add(new Task("Exchange cables", 60));
        tasks.add(new Task("Update OS", 45));
        tasks.add(new Task("Install antivirus", 30));
        tasks.add(new Task("Replace hard drive", 120));
        tasks.add(new Task("Clean workstation", 20));
        tasks.add(new Task("Configure network", 90));
        tasks.add(new Task("Test hardware", 50));
        tasks.add(new Task("Set up printer", 25));
        tasks.add(new Task("Troubleshoot Wi-Fi", 35));
        tasks.add(new Task("Backup tretak.files", 75));
        tasks.add(new Task("Assemble PC", 150));
        tasks.add(new Task("Optimize performance", 40));
        tasks.add(new Task("Create user accounts", 15));
        tasks.add(new Task("Train new staff", 180));
        tasks.add(new Task("Remove malware", 55));
        tasks.add(new Task("Upgrade RAM", 25));
        tasks.add(new Task("Set up email client", 20));
        tasks.add(new Task("Reset passwords", 10));
        tasks.add(new Task("Patch security vulnerabilities", 80));
        tasks.add(new Task("Calibrate display", 30));

        while (!tasks.isEmpty() && !employees.isEmpty()){
            Employee top = employees.peek();    //vezme prvního zaměstnance
            Task currentTask = tasks.peek();

            System.out.println(top);
            System.out.println("Doing task: "+currentTask.taskName + ", duration: " + currentTask.completeTime);

            if (top.freeTime >= currentTask.completeTime){
                //splní ukol, ukol jde ven z fronty ukolů
                top.freeTime -= currentTask.completeTime;
                tasks.poll();   //odstraní první z fronty tasks
                System.out.println(top.name+" did task "+currentTask.taskName);
            } else {
                System.out.println(top.name + "could not finish task "+currentTask.taskName);
                employees.poll();
            }
            System.out.println(employees);
        }
    }
}

class Employee{
    String name;
    int freeTime;
    double shoeSize;

    public Employee(String name, int freeTime, double shoeSize) {
        this.name = name;
        this.freeTime = freeTime;
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return name+", "+"freetime left: "+freeTime;
    }
}

class Task{
    String taskName;
    int completeTime;

    public Task(String taskName, int completeTime) {
        this.taskName = taskName;
        this.completeTime = completeTime;
    }
}