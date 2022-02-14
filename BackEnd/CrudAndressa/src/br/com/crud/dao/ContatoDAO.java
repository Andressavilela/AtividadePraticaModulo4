package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Contato;

public class ContatoDAO {
	
	public void save(Contato Contato) {
		String sql = "Insert INTO Contatos(Nome, Email, DataCadastro)" + "VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {	
			
			conn = ConnectionFactory.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, Contato.getNome());
			
			pstm.setString(2, Contato.getEmail());
			
			pstm.setString(3, Contato.getDataCadastro());
			
			pstm.execute();
						
		} catch (Exception e) {
			e.printStackTrace();					
		} finally {
			
			try {
				if(pstm !=null) {
				conn.close();	
				}
				
			if(conn != null) {
				conn.close();
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
					
			
		}
	}
}
	
	
			