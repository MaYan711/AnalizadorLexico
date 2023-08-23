/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico.lista;
import com.mycompany.analizadorlexico.lista.Nodo;

import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author LL829
 */
public class lista {
    private Nodo primero;
    private Nodo ultimo;
    
    public void agregar(int valor){
        Nodo nuevo = new Nodo();
        nuevo.setValor(valor);
        
        if(primero == null){
            primero = nuevo;
            primero.setSiguiente(primero);
            ultimo = primero;
            
          
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(primero);
            ultimo = nuevo;
            
        }
    } 
    public void imprimir(){
    Nodo temporal = primero;
    
    if(temporal!=null){
        
        do{
            System.out.println(temporal.getValor()+"->");
            temporal = temporal.getSiguiente();
        }while (temporal !=primero);
        System.out.println(temporal.getValor());
        
    }
}
    private String obtenerListaGraphviz(){
        String texto = "diagraph G\n"
        + "{\n"
        +        "     node [shape = circle]\n"
        +        "     node [style = filled]\n"
        +        "     node [fillcolor = \"00933\"]\n"
        +        "     node [color = \"#0522d\"]\n"
        +        "     edge [color = \"#000000\"]\n";
        
        Nodo temporal = primero;
        if(temporal != null){
            
            do{
                texto += temporal.getValor()+"->";
                temporal = temporal.getSiguiente();
                
            }while(temporal != primero);
            texto += temporal.getValor();
            
        }
        
        texto +="null\n";
        texto +="   rankdir = LR;\n"
                + "}";
        return texto;
    }
    
    private void escribirArchivo(String ruta, String contenido){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            pw.write(contenido);
            pw.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            
        }finally{
            if(pw!=null);
            pw.close();
        }
    }
    
    public void dibujarGraphviz(){
        
        try{
            escribirArchivo("archivo.dot", obtenerListaGraphviz());
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "lista.png", "archivo.dot");
            proceso.redirectErrorStream(true);
            proceso.start();
            
           // if(lista == 0){
             //   System.out.println("Grafico generado");
            //}else{
              //  System.out.println("Error al generar grafico");
            //}
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
