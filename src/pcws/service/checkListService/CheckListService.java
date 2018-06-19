package pcws.service.checkListService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import pcws.dao.checkListDao.CheckListDao;
import pcws.dao.checkListDao.CheckListDaoInf;
import pcws.vo.CheckListVO;
import pcws.vo.ProjectVO;
import pcws.vo.TaskVO;

public class CheckListService extends UnicastRemoteObject implements CheckListServiceInf {
	private CheckListDaoInf dao;
	
	public CheckListService() throws RemoteException{
		dao = CheckListDao.getInstance();
	}

	@Override
	public boolean checkList_Insert(CheckListVO chklist) throws RemoteException {
		return dao.checkList_Insert(chklist);
	}

	@Override
	public boolean checkList_Delete(CheckListVO chklist) throws RemoteException {
		return dao.checkList_Delete(chklist);
	}

	@Override
	public List<CheckListVO> checkList_Allget(String pj_id) throws RemoteException {
		return dao.checkList_Allget(pj_id);
	}

	@Override
	public boolean checkList_Synchro(List<CheckListVO> list) throws RemoteException {
		return dao.checkList_Synchro(list);
	}

	@Override
	public boolean checkList_update(CheckListVO chk) throws RemoteException {
		return dao.checkList_update(chk);
	}

	@Override
	public int getNoNChkList(ProjectVO pvo) throws RemoteException {
		return dao.getNoNChkList(pvo);
	}

	@Override
	public int getChkList(ProjectVO pvo) throws RemoteException {
		return dao.getChkList(pvo);
	}
}