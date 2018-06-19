package pcws.dao.projectDao;

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
import pcws.vo.ProjectVO;
import pcws.vo.ScheduleVO;


public class ProjectDao implements ProjectDaoInf {

	private static ProjectDao projectDao = new ProjectDao();
	private SqlMapClient smc;

	private ProjectDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static ProjectDao getInstance() {
		return projectDao;
	}
	
	@Override
	public ProjectVO project_Create(ProjectVO proMap) throws RemoteException {
		ProjectVO pvo = null;
		try {
			smc.insert("Project.createPro", proMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proMap;
	}

	@Override
	public boolean project_Drop(String pj_id) throws RemoteException {
		boolean result = false;
		try {
			int cnt = smc.delete("Project.deletePro", pj_id);
			if(cnt != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ProjectVO> chkProjectCount(String mem_id) throws RemoteException {
		List<ProjectVO> list = new ArrayList<ProjectVO>();
		try {
			list = smc.queryForList("Project.chkProjectCount",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean project_update(ProjectVO pvo) throws RemoteException {
		boolean result=false;
		try {
			Object obj = smc.update("Project.updatePro",pvo);
			if(obj != null) {
				result = true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean project_delete(ProjectVO pvo) throws RemoteException {
		boolean result=false;
		try {
			Object obj = smc.update("Project.deletePro",pvo);
			if(obj != null) {
				result = true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insert_notice(String pj_id) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("notice.insertNotice", pj_id);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ProjectVO getProject(MemberVO mem) throws RemoteException {
		ProjectVO result = null;
		try {
			result = (ProjectVO) smc.queryForObject("Project.getProject",mem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ProjectVO> getAllPro() throws RemoteException {
		List<ProjectVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("Project.getAllPro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProjectVO> selectPro(String proNm) throws RemoteException {
		List<ProjectVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("Project.selectPro", proNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
