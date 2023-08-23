/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.analizadorlexico;
import java.util.ArrayList;
/**
 *
 * @author LL829
 */
public class analizador {
    ArrayList<Token> lista_token = new ArrayList();
    
    public analizador(ArrayList<Token> lista_token){
        this.lista_token = lista_token;
    }
            
    public void analizar(String cadena){
    int estado = 0;
    int decimal = 0;
    int numero_token = 0;
    String lexema = "";
    String tipo = "";
    String [] lineas = separador(cadena, '\n');
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < lineas[i].length(); j++) {
                int n_actual, n_siguiente = -1;
                
                n_actual = lineas[i].codePointAt(j);
                if (estado == 0){
                    estado = estado_transicion(n_actual);
                }
                try{
                    n_siguiente = lineas[i].codePointAt(j+1);
                }catch(Exception e){
                    
                }
                switch(estado){
                    case 1:
                        lexema = lexema + lineas[i].charAt(j);
                        if ((n_siguiente > 96 && n_siguiente <123) || (n_siguiente > 64 && n_siguiente < 91) ){
                            estado = 1;
                        }else{
                            numero_token = 1;
                            tipo = "Cadena";
                            estado = 0;
                        }
                        break;
                    case 2:
                        lexema = lexema + lineas[i].charAt(j);
                        if(n_siguiente > 47 && n_siguiente < 58){
                            estado =2;
                        }else{
                            numero_token = 2;
                            tipo = "Entero";
                            estado = 0;
                        }
                        break;
                    case 100:
                        estado = -2;
                        break;
                    case 999:
                        lexema = String.valueOf(lineas[i].charAt(j));
                        numero_token = 999;
                        tipo = "Caracter Especial, Aritmetico";
                        estado = 0;
                        break;
                        
                        case 3:
                        lexema = String.valueOf(lineas[i].charAt(j));
                        numero_token = 3;
                        tipo = "Caracter Especial, Comparacion";
                        estado = 0;
                        break;
                        case 4:
                        lexema = String.valueOf(lineas[i].charAt(j));
                        numero_token = 4;
                        tipo = "Caracter Especial, Logicos";
                        estado = 0;
                        break;
                        case 5:
                        lexema = String.valueOf(lineas[i].charAt(j));
                        numero_token = 5;
                        tipo = "Caracter Especial, Asignacion";
                        estado = 0;
                        break;
                        case 6:
                        lexema = String.valueOf(lineas[i].charAt(j));
                        numero_token = 6;
                        tipo = "Caracter Especial, Otros";
                        estado = 0;
                        break;
                    //case 3:
                    //lexema = lexema + lineas[i].charAt(j);
                    //if (numero_token = +){
                    //tipo = "Aritmeticos";
                    //estado = 0;
                    //}
                    
                   //         break
                }
                if (estado == 0){
                  lista_token.add(new Token(lexema, numero_token, i+1,j+1,tipo)); 
                  lexema = "";
                  tipo = ""; 
                                  }
                if (estado == -2){
                    estado = 0;
                }
            }
        }
    }
    
    public int estado_transicion(int n){
        if ((n > 96 && n <123) || (n > 64 && n < 91) ){
          return 1;  
        }else if(n > 47 && n < 58){
            return 2;
        }
        else if(n == 32 || n == 13 || n == 9){
            return 100;
        }else{
            return 999;
        }
        
    }
    
    public String[] separador(String texto, char separar){
    String linea = " ";
    int contador = 0;
    for (int i =0; i<texto.length();i++){
        if(texto.charAt(i) == separar){
            contador++;
        }
    }
    String [] cadenas = new String[contador];
    contador = 0;
    for (int i =0; i<texto.length();i++){
        if(texto.charAt(i) != separar){
            linea = linea + String.valueOf(texto.charAt(i));
        }else{
            cadenas[contador] = linea;
            contador++;
            linea = " ";
        }
    }
    return cadenas;
    }
}

