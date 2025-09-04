package springdi_anno.bean;

import org.springframework.stereotype.Component;

@Component
public interface Speaker {
	public abstract void printName();
}
