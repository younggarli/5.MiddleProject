package pcws.service.taskService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import pcws.dao.taskDao.TaskDao;
import pcws.dao.taskDao.TaskDaoInf;
import pcws.vo.TaskVO;

public class TaskService extends UnicastRemoteObject implements TaskServiceInf {
	private TaskDaoInf taskDao;
	
	public TaskService() throws RemoteException {
		taskDao = TaskDao.getInstance();
	}
	
	@Override
	public boolean individualTask_Create(TaskVO task) throws RemoteException {
		return taskDao.individualTask_Create(task);
	}

	@Override
	public boolean individualTask_Modification(TaskVO task) throws RemoteException {
		return taskDao.individualTask_Modification(task);
	}

	@Override
	public boolean individualTask_Delete(TaskVO task) throws RemoteException {
		return taskDao.individualTask_Delete(task);
	}

	@Override
	public TaskVO getTask(String task) throws RemoteException {
		return taskDao.getTask(task);
	}

	@Override
	public List<TaskVO> individualTask_Read(String mem_id) throws RemoteException {
		return taskDao.individualTask_Read(mem_id);
	}

}
