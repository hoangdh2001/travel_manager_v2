package com.hoanghung.dao;

import com.hoanghung.model.DiaChi;
import java.util.List;

public interface DiaChi_DAO {
    public List<String> getAllTinhThanh();
    
    //nh
    public DiaChi getDiaChi(String id);
    /**
     * lấy quận/huyện dựa vào tỉnh thành
     *
     * @param tinhThanh
     * @return
     */
    public List<String> getQuanHuyenTheoTinhThanh(String tinhThanh);

    /**
     * lấy phường/xã dựa vào quận/huyện và tỉnh thành
     *
     * @param quanHuyen
     * @param tinhThanh
     * @return
     */
    public List<String> getPhuongXaTheoQHTH(String quanHuyen, String tinhThanh);
    
    /**
     *  lấy mã địa chỉ dựa vào tên tỉnh/ thành phố
     * @param name
     * @return 
     */
    public String getMaDiaChiByTinh(String name);
    
    /**
     *  lấy tên tỉnh thành phố dựa vào mã
     * @param id
     * @return 
     */
    public String getTinhByMaDiaChi(String id);
}
