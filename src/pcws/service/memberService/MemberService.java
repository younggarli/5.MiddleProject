package pcws.service.memberService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import pcws.dao.memberDao.MemberDao;
import pcws.dao.memberDao.MemberDaoInf;
import pcws.vo.MemberVO;

public class MemberService extends UnicastRemoteObject implements MemberServiceInf {
	private static final long serialVersionUID = -2467191776783027320L;
	
	private MemberDaoInf dao;
	
	public MemberService() throws RemoteException {
		dao = MemberDao.getInstance();
	}
	
	@Override
	public boolean checkMember(String mem_id) throws RemoteException {
		return dao.checkMember(mem_id);
	}

	@Override
	public boolean insertMember(MemberVO memVo) throws RemoteException {
		return dao.insertMember(memVo);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	}

	@Override
	public String getIdSearchMember(MemberVO memVo) throws RemoteException {
		return dao.getIdSearchMember(memVo);
	}

	@Override
	public String getPwSearchMember(MemberVO memVo) throws RemoteException {
		return dao.getPwSearchMember(memVo);
	}
	
	@Override
	public boolean checkIdSearch(MemberVO memVo) throws RemoteException {
		return dao.checkIdSearch(memVo);
	}
	
	@Override
	public boolean checkPwSearch(MemberVO memVo) throws RemoteException {
		return dao.checkPwSearch(memVo);
	}
	
	@Override
	public boolean updateMemberPw(MemberVO memVo) throws RemoteException {
		return dao.updateMemberPw(memVo);
	}
	
	@Override
	public MemberVO logIn(String mem_id, String mem_pw) throws RemoteException {
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("mem_pw", mem_pw);
		
		return dao.logIn(paramMap);
	}

	@Override
	public List<MemberVO> searchAllMember(String memberInfo) throws RemoteException {
		return dao.searchAllMember(memberInfo);
	}
	@Override
	public List<MemberVO> searchGetMember(String memberInfo) throws RemoteException {
		return dao.searchGetMember(memberInfo);
	}
	
	@Override
	public boolean memberOut(MemberVO memVo) throws RemoteException {
		return dao.memberOut(memVo);
	}

	@Override
	public boolean updateMember(MemberVO memVo) throws RemoteException {
		return dao.updateMember(memVo);
	}

}
