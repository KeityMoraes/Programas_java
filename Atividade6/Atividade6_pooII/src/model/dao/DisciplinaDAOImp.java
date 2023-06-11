package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.DB;
import model.entities.Disciplina;

public class DisciplinaDAOImp implements DisciplinaDAO {

	private Connection conexao;
	
	public DisciplinaDAOImp(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Disciplina obj) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String sql = "INSERT INTO Disciplina (nomeDisciplina, cargahoraria) VALUES (?, ?)";
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNomeDisciplina());
			pst.setInt(2, obj.getCargahoraria());
			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {
				rs = pst.getGeneratedKeys();
				rs.next();
				obj.setIdDisciplina(rs.getInt(1));
				System.out.println(obj.toString() + " foi criado com sucesso !");
			}
			else {
				System.out.println("N�o foi poss�vel cadastrar o Disciplina !");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Disciplina obj) {
		PreparedStatement pst = null;

		try {
			String sql = "UPDATE disciplina SET nomedisciplina = ?, cargahoraria = ? WHERE iddisciplina = ?";
			pst = conexao.prepareStatement(sql);
			pst.setString(1, obj.getNomeDisciplina());
			pst.setInt(2, obj.getCargahoraria());
			pst.setInt(3, obj.getIdDisciplina());
			int linhas = pst.executeUpdate();

			if (linhas > 0) {
				System.out.println(obj.toString() + " foi atualizado com sucesso!");
			} else {
				System.out.println("Não foi possível atualizar a disciplina!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Disciplina findById(Integer id) {
		
		return null;
	}

	@Override
	public List<Disciplina> findAll() {
	PreparedStatement pst = null;
	ResultSet rs = null;
	List <Disciplina> lista = new ArrayList<>();
	try {
		pst = conexao.prepareStatement("SELECT * FROM Disciplina"); //pst prepara o SQL
		rs = pst.executeQuery(); //aqui executa a query, update, insert, etc... (rs)
		//System.out.println(pst);
		while (rs.next()) {
			Disciplina c = new Disciplina(rs.getInt("idDisciplina"), rs.getString("nomeDisciplina"), rs.getInt("cargahoraria")); //puxar e dar o result set do banco
			lista.add(c);
		}
	} catch (Exception e) {
		e.getMessage();
	}
	finally {
		DB.fechaPreparedStatement(pst);
		DB.fechaResultSet(rs);
	}
		//return null;
		return lista;
	}

}