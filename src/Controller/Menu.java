/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Gerenciamento;
import java.io.IOException;

/**
 *
 * @author Muzime
 */
public class Menu {

    Gerenciamento gerir;

    public Menu() throws IOException {
        byte opc = 11;
        gerir = new Gerenciamento();

        do {
            System.out.println("Bem vindo ao SEBD!\nOque deseja?");
            System.out.println("""
                           1. Visualizar todos.
                           2. Inserir novo estudante.
                           3. Atualizar dados de estudante Existente.
                           0. Sair""");
            opc = Byte.parseByte(gerir.br.readLine());
            switch (opc) {
                case 1:
                    gerir.verTodos();
                    break;
                case 2:
                    gerir.registarDados_pessoais();
                    break;
                case 3:
                    gerir.atualizarDados_pessoais();
                    break;
                case 0:
                    System.exit(0);

            }
        } while (opc != 0);

    }

}
