/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.model.DiaChi;
import java.util.List;

/**
 *
 * @author NGUYENHUNG
 */
public interface DiaChiService {

    public DiaChi getDiaChi(String id);
    
    /**
     * lấy tất cả tỉnh/thành phố
     *
     * @return
     */
    public List<String> getAllTinhThanh();

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
