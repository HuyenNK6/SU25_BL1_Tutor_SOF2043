/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Sach;
import java.util.List;
import util.XJdbc;
import util.XQuery;

/**
 *
 * @author Huyen
 */
public class SachDAO {
    String getAllSql="""
                     SELECT TOP (1000) [id]
                           ,[ma],[ten]
                           ,[soTrang],[donGia]
                           ,[idNxb],[trangThai]
                       FROM [DB_DAM_Sach_NXB].[dbo].[sach]
                     """;
    String insertSql="""
                     INSERT INTO [dbo].[sach]
                                ([ma],[ten]
                                ,[soTrang],[donGia]
                                ,[idNxb],[trangThai])
                          VALUES
                                (?,?,?,?,?,?)
                     """;
    public List<Sach> getAll(){
        return XQuery.getBeanList(Sach.class, getAllSql);
    }
    public int create(Sach sach){
        Object[] values = {
            sach.getMa(),
            sach.getTen(),
            sach.getSoTrang(),
            sach.getDonGia(),
            sach.getIdNxb(),
            sach.getTrangThai()
        };
        return XJdbc.executeUpdate(insertSql, values);
    }
    public static void main(String[] args) {
        SachDAO dao = new SachDAO();
        List<Sach> lst= dao.getAll();
        for (Sach sach : lst) {
            System.out.println(sach.toString());
        }
        //tìm hiểu Builder
//        Sach sach = new Sach(1, "S007", "Hat giong tam hon", 200, 85000, 2, 1);
//        int ketQua= dao.create(sach);
//        System.out.println("So ban ghi thuc hien: "+ ketQua);
    }
}
