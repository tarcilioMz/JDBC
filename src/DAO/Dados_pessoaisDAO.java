/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Dados_pessoais;
import java.util.AbstractList;

/**
 *
 * @author Muzime
 */
public class Dados_pessoaisDAO {

    private Connection conexao;
// mnkjhjlhljjljjlkggffsdmvhjjnjjj
    public Dados_pessoaisDAO() {
        try {
            this.conexao = BDConection.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dados_pessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserir(Dados_pessoais dados_pessoais) {
        String sql = "INSERT INTO dados_pessoais(id,nome,idade,endereco,contacto) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, dados_pessoais.getId());
            ps.setString(2, dados_pessoais.getNome());
            ps.setInt(3, dados_pessoais.getIdade());
            ps.setString(4, dados_pessoais.getEndereco());
            ps.setString(5, dados_pessoais.getContacto());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Dados_pessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(Dados_pessoais dados_pessoais) {
        String sql = "Update dados_pessoais SET nome=?,idade=?,endereco=?,contacto=? Where id=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, dados_pessoais.getNome());
            ps.setInt(2, dados_pessoais.getIdade());
            ps.setString(3, dados_pessoais.getEndereco());
            ps.setString(4, dados_pessoais.getContacto());
            ps.setInt(5, dados_pessoais.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Dados_pessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Dados_pessoais> todos() {

        String sql = "SELECT * FROM dados_pessoais";
        try {
            List<Dados_pessoais> lista = new ArrayList<>();
            Statement ps = conexao.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            
            while (rs.next()) {
                Dados_pessoais d = new Dados_pessoais();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setIdade(rs.getInt("idade"));
                d.setEndereco(rs.getString("endereco"));
                d.setContacto(rs.getString("contacto"));
                lista.add(d);
            }
            ps.close();
            rs.close();
            return lista; 
        } catch (SQLException ex) {
            Logger.getLogger(Dados_pessoais.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
       

    }

}
