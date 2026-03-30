/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package SessionBean;

import jakarta.ejb.Stateless;

/**
 *
 * @author User
 */
@Stateless
public class calcbean implements calcbeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Integer addition(int a, int b) {
        return (a + b);
    }

    @Override
    public Integer restar(int a, int b) {
        return (a - b);
    }

    @Override
    public Integer multiplicar(int a, int b) {
        return (a*b);
    }

    @Override
    public Integer dividir(int a, int b) {
        return (a / b);
    }

    @Override
    public Integer modulo(int a, int b) {
        return (a % b);
    }

    @Override
    public Integer elevar(int a) {
        return (a*a);
    }
}
