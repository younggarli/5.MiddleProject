package pcws.dao.friendDao;

import java.io.Reader;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.FriendVO;
import pcws.vo.YouAndMeVO;

public class FriendDao implements FriendDaoInf {
	private static FriendDao friDao = new FriendDao();
	private SqlMapClient smc;
	
	private FriendDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static FriendDao getInstance() {
		return friDao;
	}
	
	@Override
	public List<YouAndMeVO> getAllMember(String frd_mem_id) throws RemoteException {
		List<YouAndMeVO> allMember = null;
		try {
			allMember = smc.queryForList("friend.getAllMember", frd_mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allMember;
	}

	@Override
	public List<FriendVO> getFriendSearch(String frd_mem_id) throws RemoteException {
		List<FriendVO> friendSearch = null;
		try {
			friendSearch = smc.queryForList("friend.getAllMember", frd_mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return friendSearch;
	}

	@Override
	public boolean getFriend_Add(Map<String, String> friAddMap) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("friend.getFriend_Add", friAddMap);
			if(obj != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean getFriend_Delete(Map<String, String> friDelMap) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.delete("friend.getFriend_Delete", friDelMap);
			if(obj != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
