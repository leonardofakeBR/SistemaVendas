/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemavendas;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mycompany.visao.outros.MenuPrincipal;

/**
 *
 * @author leonardo.35903
 */
public class SistemaVendas {

    public static void main(String[] args) {
        BancoDeDadosMySql.conectar();
        MenuPrincipal menuprincipal = new MenuPrincipal();
        
        menuprincipal.setVisible(true);
    }
}
