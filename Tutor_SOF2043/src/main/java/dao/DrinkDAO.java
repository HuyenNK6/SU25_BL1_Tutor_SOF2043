/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Drink;
import java.util.List;
import util.XJdbc;
import util.XQuery;

/**
 *
 * @author Huyen
 */
public class DrinkDAO {
    String getAllSql = """
                       SELECT  [Id],[Name],[UnitPrice],[Discount]
                             ,[Image],[Available] ,[CategoryId]
                         FROM [PolyCafe].[dbo].[Drinks]
                       """; 
    //Cách 1: xử lý categoryID -> name -> Join bảng vs Category
    String createSql = """
                       INSERT INTO [dbo].[Drinks]
                                  ([Id],[Name] ,[UnitPrice]
                                  ,[Discount],[Image] ,[Available],[CategoryId])
                            VALUES
                                  (?,?,?,?,?,?,?)
                       """;
    String updateSql = """
                       UPDATE [dbo].[Drinks]
                          SET [Name] = ? ,[UnitPrice] = ?,[Discount] = ?
                             ,[Image] = ?,[Available] = ?,[CategoryId] = ?
                        WHERE [Id] = ?
                       """;
    String deleteSql = """
                       DELETE FROM [dbo].[Drinks]
                             WHERE Id = ?
                       """;
    public List<Drink> getAll(){
        return XQuery.getBeanList(Drink.class, getAllSql);
    }
    public int create(Drink drink){
        //sử dụng XJdbc hay XQuery?? 
        //=> XJdbc => executeQuery hay executeUpdate???
        //=> executeUpdate => có 7 dấu ? => 7 value? => Mảng Object
        Object[] values= {
            drink.getId(),
            drink.getName(),
            drink.getUnitPrice(),
            drink.getDiscount(),
            drink.getImage(),
            drink.isAvailable(),
            drink.getCategoryId()
        };
        return XJdbc.executeUpdate(createSql, values);// trả về số lượng bản ghi đã thực hiện
    }
    public int update(Drink drink){
        Object[] values= {
            drink.getName(),
            drink.getUnitPrice(),
            drink.getDiscount(),
            drink.getImage(),
            drink.isAvailable(),
            drink.getCategoryId(),
            drink.getId(),
        };
        return XJdbc.executeUpdate(updateSql, values);// trả về số lượng bản ghi đã thực hiện
    }
    public int delete(String id){
        return XJdbc.executeUpdate(deleteSql, id);
    }
    public static void main(String[] args) {
        DrinkDAO dao= new DrinkDAO();
        //test get All
//        List<Drink> lstDrinks= dao.getAll();
//        for (Drink drink : lstDrinks) {
//            System.out.println(drink.toString());
//        }
        //test create => nếu thành công chạy 1 lần
//        Drink d = new Drink("D02", "Nuoc ep tao", "image.png", 30000, 0.1, true, "C02");
//        int result = dao.create(d);
//        System.out.println("So luong ban ghi thuc hien = "+ result);
        //test update 
//        Drink d = new Drink("D02", "Nuoc ep tao le", "image.png", 35000, 0.1, true, "C02");
//        int result = dao.update(d);
//        System.out.println("So luong ban ghi thuc hien = "+ result);
        
        int ketQuaXoa= dao.delete("21CCEEE5");
         System.out.println("So luong ban ghi thuc hien = "+ ketQuaXoa);
    }
}
