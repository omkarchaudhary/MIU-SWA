
package persons;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class Person {

	@Id @GeneratedValue private Long id;

	private String name;

	@Relationship(type = "TEAMMATE")
	public Set<Person> teammates= new HashSet<>();

	private Person() {
	};

	public Person(String name) {
		this.name = name;
	}

	public void worksWith(Person person) {
		teammates.add(person);
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", teammates=" + teammates +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
