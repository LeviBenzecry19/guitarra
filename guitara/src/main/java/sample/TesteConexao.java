package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sistema_login"; // Nome do banco que você criou
        String user = "root";
        String password = ""; // padrão do XAMPP

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexão bem-sucedida!");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar:");
            e.printStackTrace();
        }
    }
}
