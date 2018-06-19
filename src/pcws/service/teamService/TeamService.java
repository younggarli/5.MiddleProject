package pcws.service.teamService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import pcws.dao.teamDao.TeamDao;
import pcws.vo.ProjectVO;
import pcws.vo.TeamVO;

public class TeamService extends UnicastRemoteObject implements TeamServiceInf {

	TeamDao teamDao;
	
	// 기본 생성자
	public TeamService() throws RemoteException {
		teamDao = teamDao.getInstance();
	}
	
	@Override
	public boolean Team_Create(TeamVO team) throws RemoteException {
		return teamDao.Team_Create(team);
	}

	@Override
	public List<TeamVO> getAllTeam(ProjectVO project) throws RemoteException{
		return teamDao.getAllTeam(project);
	}

	@Override
	public boolean Team_Delete(TeamVO team) throws RemoteException {
		return teamDao.Team_Delete(team);
	}

}
