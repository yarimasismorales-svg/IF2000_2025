package domainlab3;

public class Person {
    //Atributes
    private String name;
    private  String LastName;
    private  String id;
    private String phone;
    private int age;

    public Person(String name,String LastName, String id, String phone,int age){
    this.name = name;
    this.LastName = LastName;
    this.id = id;
    this.phone = phone;
    this.age = age;
    }
    

    public Person(){}
   public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return LastName;
    }
    public void setLastname(String lastname) {
        LastName = lastname;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return age;
    }   
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" 
        + name + ", Lastname=" + LastName + ", id=" + id + ", phone=" + phone + ", age=" + age
            +"]";
}

    
}
