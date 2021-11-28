/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.model.DiaDanh;
import java.util.List;

/**
 *
 * @author NGUYE
 */
public interface DiaDanhService {
    public boolean addDiaDanh(DiaDanh diaDanh);
    public boolean updateDiaDanh(DiaDanh diaDanh);
    public boolean deleteDiaDanh(String id);
    public DiaDanh getDiaDanh(String id);
    public List<DiaDanh> getDiaDanhs();
    public List<DiaDanh> getDiaDanh(int numPage);
    public int getSoLuongDiaDanh();
}
