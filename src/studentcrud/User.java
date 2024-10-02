package studentcrud;

public class User {
private int id;
private String name;
private String email;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
}
public User( String name, String email) {
	this.name=name;
	this.email=email;
}

}
