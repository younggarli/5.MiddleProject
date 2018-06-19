package pcws.dao.scheduleDao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.ScheduleVO;

public class ScheduleDao implements ScheduleDaoInf {
	
	private static ScheduleDao scheduleDao = new ScheduleDao();
	private SqlMapClient smc;

	private ScheduleDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static ScheduleDao getInstance() {
		return scheduleDao;
	}
	
	@Override
	public boolean memoSave(ScheduleVO svo) {
		boolean result = false;
		try {
			smc.insert("Schedule.insertSchedule", svo);
				result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	@Override
	public boolean memoDelete(ScheduleVO svo) throws RemoteException {
		boolean result = false;
		try {
			int cnt = smc.delete("Schedule.deleteSchedule",svo.getScdu_date());
			if(cnt != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String showMemo(HashMap<String, String> memoMap) throws RemoteException {
		String memo = null;
		try {
			memo = (String)smc.queryForObject("Schedule.showMemo", memoMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memo;
	}
}
