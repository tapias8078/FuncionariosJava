package com.iudigital.view;

import com.iudigital.controller.RolController;
import com.iudigital.dominio.Rol;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void crear(RolController rolController){
        try{
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el rol");
            String nombreRol = sc.nextLine();
            System.out.println("el rol es:"+nombreRol);
            System.out.println("-------------------------");
            
            Rol rol = new Rol();
            
            rol.setNombreRol(nombreRol);
            rolController.crearRol(rol);
            System.out.println("El rol se ha creado con exito");
            sc.close();
            
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
public static void main(String[] args){
    RolController rolController = new RolController();
    crear(rolController);
}
}
