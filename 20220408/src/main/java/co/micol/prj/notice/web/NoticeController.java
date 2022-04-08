package co.micol.prj.notice.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;

	@RequestMapping("/noticeSelectList.do")
	public String noticeList(@RequestParam int page, Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(page));
		return "notice/noticeList";
	}
	@PostMapping("/noticeSearch.do")
	@ResponseBody
	public List<NoticeVO> noticeSearch(@RequestParam String key,@RequestParam String val) {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = noticeDao.noticeSearchList(key, val);
		return list;
	}
}
