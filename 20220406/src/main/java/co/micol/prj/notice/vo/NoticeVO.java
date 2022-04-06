package co.micol.prj.notice.vo;

import java.sql.Date;

import co.micol.prj.comm.PageVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO extends PageVO{
	private int id;
	private String title;
	private String content;
	private Date wdate;
	private int hit;
	private String fileName;
	private String uuidFile;
}
