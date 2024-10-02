package studentcrud;

import java.util.Objects;

public class Student {
private int id;
String name;
String gmail;
public Student(int id, String name, String gmail) {
	super();
	this.id = id;
	this.name = name;
	this.gmail = gmail;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGmail() {
	return gmail;
}
public void setGmail(String gmail) {
	this.gmail = gmail;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", gmail=" + gmail + "]";
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	return id == other.id;
}

}
