package fr.opensagres.eclipse.forms.samples.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fr.opensagres.eclipse.forms.samples.model.Person;

public class PersonService implements IPersonService {

	private static final IPersonService INSTANCE = new PersonService();
	private Map<Long, Person> persons = new HashMap<Long, Person>();

	public PersonService() {
		for (int i = 0; i < 10; i++) {
			Person person = new Person();
			person.getId();
			person.setName("Name" + i);
			this.savePerson(person);
		}
	}

	public static IPersonService getInstance() {
		return INSTANCE;
	}

	public Person getPerson(long id) {
		Person person = persons.get(id);
		if (person == null) {
			return null;
		}
		person.setDirty(true);
		// Emulate Person instance
		Person newPerson = new Person();
		newPerson.setName(person.getName());
		newPerson.setId(person.getId());
		return newPerson;
	}

	public Person savePerson(Person person) {
		person.setDirty(true);
		// Emulate Person instance
		Person newPerson = new Person();
		newPerson.setName(person.getName());
		newPerson.setId(person.getId());
		persons.put(newPerson.getId(), newPerson);
		return newPerson;
	}

	public Collection<Person> getPersons() {
		return Collections.unmodifiableCollection(persons.values());
	}
}