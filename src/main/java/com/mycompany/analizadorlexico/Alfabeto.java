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
public class Alfabeto {
    public static char[]Letras = {'A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b', 'c', 'd','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static char[]Numeros = { '1', '2', '3', '4','5','6','7','8','9','0'};
    public static char[]Aritemeticos = {'+', '-','*','/','%', };
    public static char[]Comparacion = { '=','>','<','!'};
    public static String []Logicos = {"and", "or", "not","False", "Treu" };
    public static String [] PlabrasClave = {"as", "assert", "break", "class", "continue","def", "del", "elif", "else", "except", "Fase", "finally", "for", "from", "global", "if", "import", "in", "is", "lmabda", "None", "nomlocal", "not", "or", "pas", "raise", "return", "true", "try", "while", "with", "yield", "Matz"};
    public static char[] Otros = {'(',')','[',']', '{','}',',',';',':'};
}
