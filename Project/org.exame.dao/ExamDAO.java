package org.exame.dao;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
	
	// metodo para obter a conexao
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exame", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// metodo para salvar os componentes no banco dedados
	public int registerExam(String exame, String candidato, Date data) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO STRUTS2CRUD VALUES (?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, exame);
			ps.setString(2, candidato);
			ps.setDate(3, data);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// metodo de busca de todos os elementos do banco de dados
	public ResultSet report() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT EXAME, CANDIDATO, DATA FROM EXAMES";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// metodo de reescrever um elemento apartir de um candidato solicitado dentro do banco de dados
	public ResultSet fetchExamDetails(String candidato) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT EXAME,CANDIDATO,DATA FROM EXAMES WHERE CANDIDATO=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, uemail);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// metodo para reescrever os detalhes do exame
	public int updateExamDetails(String exame, String candidato, Date data, String candidatonovo)
			throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE EXAMES SET EXAME=?,CANDIDATO=?,DATA=? WHERE CANDIDATO=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, exame);
			ps.setString(2, candidato);
			ps.setString(3, data);
			ps.setString(5, candidatonovo);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// metodo para deletar o Exame
	public int deleteExamDetails(String candidato) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM EXAMES WHERE CANDIDATO=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, candidato);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}