package pcws.service.scheduleService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import pcws.dao.scheduleDao.ScheduleDao;
import pcws.vo.ScheduleVO;

public class ScheduleService extends UnicastRemoteObject implements ScheduleServiceInf {

	ScheduleDao scheduleDao;
	
	// 기본 생성자
	public ScheduleService() throws RemoteException {
		scheduleDao = scheduleDao.getInstance();
	}
	
	@Override
	public boolean memoSave(ScheduleVO svo) throws RemoteException {
		return scheduleDao.memoSave(svo);
	}

	@Override
	public boolean memoDelete(ScheduleVO svo) throws RemoteException {
		return scheduleDao.memoDelete(svo);
	}

	@Override
	public String showMemo(String id, String date) throws RemoteException {
		HashMap<String, String> memoMap = new HashMap<>();
		memoMap.put("id", id);
		memoMap.put("date", date);
		return scheduleDao.showMemo(memoMap);
	}
}
