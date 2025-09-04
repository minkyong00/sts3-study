package springdi_anno.bean;

import org.springframework.stereotype.Component;

@Component("lgspeaker")
public class LGSpeaker implements Speaker{

	@Override
	public void printName() {
		System.out.println("알쥐스피커!");
	}
	
}
