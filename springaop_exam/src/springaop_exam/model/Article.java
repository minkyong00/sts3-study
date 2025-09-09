package springaop_exam.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Article implements Serializable {

	public static final long serialVersionUID = 999222665L;

	private int aid;
	private String atitle;
	private String acontent;
	private String mid;

	public Article() {
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Article [aid=" + aid + ", atitle=" + atitle + ", acontent=" + acontent + ", mid=" + mid + "]";
	}

}
