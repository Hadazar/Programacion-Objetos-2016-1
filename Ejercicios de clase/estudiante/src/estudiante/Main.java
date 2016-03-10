/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante;

import java.util.*;

/**
 *
 * @author Usuario6
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<Student>();
        
        Student a = new Student("1","F");
        Student b = new Student("2","I");
        Student c = new Student("3","V");
        
        students.add(a);
        students.add(b);
        students.add(c);
        
        for(Student s : students){
            System.out.println(s.getName());
        }
        
        HashMap<String, Student> students2 = new HashMap<String, Student>();
        
        Student d = new Student("3","F");
        Student e = new Student("2","I");
        Student f = new Student("1","V");
        
        students2.put(d.getIdNo(), d);
        students2.put(e.getIdNo(), e);
        students2.put(f.getIdNo(), f);
        
        Student buscado = students2.get("2");
        
        if(buscado != null){
            System.out.println("Lo encontré");
        }
        
        for(Student s : students2.values()){
            System.out.println("ID: " + s.getIdNo());
            System.out.println("Name: " + s.getName());
            System.out.println("");
        }
        
        TreeMap<String, Student> students3 = new TreeMap<String, Student>();
        
        Student g = new Student("3","F");
        Student h = new Student("2","I");
        Student i = new Student("1","V");
        
        students3.put(g.getIdNo(), g);
        students3.put(h.getIdNo(), h);
        students3.put(i.getIdNo(), i);
        
        Student buscado2 = students3.get("2");
        
        if(buscado != null){
            System.out.println("Lo encontré");
        }
        
        for(Student s : students3.values()){
            System.out.println("ID: " + s.getIdNo());
            System.out.println("Name: " + s.getName());
            System.out.println("");
        }
    }
    
}
