package springaop_exam.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("member")
@Scope("prototype")
public class Member implements Serializable {

	public static final long serialVersionUID = 66299599999L;

	private String mid;
	private String mname;

	public Member() {
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mname=" + mname + "]";
	}

}
