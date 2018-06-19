package pcws.dao.noticeDao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.NoTaPrMeVO;
import pcws.vo.NoticeVO;

public class NoticeDao implements NoticeDaoInf {
	private static NoticeDao noticeDao = new NoticeDao();
	private SqlMapClient smc;

	private NoticeDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static NoticeDao getInstance() {
		return noticeDao;
	}

	@Override
	public List<NoTaPrMeVO> getAlarm_Task_Dday(String mem_id) throws RemoteException {
		List<NoTaPrMeVO> alarm_task = null;
		try {
			alarm_task = smc.queryForList("notice.getAlarm_Task_Dday", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alarm_task;
	}

	@Override
	public List<NoTaPrMeVO> getAlarm_NewProject(String mem_id) throws RemoteException {
		List<NoTaPrMeVO> alarm_project = null;
		try {
			alarm_project = smc.queryForList("notice.getAlarm_NewProject", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alarm_project;
	}

	@Override
	public List<NoTaPrMeVO> getAlarm_NewMessage(String mem_id) throws RemoteException {
		List<NoTaPrMeVO> alarm_message = null;
		try {
			alarm_message = smc.queryForList("notice.getAlarm_NewMessage", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alarm_message;
	}

	@Override
	public boolean Del_Alarm_Task(int ntc_num) throws RemoteException {
		boolean result = false;
		try {
			int cnt = smc.delete("notice.Del_Alarm_Task", ntc_num);
			if(cnt != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean Del_Alarm_Project(int ntc_num) throws RemoteException {
		boolean result = false;
		try {
			int cnt = smc.delete("notice.Del_Alarm_Project", ntc_num);
			if(cnt != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean Del_Alarm_Message(int ntc_num) throws RemoteException {
		boolean result = false;
		try {
			int cnt = smc.delete("notice.Del_Alarm_Message", ntc_num);
			if(cnt != 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
	
}
