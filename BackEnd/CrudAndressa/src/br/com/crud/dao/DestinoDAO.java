package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Destino;

public class DestinoDAO {
	
	public void save(Destino Destino) {
		String sql = "Insert INTO Destino(DataIda, DataVolta, QuantidadePessoas, Local)" + "VALUES(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {	
			
			conn = ConnectionFactory.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, Destino.getDataIda());
			
			pstm.setString(2, Destino.getDataVolta());
			
			pstm.setInt(3, Destino.getQuantidadePessoas());
			
			pstm.setString(4, Destino.getLocal());
			
	
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
			
	public void removeById(int id) {
		String sql = "DELETE FROM Destino WHERE Id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Destino Destino) {
		String sql = "UPDATE Destino SET DataIda = ?, DataVolta = ?, QuantidadePessoas = ?, Local = ? WHERE Id_Destino = ? ";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
			conn = ConnectionFactory.createConnectionSQLServer();

		
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, Destino.getDataIda());
			
			pstm.setString(2, Destino.getDataVolta());
			
			pstm.setInt(3, Destino.getQuantidadePessoas());
			
			pstm.setString(4, Destino.getLocal());
	
			pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Destino> getDestino() {

		String sql = "select l.Id_Destino, l.DataIda, l.DataVolta, l.QuantidadePessoas, 1.Local";

		List<Destino> Destino = new ArrayList<Destino>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino Destinos = new Destino();
				
				Destinos.setId_Destino(rset.getInt("Id_Destino"));

				Destinos.setDataIda(rset.getString("DataIda"));

				Destinos.setDataVolta(rset.getString("DataVolta"));
				
				Destinos.setQuantidadePessoas(rset.getInt("QuantidadePessoas"));
				
				Destinos.add(Destinos);
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Destino; 
	}
}

