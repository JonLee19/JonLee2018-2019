//This class prints out a ten line hourglass using limited println statements
//@author Jon Lee
//@version October 26, 2018
public class Hourglass {
	public static void main(String[] args) {
		base();
		tophalf();
		middle();
		bottomhalf();
		base();

	}
	public static void base() {
		System.out.println("|\"\"\"\"\"\"\"\"\"\"|");
	}
	public static void tophalf() {
		for (int i=1; i<5; i++) {
			for (int j=0;j<i;j++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			for (int k=0;k<10-2*i;k++) {
				System.out.print(":");
			}
			System.out.print("/"+"\n");
		}
	}
	public static void middle() {
		System.out.println("     ||     ");
	}
	public static void bottomhalf() {
		for (int i=4; i>0; i--) {
			for (int j=0;j<i;j++) {
				System.out.print(" ");
			}
			System.out.print("/");
			for (int k=0;k<10-2*i;k++) {
				System.out.print(":");
			}
			System.out.print("\\"+"\n");
		}
	}
}
