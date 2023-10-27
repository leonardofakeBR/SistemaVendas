/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemavendas;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mycompany.dao.DaoCategoria;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.visao.outros.Empresa.MenuPrincipal;
import java.sql.Connection;

/**
 *
 * @author jose_
 */
public class SistemaVendas {
    public static void main(String[] args) {
                if (Formularios.menuPrincipalCliente == null)
            Formularios.menuPrincipalCliente = new MenuPrincipal();
        
        Formularios.menuPrincipalCliente.setVisible(true);
    }
}
