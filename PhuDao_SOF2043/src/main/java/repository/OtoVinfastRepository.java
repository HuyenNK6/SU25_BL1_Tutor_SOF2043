/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.OtoVinfast;
import java.util.List;
import util.XJdbc;
import util.XQuery;

/**
 *
 * @author Huyen
 */
public class OtoVinfastRepository {
    //gõ 3 lần dấu nháy kép
    String getAllSql = """
                       SELECT [id],[ma],[ten]
                             ,[mausac] ,[namsanxuat],[giaban]
                             ,[idloai],[trangthai]
                         FROM [DB_DAM_VinFast].[dbo].[OtoVinfast]
                       """;
    String deleteSql = """
                       DELETE FROM [dbo].[OtoVinfast]
                             WHERE id = ?
                       """;
    String createSql = """
                       INSERT INTO [dbo].[OtoVinfast]
                                  ([ma]
                                  ,[ten]
                                  ,[mausac]
                                  ,[namsanxuat]
                                  ,[giaban]
                                  ,[idloai]
                                  ,[trangthai])
                            VALUES
                                  (?,?,?,?,?,?,?)
                       """;
    //lấy danh sách Oto từ DB
    public List<OtoVinfast> getAll(){
        return XQuery.getBeanList(OtoVinfast.class, getAllSql);
    }
    public int delete(int id){
        return XJdbc.executeUpdate(deleteSql, id);
    }
    public int create(OtoVinfast oto){
        //sử dụng XJdbc  hay XQuery? 
        Object[] values = {
            oto.getMa(),
            oto.getTen(),
            oto.getMauSac(),
            oto.getNamSanXuat(),
            oto.getGiaBan(),
            oto.getIdLoai(),
            oto.getTrangThai()
        };
        return XJdbc.executeUpdate(createSql, values);
    }
            
    public static void main(String[] args) {
        //test
        OtoVinfastRepository repo = new OtoVinfastRepository();
        List<OtoVinfast> list= repo.getAll();
        for (OtoVinfast otoVinfast : list) {
            System.out.println(otoVinfast.toString());
        }
    }
}
