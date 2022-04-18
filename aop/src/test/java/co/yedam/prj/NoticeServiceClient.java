package co.yedam.prj;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.yedam.prj.notice.service.NoticeService;
import co.yedam.prj.notice.vo.NoticeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/*-context.xml")

public class NoticeServiceClient {
	
	@Autowired NoticeService service;
	
	@Test
	public void list() {
		List<NoticeVO> list = service.noticeSelectList(1);
	}
}
