package pcws.dao.checkListDao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.CheckListVO;
import pcws.vo.ProjectVO;
import pcws.vo.TaskVO;

public class CheckListDao implements CheckListDaoInf {
	private static CheckListDao dao = new CheckListDao();
	private SqlMapClient smc;
	
	public CheckListDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static CheckListDao getInstance() {
		return dao;
	}

	@Override
	public boolean checkList_Insert(CheckListVO chklist) throws RemoteException {
		boolean chk = false;
		try {
			Object obj = smc.insert("CheckListDao.checkList_Insert",chklist);
			if(obj!=null) {
				chk=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public boolean checkList_Delete(CheckListVO chklist) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.delete("CheckListDao.checkList_Delete",chklist);
			if(obj!=null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CheckListVO> checkList_Allget(String pj_id) throws RemoteException {
		List<CheckListVO> list = null;
		try {
			list = smc.queryForList("CheckListDao.checkList_Allget",pj_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean checkList_Synchro(List<CheckListVO> list) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkList_update(CheckListVO chk) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.update("CheckListDao.checkList_update",chk);
			if(obj!=null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getChkList(ProjectVO pvo) throws RemoteException {
		int result = 0;
		try {
			result = (int) smc.queryForObject("CheckListDao.getChkList",pvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getNoNChkList(ProjectVO pvo) throws RemoteException {
		int result = 0;
		try {
			result = (int) smc.queryForObject("CheckListDao.getNoNChkList",pvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
