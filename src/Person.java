public class Person implements Comparable<Person> {

	private String name;
	private int age;
	private int point;

	public Person(String name, int age, int point) {
		super();
		this.name = name;
		this.age = age;
		this.point = point;
	}


	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", point=" + point + "]";
	}

	@Override
	public int compareTo(Person o) {
		if (point < o.point)
			return -1;
		if (point < o.point)
			return 1;
		return 0;
	}
}
