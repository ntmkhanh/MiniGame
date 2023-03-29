package TaiXiu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import javax.swing.text.NumberFormatter;

public class Main {

	public static void main(String[] args) {
		//Tai khoan nguoi choi
		double taikhoannguoichoi = 10000;
		int luaChon;
		Scanner sc = new Scanner(System.in);
		// Format number so tien nguoi choi
		Locale lc = new Locale("vi", "VN");
		
//		NumberFormat numf = NumberFormat.getInstance(lc);
			//dinh dang tien te
		NumberFormat numf = NumberFormat.getCurrencyInstance(lc);
		//tao menu cho nguoi choi nhap vao
		do {
			System.out.println("=========Moi ban lua chon=========");
			System.out.println("Chon 1 de tiep tuc choi.");
			System.out.println("Chon phim khac de thoat khoi tro choi");
			luaChon = sc.nextInt();
			if(luaChon == 1) {
				System.out.println("Bat dau tro choi:");
				System.out.println("Tai khoan cua ban co: "+numf.format(taikhoannguoichoi)+", ban muon dat cuoc bao nhieu?");
				// dat cuoc
				double soTienDatCuoc = 0;
				do {
					System.out.print("---Dat cuoc so tien lon hon 0 va nho hon "+numf.format(taikhoannguoichoi) +": ");
					soTienDatCuoc = sc.nextDouble();
				} while(soTienDatCuoc<0 || soTienDatCuoc>taikhoannguoichoi);
				//Chon tai hoac xiu
				int luaChonTaiXiu = 0;
				do {
					System.out.println("Chon: 1 => Tai hoac 2 => Xiu");
					luaChonTaiXiu = sc.nextInt();
				} while(luaChonTaiXiu!=1 && luaChonTaiXiu!=2);
				//Tung xuc sac
				//Su dung class Random
				Random xucsac1 = new Random();
				Random xucsac2 = new Random();
				Random xucsac3 = new Random();
				
				int giatri1=xucsac1.nextInt(5)+1;
				int giatri2=xucsac2.nextInt(5)+1;
				int giatri3=xucsac3.nextInt(5)+1;
				int tong = giatri1 + giatri2 + giatri3;
				//Tinh toan ket qua
				System.out.println("Ket qua: "+giatri1+" - "+giatri2+" - "+giatri3);
					//Neu tong =3 hoac 18 => Cai an het
				if(tong ==3 || tong ==18) {
					taikhoannguoichoi -= soTienDatCuoc;//taikhoannguoichoi = taikhoannguoichoi - soTienDatCuoc;
					System.out.println("Tong la: "+tong+" Ban da thua!");
					System.out.println("Tai khoan cua ban la:"+taikhoannguoichoi);
				} 
					//Tinh ket qua Xiu
				else if(tong <=4 && tong<=10) {
					System.out.println("Tong la: "+tong+" => Xiu");
					if(luaChonTaiXiu == 2) {
						System.out.println("Ban da thang!^^");
						taikhoannguoichoi += soTienDatCuoc;
						System.out.println("Tai khoan cua ban la: "+ taikhoannguoichoi);
					} else {
						System.out.println("Ban da thua!");
						taikhoannguoichoi -= soTienDatCuoc;
						System.out.println("Tai khoan cua ban la: "+ taikhoannguoichoi);
					}
				} 
					//Tinh ket qua Tai
				else {
					System.out.println("Tong la: "+tong+" => Tai");
					if(luaChonTaiXiu == 1) {
						System.out.println("Ban da thang!^^");
						taikhoannguoichoi += soTienDatCuoc;
						System.out.println("Tai khoan cua ban la: "+ taikhoannguoichoi);
					} else {
						System.out.println("Ban da thua!");
						taikhoannguoichoi -= soTienDatCuoc;
						System.out.println("Tai khoan cua ban la: "+ taikhoannguoichoi);
					}
				}

			}
		} while(luaChon==1);

	}

}
//Luat choi:
//	3 vien xuc sac
//	1.Neu tong =3 hoac 18 => Cai an het
//	2. Neu tong 4->10 => xiu 
//	3. Neu tong 11->17 => tai