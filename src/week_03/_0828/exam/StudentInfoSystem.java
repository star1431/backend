package week_03._0828.exam;
import java.util.*;
// import java.util.HashMap;
// import java.util.Map.Entry;

public class StudentInfoSystem {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         * List
         * 1. Student 객체를 5개 생성하여 학생 5명을 만들기
         * 2. List<Student>에 학생을 담기
         * 3. 2학년인 학생의 이름과 전공을 출력하기 (Get()메서드 활용)
         */
        Student s1 = new Student("짱구", "2025990001", 4, "철학");
        Student s2 = new Student("철수", "2025990002", 1, "심리학");
        Student s3 = new Student("유라", "2025990003", 2, "교육학");
        Student s4 = new Student("환이", "2025990004", 3, "교육학");
        Student s5 = new Student("영구", "2025990005", 2, "문헌정보학");

        List<Student> stuList = new ArrayList<>();
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);
        stuList.add(s4);
        stuList.add(s5);


        System.out.println("==== 학생 정보 시스템 ====");
        System.out.print("학년 입력: ");
        int scGrade = sc.nextInt();

        // 해당학년 새 배열 담기
        List<Student> filterList = new ArrayList<>();
        for (Student item : stuList) {
            if (item.getGrade() == scGrade) {
                filterList.add(item);
            }
        }

        // 출력
        System.out.println("-".repeat(8));
        System.out.println(scGrade + "학년 학생 명단: ");
        for (Student item : filterList) {
            System.out.println("이름: " + item.getName() + ", 전공: " + item.getMajor());
        }
        System.out.println("-".repeat(8));


        /*
         * Set
         * 4. 학번이 동일한 객체에 다른 학생을 담아보고 중복이 어떻게 처리되는지 확인하기.
         */
        Student s6 = new Student("추가학생", "2025990005", 4, "사학");
        Set<Student> stuSet = new HashSet<>(stuList);
        stuSet.add(s6);

        System.out.println("-".repeat(8));
        System.out.println("학생 추가 정보 : " + s6);
        System.out.println("Set 중복처리 확인");
        for (Student item : stuSet) {
            System.out.println(item);
        }
        System.out.println("-".repeat(8));

        
        /*
         * Map
         * 5. key값은 studentId, value값은 Student인 Map을 만들어 학생 데이터를 담아보기
         * 6. 사용자에게 학번을 입력받아, 그 학생의 데이터를 출력하기
         */
        Map<String, Student> stuMap = new LinkedHashMap<>();
        for (Student item : stuList) {
            stuMap.put(item.getId(), item);
        }

        System.out.println();
        System.out.print("해당 학번 찾기\nex) 2025990005\n입력: ");
        String scId = sc.next();

        Student target = stuMap.get(scId);
        // System.out.println(target);
        if (target != null) {
            System.out.println("학생 정보: " + target);
        } else {
            System.out.println("해당 학번의 학생이 없습니다.");
        }

        sc.close();
        
        /*
         * 응용
         * 7. 모든 학생을 List에 담은 뒤, 전공별로 학생들을 Map<String, List<Student>>에 담아 이름을 출력하기
         * 컴퓨터공학 : [Kim, Lee]  
            경영학 : [Park]  
            수학과 : [Choi, Jung]
         */

        // 좀더 봐야겠습니다.
        Map<String, List<Student>> majorMap = new HashMap<>();

        for (Student item : stuList) {
            String major = item.getMajor();

            if(!majorMap.containsKey(major)) {
                majorMap.put(major, new ArrayList<>());
            }
            majorMap.get(major).add(item);
        }

        for (String item : majorMap.keySet()) {
            System.out.print(item + ": ");
            for(Student item2 : majorMap.get(item)) {
                System.out.print(item2.getName() + " ");
            }
            System.out.println();
        }
    }
}
