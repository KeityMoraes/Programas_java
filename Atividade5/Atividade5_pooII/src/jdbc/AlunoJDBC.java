package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {

	private Connection con;
	private String sql;
	private PreparedStatement pst;

	public void salvar(Aluno a) throws SQLException {

		try {
			con = db.getConexao();
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			Date dataSql = Date.valueOf(a.getDt_nasc());
			pst.setDate(3, dataSql);
			pst.executeUpdate();
			System.out.println("Cadastro do aluno realizado com sucesso!");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pst.close();
			db.closeConexao();
		}
	}

	public List<Aluno> listar() throws SQLException {
		List<Aluno> alunos = new ArrayList<>();
		try {
			con = db.getConexao();
			sql = "SELECT * FROM aluno";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDt_nasc(rs.getDate("dt_nasc").toLocalDate());
				alunos.add(aluno);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pst.close();
			db.closeConexao();
		}

		return alunos;
	}

	public void apagar(int id) throws SQLException {
		try {
			con = db.getConexao();
			sql = "DELETE FROM aluno WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("Aluno removido com sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pst.close();
			db.closeConexao();
		}
	}

	public void alterar(Aluno a) throws SQLException {
		try {
			con = db.getConexao();
			sql = "UPDATE aluno SET nome = ?, sexo = ?, dt_nasc = ? WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			Date dataSql = Date.valueOf(a.getDt_nasc());
			pst.setDate(3, dataSql);
			pst.setInt(4, a.getId());
			pst.executeUpdate();
			System.out.println("Aluno atualizado com sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pst.close();
			db.closeConexao();
		}
	}
	
	public Aluno buscarPorId(int id) throws SQLException {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Aluno aluno = null;

	    try {
	        conn = getConnection();
	        String sql = "SELECT * FROM aluno WHERE id = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            aluno = new Aluno();
	            aluno.setId(rs.getInt("id"));
	            aluno.setNome(rs.getString("nome"));
	            aluno.setSexo(rs.getString("sexo"));
	            aluno.setDt_nasc(rs.getDate("dt_nasc").toLocalDate());
	        }

	        return aluno;
	    } finally {
	        closeResources(conn, stmt, rs);
	    }
	}

	private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao fechar recursos: " + e.getMessage());
	    }
	}

	private Connection getConnection() throws SQLException {
	    String url = "jdbc:mysql://localhost:3306/escola?useSSL=false&useTimezone=true&serverTimezone=UTC";
	    String user = "root";
	    String password = "senha";
	    Connection conn = DriverManager.getConnection(url, user, password);
	    return conn;
	}


	public void atualizar(Aluno aluno) throws SQLException {
	    String sql = "UPDATE aluno SET nome = ?, sexo = ?, dt_nasc = ? WHERE id = ?";

	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, aluno.getNome());
	    ps.setString(2, aluno.getSexo());
	    ps.setDate(3, Date.valueOf(aluno.getDt_nasc()));
	    ps.setInt(4, aluno.getId());

	    ps.executeUpdate();
	    ps.close();
	}



}