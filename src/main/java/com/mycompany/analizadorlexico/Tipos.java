/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico;

/**
 *
 * @author LL829
 */
public enum Tipos {
    ID("Identificador"), ARITMETICO("Aritmético"), COMPARACION("Comparación"), 
    LOGICOS("Lógicos"), ASIGNACION("Asignacion"), PALABRASCLAVE("Plabra Clave"),
    CONSTANTES("Constantes"), COMENTARIO("Comentario"), OTROS("Otros");
    private String tipo;
    
    private Tipos(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return tipo;
    }
}