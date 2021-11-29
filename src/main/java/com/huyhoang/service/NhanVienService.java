/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.model.NhanVien;
import java.util.List;

/**
 *
 * @author NGUYE
 */
public interface NhanVienService {

    public boolean addNhanVien(NhanVien diaDanh);

    public boolean updateNhanVien(NhanVien diaDanh);

    public boolean deleteNhanVien(String id);

    public NhanVien getNhanVien(String id);

    public List<NhanVien> getNhanViens();

    public List<NhanVien> getNhanVien(int numPage);

    public int getSoLuongNhanVien();

}
