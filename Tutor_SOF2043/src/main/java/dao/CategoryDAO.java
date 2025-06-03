/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.util.List;
import util.XQuery;

/**
 *
 * @author Huyen
 */
public class CategoryDAO {
    //1. getAll: truy xuất tất cả đối tượng -> trong bảng Category
    //gõ 3 lần dấu "
    String getAllSql = """
                       SELECT [Id]
                             ,[Name]
                         FROM [PolyCafe].[dbo].[Categories]
                       """;
    public List<Category> getAll(){
        return XQuery.getBeanList(Category.class, getAllSql);
    }
    public static void main(String[] args) {
        List<Category> lstCategories = new CategoryDAO().getAll();
        for (Category cate : lstCategories) {
            System.out.println(cate.toString());
        }
    }
}
