package pcws.service.friendService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pcws.dao.friendDao.FriendDao;
import pcws.dao.friendDao.FriendDaoInf;
import pcws.vo.FriendVO;
import pcws.vo.YouAndMeVO;

//서비스를 제공하는 RMI
public class FriendService extends UnicastRemoteObject implements FriendServiceInf {
	private FriendDaoInf friendDao;
	
	public FriendService() throws RemoteException {
		friendDao = FriendDao.getInstance();
	}

	@Override
	public List<YouAndMeVO> getAllMember(String frd_mem_id) throws RemoteException {
		return friendDao.getAllMember(frd_mem_id);
	}

	@Override
	public List<FriendVO> getFriendSearch(String frd_mem_id) throws RemoteException {
		return friendDao.getFriendSearch(frd_mem_id);
	}

	@Override
	public boolean getFriend_Add(String frd_mem_id, String frd_id) throws RemoteException {
		Map<String, String> friAddMap = new HashMap<String, String>();
		friAddMap.put("frd_mem_id", frd_mem_id);
		friAddMap.put("frd_id", frd_id);
		return friendDao.getFriend_Add(friAddMap);
	}

	@Override
	public boolean getFriend_Delete(String frd_mem_id, String frd_id) throws RemoteException {
		Map<String, String> friDelMap = new HashMap<String, String>();
		friDelMap.put("frd_mem_id", frd_mem_id);
		friDelMap.put("frd_id", frd_id);
		return friendDao.getFriend_Delete(friDelMap);
	}

}
