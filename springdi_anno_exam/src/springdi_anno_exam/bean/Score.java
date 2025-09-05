package springdi_anno_exam.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("score")
@Scope("prototype")
public class Score {

	private int kor;
	private int eng;
	private int math;
	private int sum;
	private float avg;

	public Score() {
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return kor+eng+math;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public float getAvg() {
		return (kor+eng+math) / 3.0f;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg=" + avg + "]";
	}

}
