//@version November 5, 2018
public class HourglassVersion2 {
	public static void main(String[] args) {
		base();
		tophalf();
		middle();
		bottomhalf();
		base();

	}
	public static void base() {
		System.out.println("|\"\"\"\"\"\"\"\"\"\"|");
		listofchars('\"', 10);
	}
	public static void tophalf() {
		for (int i=1; i<5; i++) {
			listofchars(' ', i);
			/*for (int j=0;j<i;j++) {
				System.out.print(" ");
			}
			*/
			listofchars('\\', 1);
			/*for (int k=0;k<10-2*i;k++) {
				System.out.print(":");
			}
			*/
			listofchars('/', 1);
			listofchars('\n', 1);
			//System.out.print("/"+"\n");
		}
	}
	public static void middle() {
		listofchars(' ', 5);
		listofchars('|', 2);
		listofchars(' ', 5);
	}
	public static void bottomhalf() {
		for (int i=4; i>0; i--) {
			listofchars(' ', i);
			listofchars('/', 1);
			listofchars(':', 10-2*i);
			listofchars('\\', 1);
			listofchars('\n', 1);
		}
	}
	public static void listofchars(char s, int count) {
		for (int i = 0; i<count; i++) {
			System.out.print(s);
		}
	}
}
