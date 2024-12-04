package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.Livro;

public class CrudDAO {
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	ArrayList<Livro> lista = new ArrayList<>();
	
	public void CadastrarLivro(Livro livro) {
		String sql = "INSERT INTO livro (nome_livro) VALUES (?)";
		con = new ConectorDAO().conexaoDAO();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, livro.getNome_livro());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Livro> BuscarLivro() {
        String sql = "SELECT * FROM livro";
        con = new ConectorDAO().conexaoDAO();
        
        try {
            pstm = con.prepareStatement(sql);            
            
            rs = pstm.executeQuery(sql);
            
            while (rs.next()) {
                Livro objLivro = new Livro();
                objLivro.setId_livro(rs.getInt("id_libro"));
                objLivro.setNome_livro(rs.getString("nome_livro"));
                
                lista.add(objLivro);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
	
	public void ExcluirLivro(Livro livro) {
		String sql = "DELETE FROM livro WHERE id_libro = ?";
		con = new ConectorDAO().conexaoDAO();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, livro.getId_livro());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	
	
	
}
