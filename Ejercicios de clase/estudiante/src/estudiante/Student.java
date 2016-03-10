/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante;

/**
 *
 * @author Usuario6
 */
public class Student {
    
    private String idNo;
    private String name;

    public Student(String idNo, String name) {
        this.idNo = idNo;
        this.name = name;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getName() {
        return name;
    }
    
    
}
