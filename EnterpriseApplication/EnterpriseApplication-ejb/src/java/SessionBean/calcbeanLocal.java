/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package SessionBean;

import jakarta.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface calcbeanLocal {

    Integer addition(int a, int b);

    Integer restar(int a, int b);

    Integer multiplicar(int a, int b);

    Integer dividir(int a, int b);

    Integer modulo(int a, int b);

    Integer elevar(int a);
}
