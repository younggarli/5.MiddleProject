package pcws.dao.teamDao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.ProjectVO;
import pcws.vo.TeamVO;

public class TeamDao implements TeamDaoInf {

	private static TeamDao TeamDao = new TeamDao();
	private SqlMapClient smc;

	private TeamDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static TeamDao getInstance() {
		return TeamDao;
	}
	
	@Override
	public boolean Team_Create(TeamVO team) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("Team.createTeam", team);
			if(obj!=null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TeamVO> getAllTeam(ProjectVO project) throws RemoteException {
		List<TeamVO> list = new ArrayList<TeamVO>();
		try {
			list = smc.queryForList("Team.getAllTeam",project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean Team_Delete(TeamVO team) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.delete("Team.deleteTeam",team);
			if(obj!=null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


}
