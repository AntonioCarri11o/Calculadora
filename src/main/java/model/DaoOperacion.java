package model;

import com.mycompany.mavenproject1.Operacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoOperacion {
    public boolean saveOperation(Operacion operacion){
        boolean result=false;
        try(Connection connection=MySQLConnection.getConnection();
            PreparedStatement pstm =connection.prepareStatement("insert into operations (type,first_number,second_number,result) values(?,?,?,?);");
        ){
            pstm.setString(1,operacion.getType());
            pstm.setDouble(2,operacion.getN1());
            pstm.setDouble(3,operacion.getN2());
            pstm.setDouble(4,operacion.getResult());
            result=pstm.executeUpdate()==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public List<Operacion> listOperations(){
        List<Operacion> listOperations= new ArrayList<>();
        try{
            Connection connection=MySQLConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select id, type,first_number,second_number,result,created_at from operations;");
            while (rs.next()){
                Operacion operacion= new Operacion();
                operacion.setId(rs.getInt("id"));
                operacion.setType(rs.getString("type"));
                operacion.setN1(rs.getDouble("first_number"));
                operacion.setN2(rs.getDouble("second_number"));
                operacion.setResult(rs.getDouble("result"));
                operacion.setCreated_at(rs.getString("created_at"));
                listOperations.add(operacion);
            }
            rs.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listOperations;
    }
}
