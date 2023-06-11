package model.dao;

import model.db.DB;

public class FactoryDAO {

	public static CursoDAO createCursoDAO() {
		return new CursoDAOImp(DB.getConexao());
	}

	public static AlunoDAO createAlunoDAO() {
		// TODO Auto-generated method stub
		return new AlunoDAOImp(DB.getConexao());
	}
	
	public static DisciplinaDAO createDisciplinaDAO() {
		// TODO Auto-generated method stub
		return new DisciplinaDAOImp(DB.getConexao());
	}

}