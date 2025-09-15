package week_06._0915;

import week_06._0915.lionDB.dept.DeptDAO;
import week_06._0915.lionDB.dept.DeptDTO;

import java.util.List;

public class Test0915 {
    public static void main(String[] args) {

       DeptDAO dao = new DeptDAO();
       DeptDTO dto = new DeptDTO();

        dto.setDeptno(70);
        dto.setDname("라이언");
        dto.setLoc("서울");

        // 삭제
        boolean del = dao.deleteDept(dto);
        if(del) System.out.println("딜리트/ " + dto.toString());
        else System.out.println("딜리트 실패");

        // 추가
        boolean insert = dao.insertDept(dto);
        if(insert) System.out.println("인설트/ " + dto.toString());
        else System.out.println("인설트 실패");
        
        // 변경
        dto.setDname("라이언33");
        boolean update = dao.updateDept(dto);
        if(update) System.out.println("업데이트/ " + dto.toString());
        else System.out.println("업데이트 실패");

        // 전체조회
        List<DeptDTO> deptList = dao.getAll();
        for (DeptDTO item : deptList) {
            System.out.println(item);
        }
        
        // 단건조회
        DeptDTO singleResult = DeptDAO.getDept(10);
        if(singleResult != null && singleResult.getDeptno() == 10) System.out.println(singleResult);
        else System.out.println("없음" + singleResult);
    }
}
