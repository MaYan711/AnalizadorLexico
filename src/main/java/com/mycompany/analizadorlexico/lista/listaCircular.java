/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.lista;
import com.mycompany.analizadorlexico.Vista_Principal;
import com.mycompany.analizadorlexico.Token;
/**
 *
 * @author LL829
 */
public class listaCircular {
    public static void main(String[] args){
            lista lis = new lista();
            lis.agregar(1);
            lis.agregar(2);
            lis.agregar(3);
            lis.agregar(4);
            lis.agregar(5);
            lis.agregar(6);
            lis.agregar(7);
            lis.agregar(8);
            lis.agregar(9);
            lis.imprimir();
            lis.dibujarGraphviz();
        }
}
