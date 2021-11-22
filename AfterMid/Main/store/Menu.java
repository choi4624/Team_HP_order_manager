package store;

import java.util.Scanner;

public class Menu {
	Admin admin;
	User user;
	
	void loginMenu(Scanner scan) {
		while(true) {
			System.out.print("id : ");
			String id = scan.next();
			System.out.print("pwd : ");
			String pwd = scan.next();
			
			//?��?��민인�? ?��?�� -> ?��?��민이�? ?��?���? 메뉴�?
			admin = Store.adminMgr.find(id);
			if(admin != null) {
				if(admin.passwordMatch(pwd)) {
					AdminMenu(scan);
					continue;
				}
			}
			
			//?��???���? ?��?�� -> ?��??�? ?��??메뉴�?
			user = Store.userMgr.find(id);
			if(user != null) {
				if(user.passwordMatch(pwd)) {
					UserMenu(scan);
					continue;
				}
			}
			//?��무것?�� ?��?��?���? 계속 반복�? ?���?...
			System.out.println("id?? pwd�? ?��?�� ?��?��?��주세?��.");
			flushLoginBuffer();
		}
						
	}
	
	void UserMenu(Scanner scan) {
		int num;
		while(user != null) {
			System.out.print("(0) 로그?��?�� ");
			num = scan.nextInt();
			switch(num) {
			case 0:
				flushLoginBuffer();
				break;
			default: break;
			}
		}
	}
	
	void AdminMenu(Scanner scan) {
		int num;
		while(admin != null) {
			System.out.print("(1)물품출력 (2)?��?��?��출력 (3)주문출력 (4)�??�� (0)로그?��?�� ");
			num = scan.nextInt();
			switch(num) {
			case 0:
				flushLoginBuffer();
				break;
			case 1: Store.itemMgr.printAll(); break;
			case 2: Store.userMgr.printAll(); break;
			case 3: Store.orderMgr.printAll(); break;
			case 4: searchMenu(scan); break;
			default : break;
			}
		}
	}
	
	void searchMenu(Scanner scan) {
		int num;
		while (true) {
			System.out.print("(1)물품�??�� (2)?��?��?���??�� (3)주문�??�� (기�?) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 3) break;
			switch(num) {
			case 1: Store.itemMgr.searchAll(scan); break;
			case 2: Store.userMgr.searchAll(scan); break;
			case 3: Store.orderMgr.searchAll(scan); break;
			default: break;
			}
		}
	}
	
	void flushLoginBuffer() {
		user = null;
		admin = null;
	}
}
