package pcws.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pcws.service.affiliationService.AffiliationService;
import pcws.service.affiliationService.AffiliationServiceInf;
import pcws.service.chathisService.ChathisService;
import pcws.service.chathisService.ChathisServiceInf;
import pcws.service.checkListService.CheckListService;
import pcws.service.checkListService.CheckListServiceInf;
import pcws.service.filesService.FilesService;
import pcws.service.filesService.FilesServiceInf;
import pcws.service.friendService.FriendService;
import pcws.service.friendService.FriendServiceInf;
import pcws.service.memberService.MemberService;
import pcws.service.memberService.MemberServiceInf;
import pcws.service.messageService.MessageService;
import pcws.service.messageService.MessageServiceInf;
import pcws.service.noticeService.NoticeService;
import pcws.service.noticeService.NoticeServiceInf;
import pcws.service.projectService.ProjectService;
import pcws.service.projectService.ProjectServiceInf;
import pcws.service.scheduleService.ScheduleService;
import pcws.service.scheduleService.ScheduleServiceInf;
import pcws.service.taskService.TaskService;
import pcws.service.taskService.TaskServiceInf;
import pcws.service.teamService.TeamService;
import pcws.service.teamService.TeamServiceInf;

public class ServerMain {

	public static void main(String[] args) {
		
		try {
			// RMI용 인터페이스 객체 생성
			AffiliationServiceInf affInf = new AffiliationService();
			ChathisServiceInf chaInf = new ChathisService();
			CheckListServiceInf checkInf = new CheckListService();
			FilesServiceInf fileInf = new FilesService();
			FriendServiceInf friInf = new FriendService();
			MemberServiceInf memInf = new MemberService();
			MessageServiceInf mesInf = new MessageService();
			NoticeServiceInf noticeInf = new NoticeService();
			ProjectServiceInf proInf = new ProjectService();
			ScheduleServiceInf scheduleInf = new ScheduleService();
			TaskServiceInf taskInf = new TaskService();
			TeamServiceInf teamInf = new TeamService();
			
			Registry reg = LocateRegistry.createRegistry(5959); // 서버 포트번호
			
//			reg.rebind("aff_server", affInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
//			reg.rebind("cha_server", chaInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("che_server", checkInf); 		// Registry에 서버에서 제공할 RMI용 객체를 등록
//			reg.rebind("fil_server", fileInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("fri_server", friInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("mem_server", memInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("mes_server", mesInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("not_server", noticeInf);		// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("pro_server", proInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("sch_server", scheduleInf); 		// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("tas_server", taskInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			reg.rebind("tea_server", teamInf); 			// Registry에 서버에서 제공할 RMI용 객체를 등록
			System.out.println("서버 열림");
		} catch (Exception e) {}
		
	}
}
