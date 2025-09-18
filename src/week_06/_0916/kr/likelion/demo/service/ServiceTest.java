package week_06._0916.kr.likelion.demo.service;

import week_06._0916.kr.likelion.demo.common.DBUtil;
import week_06._0916.kr.likelion.demo.dto.ProductDTO;
import week_06._0916.kr.likelion.demo.repository.ProductDAO;
import week_06._0916.kr.likelion.demo.repository.ProductDAOImpl;

import java.sql.Connection;
import java.util.List;

public class ServiceTest {
    static ProductDAO pDAO = new ProductDAOImpl();

    // 추가확인 메서드 (임시)
    // public static void insertTest() {
    //     Connection conn = null;
    //     try {
    //         conn = DBUtil.getConnection();
    //         DBUtil.autoCommit(conn, false); // 트랙잭션 start
    //
    //         ProductDTO test = new ProductDTO("book2", 28000);
    //         boolean insertItem =  pDAO.insert(test);
    //         if(insertItem) System.out.println("삽입성공");
    //         System.out.println(test.getId());
    //
    //         DBUtil.commit(conn);    // 트랙잭션 end
    //
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         DBUtil.rollback(conn);  // 트랙잭션 rollback
    //     } finally {
    //         DBUtil.close(conn);
    //     }
    // }

    public static void main(String[] args) {
        
        // 추가 확인
        ProductDTO test = new ProductDTO("book2", 28000);
        boolean insertItem =  pDAO.insert(test);
        if(insertItem) System.out.println("삽입성공");
        System.out.println(test.getId());

        // 단건 조회
        ProductDTO itemFind = pDAO.select(2);
        System.out.println(itemFind);
        
        
        // 삭제 확인
        boolean deleteItem =  pDAO.delete(test);
        if(deleteItem) System.out.println("삭제성공");


        // 전체 조회
        List<ProductDTO> dtoList = pDAO.selectAll();
        for(ProductDTO items : dtoList) {
            System.out.println(items);
        }
    }
}
