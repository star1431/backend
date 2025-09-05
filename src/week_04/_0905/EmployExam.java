package week_04._0905;
import java.util.ArrayList;
import java.util.List;

/**직원 정보 */
class Employee {
    private final String name;
    private final double basicSalary;
    private final double incentive;

    public Employee(String name, double basicSalary, double incentive) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.incentive = incentive;
    }

    public String getName() {
        return name;
    }
    public double getBasicSalary() {
        return basicSalary;
    }
    public double getIncentive() {
        return incentive;
    }
}

/** 급여 계산 */
class PayCalculator {
    public double total(Employee e) {
        return e.getBasicSalary() + e.getIncentive();
    }
}

/** 직원 정보 저장 */
class EmployeeRepository {
    private final List<Employee> lists = new ArrayList<>();

    public void save(Employee e) {
        lists.add(e);
    }

    public List<Employee> getList() {
        return new ArrayList<>(lists);
    }
}

/** 보고서 생성 */
class ReportGenerator {
    public void print(List<Employee> employees, PayCalculator calc) {
        for (Employee e : employees) {
            double total = calc.total(e);
            System.out.printf("이름: %s, 급여: %,d원%n", e.getName(), (long)total);
        }
    }
}

public class EmployExam {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        PayCalculator calc = new PayCalculator();
        ReportGenerator report = new ReportGenerator();

        // 직원 등록
        repository.save(new Employee("홍길동", 3_000_000, 200_000));
        repository.save(new Employee("임꺽정", 2_800_000, 150_000));

        // 보고서 출력
        report.print(repository.getList(), calc);
    }
}