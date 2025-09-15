package week_06._0915.lionDB.dept;

import week_06._0915.lionDB.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    
    /** 튜플 삭제 */
    public static boolean deleteDept(DeptDTO deptDTO){
        String sql = "delete from dept where deptno=?";
        int resultCount = 0;

        try(
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, deptDTO.getDeptno());
            resultCount = ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return resultCount > 0;
    }

    /** 튜플 변경 */
    public static boolean updateDept(DeptDTO deptDTO){
        String sql = "update dept set dname=? where deptno=?";
        int resultCount = 0;

        try(
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, deptDTO.getDname());
            ps.setInt(2, deptDTO.getDeptno());
            resultCount = ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return resultCount > 0;
    }

    /** 튜플 추가 */
    public static boolean insertDept(DeptDTO deptDTO){
        String sql = "insert into dept(deptno, dname, loc) values (?,?,?)";
        int resultCount = 0;

        try(
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, deptDTO.getDeptno());
            ps.setString(2, deptDTO.getDname());
            ps.setString(3, deptDTO.getLoc());
            resultCount = ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return resultCount > 0;
    }

    /** 단건 조회 */
    public static DeptDTO getDept(int deptno) {
        String sql = "select deptno, dname, loc from dept where deptno = ?";
        DeptDTO deptDTO = null;
        ResultSet rs = null;

        try(
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            // 스테이트먼트 셋 먼저 적용후 익스큐트쿼리 써야함.
            ps.setInt(1, deptno);
            rs = ps.executeQuery();
            if(rs.next()) {
                deptDTO = new DeptDTO();
                deptDTO.setDeptno(rs.getInt("deptno"));
                deptDTO.setDname(rs.getString("dname"));
                deptDTO.setLoc(rs.getString("loc"));
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtil.close(rs);
        }

        return  deptDTO;
    }

    /** 전체 조회 */
    public static List<DeptDTO> getAll() {
        String sql = "select deptno, dname, loc from dept";
        List<DeptDTO> list = new ArrayList<>();
        
        try(
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                DeptDTO deptDTO = new DeptDTO();
                deptDTO.setDeptno(rs.getInt(1));
                deptDTO.setDname(rs.getString(2));
                deptDTO.setLoc(rs.getString(3));
                list.add(deptDTO);
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
}
