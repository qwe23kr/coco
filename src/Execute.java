import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Execute {
	public static void main(String[] args) {
		List<Person> pList = new ArrayList<>();
		pList.add(new Person("동혁", 22, 80));
		pList.add(new Person("상화", 33, 90));
		pList.add(new Person("인혁", 32, 95));
		Collections.sort(pList);
		System.out.println(pList);
	}
}
