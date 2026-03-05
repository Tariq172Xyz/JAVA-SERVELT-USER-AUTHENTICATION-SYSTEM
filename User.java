package Web_project_UserAuth;

public class User {
    private int id;
    private String email;
    private String name;
    private String password;


    //to insert data
    public User( String name,String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //to fetch data
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
