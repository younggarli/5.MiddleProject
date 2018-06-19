package pcws.service.noticeService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import pcws.dao.noticeDao.NoticeDao;
import pcws.dao.noticeDao.NoticeDaoInf;
import pcws.vo.NoTaPrMeVO;

// 서비스를 제공하는 RMI
public class NoticeService extends UnicastRemoteObject implements NoticeServiceInf {
	private NoticeDaoInf noticeDao;
	
	public NoticeService() throws RemoteException{
		noticeDao = NoticeDao.getInstance();
	}
	
	@Override
	public List<NoTaPrMeVO> getAlarm_Task_Dday(String mem_id) throws RemoteException {
		return noticeDao.getAlarm_Task_Dday(mem_id);
	}

	@Override
	public List<NoTaPrMeVO> getAlarm_NewProject(String mem_id) throws RemoteException {
		return noticeDao.getAlarm_NewProject(mem_id);
	}

	@Override
	public List<NoTaPrMeVO> getAlarm_NewMessage(String mem_id) throws RemoteException {
		return noticeDao.getAlarm_NewMessage(mem_id);
	}

	@Override
	public boolean Del_Alarm_Task(int ntc_num) throws RemoteException {
		return noticeDao.Del_Alarm_Task(ntc_num);
	}

	@Override
	public boolean Del_Alarm_Project(int ntc_num) throws RemoteException {
		return noticeDao.Del_Alarm_Project(ntc_num);
	}

	@Override
	public boolean Del_Alarm_Message(int ntc_num) throws RemoteException {
		return noticeDao.Del_Alarm_Message(ntc_num);
	}

}
