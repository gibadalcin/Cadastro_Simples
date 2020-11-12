/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dConnection;

import domain.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author giba01
 */
public class dbConnection {
    private final String urlBanco="jdbc:postgresql://localhost:5435/project7_PAW";
    private final String usuarioBanco="postgres";
    private final String senhaBanco="";
    private Connection getConnection(){
        
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(urlBanco, usuarioBanco, senhaBanco);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha na conexão com o banco","Erro",JOptionPane.ERROR_MESSAGE);     
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Erro de SQL!!","Erro!" ,JOptionPane.ERROR_MESSAGE); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro desconhecido!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
    
    public int customerRegister(Customer customer){
        int registered = 0;
        try{
            Connection connection = getConnection();
            if(connection != null){
               PreparedStatement record = connection.prepareStatement("INSERT INTO clientes(nome,cpf,idade,telefone,email)"
                        + "VALUES (?,?,?,?,?)");
                    record.setString(1, customer.getNome());
                    record.setString(2, customer.getCpf());
                    record.setInt(3, customer.getIdade());
                    record.setString(4, customer.getTelefone());
                    record.setString(5, customer.getEmail());
                    record.executeUpdate();
                    registered = 1;
                record.close();
                connection.close();      
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
       return registered;
    }
    
    public Customer customerSelect(String cpf){
        Customer customer = null;
        try{
            Connection connection = getConnection();
            if(connection != null){
                PreparedStatement consult = connection.prepareStatement("SELECT*FROM clientes WHERE cpf = '" + cpf + "'"); 
                        ResultSet rs = consult.executeQuery();
                    while(rs.next()){
                        String nome = rs.getString("nome");
                        int idade = rs.getInt("idade");
                        String telefone = rs.getString("telefone");
                        String email = rs.getString("email");
                        customer = new  Customer(nome,cpf,idade,telefone,email);
                    }
                rs.close();
                connection.close();      
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       return customer;
    }
        
       public List<Customer> searchCustomers(String field, String data){
           List<Customer> customers = new ArrayList<>();
           try{
               Connection conn = getConnection();
               if(conn != null){
                   PreparedStatement searchCustomers;
                   if(!field.equals("idade"))
                       searchCustomers = conn.prepareStatement("SELECT * FROM clientes WHERE " +field+ " LIKE '%" +data+ "%'" + "ORDER BY idade ASC");
                   else
                       searchCustomers = conn.prepareStatement("SELECT * FROM clientes WHERE idade = "+ data);
                   
                   ResultSet rs = searchCustomers.executeQuery();
                       while(rs.next())
                       {
                           String nome = rs.getString("nome");
                           String cpf = rs.getString("cpf");
                           int idade = rs.getInt("idade");
                           String telefone = rs.getString("telefone");
                           String email = rs.getString("email");
                           customers.add(new Customer(nome,cpf,idade,telefone,email));
                       }
                   rs.close();
                   searchCustomers.close();
                   conn.close();
               }
            }catch(SQLException e){
             e.printStackTrace();
           }catch(Exception e){
     e.printStackTrace();
           }
           return customers;
       }
           
       public boolean deleteCustomer(String cpf){
           boolean deletedCustomer = false;
           try{
               Connection conn = getConnection();
               if(conn != null){
                   PreparedStatement delete = conn.prepareStatement("DELETE FROM clientes WHERE cpf = '"+cpf+"'"); 
                       deletedCustomer = delete.executeUpdate()>0;                   
                   delete.close();
                   conn.close();
                  }
               }catch(SQLException e){
               e.printStackTrace();          
           }catch(Exception e){
               e.printStackTrace();
           }
           return deletedCustomer;
       }

     
     public boolean updateClient(Customer customer){
         boolean updatedClient=false;
         try{
             Connection conn = getConnection();
             if(conn!=null){
                 PreparedStatement update = conn.prepareStatement("UPDATE clientes set nome=?,"
                         + " idade=?, telefone=?, email=? WHERE cpf=?");                
                 update.setString(1,customer.getNome());
                 update.setInt(2,customer.getIdade());
                 update.setString(3,customer.getTelefone());
                 update.setString(4,customer.getEmail());
                 update.setString(5,customer.getCpf());
                 updatedClient = update.executeUpdate()>0;
                 update.close();
                 conn.close();
             }
         }catch(SQLException e){
             e.printStackTrace();
         }catch(Exception e){
             e.printStackTrace();
         }
         return updatedClient;
     }
}
