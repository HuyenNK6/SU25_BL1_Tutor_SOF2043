/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Huyen
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OtoVinfast {
    private int id;
    private String ma;
    private String ten;
    private String mauSac;
    private int namSanXuat;//ko đặt tên: namSX -> not valid
    private double giaBan;
    private int idLoai;
    private int trangThai;
}
