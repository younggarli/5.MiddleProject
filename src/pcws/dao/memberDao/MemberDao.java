package pcws.dao.memberDao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.MemberVO;

public class MemberDao implements MemberDaoInf {
	private static MemberDao dao = new MemberDao();
	private SqlMapClient smc;
	
	private MemberDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	@Override
	public boolean checkMember(String mem_id) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.queryForObject("Member.memberCheck",mem_id);
			if(obj != null){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertMember(MemberVO memVo) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("Member.memberInsert",memVo);
			if(obj != null){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getIdSearchMember(MemberVO memVo) throws RemoteException {
		String result = null;
		try {
			result = (String) smc.queryForObject("Member.memberIdSearch", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getPwSearchMember(MemberVO memVo) throws RemoteException {
		String result = null;
		try {
			result = (String) smc.queryForObject("Member.memberPwSearch", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MemberVO logIn(HashMap<String, String> paramMap) throws RemoteException {
		MemberVO mvo = null;
		try {
			mvo = (MemberVO)smc.queryForObject("Member.login", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvo;
	}

	@Override
	public boolean checkIdSearch(MemberVO memVo) throws RemoteException {
		boolean result = false;
		MemberVO mvo = null;
		try {
			mvo = (MemberVO) smc.queryForObject("Member.checkIdSearch", memVo);
			if(mvo!=null) {
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean checkPwSearch(MemberVO memVo) throws RemoteException {
		boolean result = false;
		MemberVO mvo = null;
		try {
			mvo = (MemberVO) smc.queryForObject("Member.checkPwSearch",memVo);
			if(mvo!=null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateMember(MemberVO memVo) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.update("Member.updateMember", memVo);
			if(obj != null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean updateMemberPw(MemberVO memVo) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.update("Member.updateMemberPw", memVo);
			if(obj!=null) {
				result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MemberVO> searchAllMember(String memberInfo) throws RemoteException {
		List<MemberVO> mvo = null;
		try {
			mvo = smc.queryForList("Member.searchAllMember", memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvo;
	}

	@Override
	public List<MemberVO> searchGetMember(String memberInfo) throws RemoteException {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			list = smc.queryForList("Member.searchGetMember", memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean memberOut(MemberVO memVo) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.update("Member.memberOut", memVo);
			if(obj != null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<MemberVO> getAllMember() throws RemoteException {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			list = smc.queryForList("Member.getAllmem");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> searchMem(String name) throws RemoteException {
		List<MemberVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("Member.searchMem", name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



}
