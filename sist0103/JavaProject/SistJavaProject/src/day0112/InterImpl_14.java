package day0112;

interface InterA {
	public void singasong();

	public void draw();
}

///////////////////////////////////////
interface InterB extends InterA {
	public void playgame();

	public void write();
}

///////////////////////////////////////
class Imple implements InterB {

	@Override
	public void playgame() {
		// TODO Auto-generated method stub
		System.out.println("게임을 합니다.");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("글을 씁니다.");
	}

	@Override
	public void singasong() {
		// TODO Auto-generated method stub
		System.out.println("노래를 합니다.");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("그림을 그립니다.");
	}

}

///////////////////////////////////////
public class InterImpl_14 {

	public static void main(String[] args) {
		// 하위클래스
		Imple im;
		im = new Imple();
		im.playgame();
		im.write();
		im.singasong();
		im.draw();
		System.out.println();

		// 다형성
		InterB inb = new Imple();
		inb.singasong();
		inb.draw();
		inb.write();
		inb.playgame();
	}

}
