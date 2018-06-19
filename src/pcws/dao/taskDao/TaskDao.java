package pcws.dao.taskDao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.TaskVO;

public class TaskDao implements TaskDaoInf {
	private static TaskDao TaskDao = new TaskDao();
	private SqlMapClient smc;
	
	private TaskDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static TaskDao getInstance() {
		return TaskDao;
	}
	
	@Override
	public boolean individualTask_Create(TaskVO task) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("taskDao.taskInsert",task);
			if(obj == null){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean individualTask_Modification(TaskVO task) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("taskDao.taskUpdate",task);
			if(obj == null){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean individualTask_Delete(TaskVO task) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("taskDao.taskDelete",task);
			if(obj == null){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TaskVO> individualTask_Read(String mem_id) throws RemoteException {
		List<TaskVO> taskList = null;
		try {
			taskList = smc.queryForList("taskDao.getTaskAll",mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskList;
	}

	@Override
	public TaskVO getTask(String task_num) throws RemoteException {
		TaskVO task = new TaskVO();
		try {
			task = (TaskVO) smc.queryForList("taskDao.getTask",task_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

}
