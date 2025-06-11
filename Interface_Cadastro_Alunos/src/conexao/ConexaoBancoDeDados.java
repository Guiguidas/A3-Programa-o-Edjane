package conexao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDados {
    public Connection getConnection (){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_cadastro_alunos","root","senhamysql");
        }catch(SQLException exececao){
           throw new RuntimeException (exececao);   
    }
}
}