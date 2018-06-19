package pcws.service.projectService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import pcws.dao.memberDao.MemberDao;
import pcws.dao.memberDao.MemberDaoInf;
import pcws.dao.projectDao.ProjectDao;
import pcws.dao.projectDao.ProjectDaoInf;
import pcws.vo.MemberVO;
import pcws.vo.ProjectVO;
import pcws.vo.ScheduleVO;

public class ProjectService extends UnicastRemoteObject implements ProjectServiceInf {

	ProjectDaoInf projectDao;
	MemberDaoInf memberDao;
	
	// 기본 생성자
	public ProjectService() throws RemoteException {
		projectDao = ProjectDao.getInstance();
		memberDao = MemberDao.getInstance();
	}
	
	@Override
	public ProjectVO project_Create(String mem_id, ProjectVO pvo) throws RemoteException {
		HashMap<String, Object> proMap = new HashMap<>();
		pvo.setPj_id(mem_id+"M");
//		proMap.put("pvo", (ProjectVO)pvo);
		return projectDao.project_Create(pvo);
	}
	
//	@Override
//	public boolean project_Drop(String pj_id) throws RemoteException {
//		return projectDao.project_Drop(pj_id);
//	}

	@Override
	public List<ProjectVO> chkProjectCount(String mem_id) throws RemoteException {
		return projectDao.chkProjectCount(mem_id);
	}

	@Override
	public boolean project_update(ProjectVO pvo) throws RemoteException {
		return projectDao.project_update(pvo);
	}

	@Override
	public boolean project_delete(ProjectVO pvo) throws RemoteException {
		return projectDao.project_delete(pvo);
	}
	
	@Override
	public List<MemberVO> getAllMember() throws RemoteException {
		return memberDao.getAllMember();
	}

	@Override
	public List<MemberVO> searchMem(String name) throws RemoteException {
		return memberDao.searchMem(name);
	}

	@Override
	public boolean insert_notice(String pj_id) throws RemoteException {
		return projectDao.insert_notice(pj_id);
	}

	@Override
	public ProjectVO getProject(MemberVO mem) throws RemoteException {
		return projectDao.getProject(mem);
	}

	@Override
	public List<ProjectVO> getAllPro() throws RemoteException {
		return projectDao.getAllPro();
	}

	@Override
	public List<ProjectVO> selectPro(String proNm) throws RemoteException {
		return projectDao.selectPro(proNm);
	}

	

}
