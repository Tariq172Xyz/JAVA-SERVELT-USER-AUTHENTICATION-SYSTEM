package Web_project_UserAuth;

import java.sql.*;


public class UserDAO {
    private static final String url="jdbc:mysql://127.0.0.1:3306/authdb";
    private static final String username="your_username";
    private static final String password="your_password";
    Connection connection;


        public UserDAO(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection=DriverManager.getConnection(url,username,password);
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }



    public User validateUser(String email,String password){
        String query="SELECT * FROM user WHERE email=? AND password=?";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
           ResultSet resultSet= preparedStatement.executeQuery();
           if (resultSet.next()){
               return new User(resultSet.getInt("id"),
                       resultSet.getString("name"),
                       resultSet.getString("email"),
                       resultSet.getString("password"));
           }

        }catch (SQLException e){
            e.printStackTrace();
        }
       return null;
    }

    public boolean saveUser(String name,String email,String password) {
        String query = "INSERT INTO user (name,email,password) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }


    }
}
