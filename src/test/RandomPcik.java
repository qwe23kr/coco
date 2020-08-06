package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomPcik {
	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> pickList = new ArrayList<>();
		for(int i=0;i<1;i++) {
			int rNum = r.nextInt(8)+1;
			pickList.add(rNum);
		}
		Collections.sort(pickList);
		System.out.println(pickList);
		//[1, 3, 6, 7, 13, 14, 19]
		//상영, 현배, 영곤, 상화, 동진, 동혁, 인혁
	}
}
//영곤, 상화, 동진