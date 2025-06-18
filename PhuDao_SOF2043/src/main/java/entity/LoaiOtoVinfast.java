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
@Data//@Getter @Setter @ToString @Equal....
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoaiOtoVinfast {
    private int id;
    private String ma;
    private String ten;

    @Override
    public String toString() {
        return  ten;
    }
    
}
