/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.*;

/**
 *
 * @author Huyen
 */
//@Getter
//@Setter
//@ToString
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor!
@Builder
//@Data
@AllArgsConstructor
@NoArgsConstructor

public class Category {
    private String id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
    
}
