package week_06._0916.kr.likelion.demo.repository;


import week_06._0916.kr.likelion.demo.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public interface ProductDAO {
    public int insertAndGetId(ProductDTO pDTO);     // insert id 반환
    public boolean insert(ProductDTO pDTO);         // insert 기본
    public boolean delete(int id);                  // delete where id
    public boolean delete(ProductDTO pDTO);         // delete 기본
    public boolean update(ProductDTO pDTO);         // update 기본
    public ProductDTO select(int id);               // select where id
    public ProductDTO select(String name);          // select where name
    public List<ProductDTO> selectAll();            // seelect *
}
