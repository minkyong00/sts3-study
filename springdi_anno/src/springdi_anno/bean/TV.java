package springdi_anno.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class TV {

	// @Autowired: tv가 speaker를 필요할 때 자동 주입해주는 어노테이션
	// @Qualifier: 어떤 스피커를 주입할건지 알려주는 어노테이션

	@Autowired
//	@Qualifier("samsungspeaker")
	@Qualifier("lgspeaker")
	private Speaker speaker;

	public TV() {
		System.out.println("TV객체 생성됨!");
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public String toString() {
		return "TV [speaker=" + speaker + "]";
	}

}
