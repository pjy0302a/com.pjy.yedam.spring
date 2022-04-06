package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;

	@Autowired
	private String saveDir;

	// 요청들 처리하는 메소드 작성
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model, NoticeVO vo) {
		// 페이징 구문을 집어넣어야한다.
		model.addAttribute("notices", noticeDao.noticeSelectList(vo.startPage,vo.pageScale));
		return "notice/noticeList";
	}

	@RequestMapping("/noticeInputForm.do")
	public String noticeInputForm(Model model) {
		return "notice/noticeInputForm";
	}

	@RequestMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		if (file.isEmpty()) {
			noticeDao.noticeInsert(vo);
		} else {
			File folder = new File(saveDir);
			String originalFilename = file.getOriginalFilename();
			String saveFilename = UUID.randomUUID().toString()
					+ originalFilename.substring(originalFilename.lastIndexOf('.'));

			try {
				file.transferTo(new File(folder, saveFilename));
				saveFilename = saveDir + saveFilename;
				vo.setFileName(originalFilename);
				vo.setUuidFile(saveFilename);
				noticeDao.noticeInsert(vo);

			} catch (IllegalStateException | IOException e) { // 물리적 위치에 저장
				e.printStackTrace();
			}
		}
		return "redirect:noticeList.do";
	}
}
