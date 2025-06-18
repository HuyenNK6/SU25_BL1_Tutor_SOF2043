/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.LoaiOtoVinfast;
import java.util.List;
import util.XQuery;

/**
 *
 * @author Huyen
 */
public class LoaiOtoRepository {
    String getAllSql = """
                       SELECT [id] ,[ma] ,[ten]
                         FROM [DB_DAM_VinFast].[dbo].[LoaiOtoVinfast]
                       """;
    String findByIdSql= """
                        SELECT [id] ,[ma] ,[ten]
                        FROM [DB_DAM_VinFast].[dbo].[LoaiOtoVinfast]
                        WHERE [id] = ?
                        """;
    public List<LoaiOtoVinfast> getAll(){
        return XQuery.getBeanList(LoaiOtoVinfast.class, getAllSql);
    }
    public LoaiOtoVinfast findById(int id){
        return XQuery.getSingleBean(LoaiOtoVinfast.class, findByIdSql, id);
    }
    
    public static void main(String[] args) {
        LoaiOtoRepository repo= new LoaiOtoRepository();
        List<LoaiOtoVinfast> list =repo.getAll();
        for (LoaiOtoVinfast loaiOtoVinfast : list) {
            System.out.println(loaiOtoVinfast.toString());
        }
        LoaiOtoVinfast loai = repo.findById(1);
        System.out.println("Tim thay loai: "+ loai.toString());
    }
}
