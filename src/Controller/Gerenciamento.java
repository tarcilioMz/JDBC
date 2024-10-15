/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.*;
import Model.Dados_pessoais;
import DAO.Dados_pessoaisDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muzime
 */
public class Gerenciamento {

    Dados_pessoais dados;
    Dados_pessoaisDAO d;
    List<Dados_pessoais> all;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Gerenciamento() throws IOException {
        d = new Dados_pessoaisDAO();
        all = new ArrayList<>();
        all = d.todos();
        
    }

    public void registarDados_pessoais() throws IOException {
        dados = new Dados_pessoais();

        System.out.println("Insira o ID:");
        dados.setId(Integer.parseInt(br.readLine()));
        System.out.println("Insira o nome: ");
        dados.setNome(br.readLine());
        System.out.println("Insira a idade:");
        dados.setIdade(Integer.parseInt(br.readLine()));
        System.out.println("Insira o endereco:");
        dados.setEndereco(br.readLine());
        System.out.println("Insira o contacto:");
        dados.setContacto(br.readLine());
        d.inserir(dados);
    }

    public void atualizarDados_pessoais() throws IOException {
        System.out.println("Insira o id do estudante:");
        int id = Integer.parseInt(br.readLine());
        Dados_pessoais achado = new Dados_pessoais();
        for (Dados_pessoais da : all) {
            if (da.getId() == id) {
                achado = da;

            }
        }
        System.out.println("");
        System.out.println("Insira o nome: ");
        achado.setNome(br.readLine());
        System.out.println("Insira a idade:");
        achado.setIdade(Integer.parseInt(br.readLine()));
        System.out.println("Insira o endereco:");
        achado.setEndereco(br.readLine());
        System.out.println("Insira o contacto:");
        achado.setContacto(br.readLine());
        d.atualizar(achado);
    }

    public void verTodos() {
        int ps = 1;
        for (Dados_pessoais k : all) {
            System.out.println("Estudante 0" + ps + ""
                    + "\nID: " + k.getId() + ""
                    + "\nNome: " + k.getNome() + ""
                    + "\nIdade: " + k.getIdade() + ""
                    + "\nEndereco: " + k.getEndereco() + ""
                    + "\nContacto: "+ k.getContacto());
            System.out.println("\n");
            ps++;
        }
    }
}
