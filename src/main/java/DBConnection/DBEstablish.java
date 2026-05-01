package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBEstablish {

    public Connection EstablishConnection() {

        try {
            DBCredentials dbCredentials = new DBCredentials();

            Class.forName(dbCredentials.getDriverBanco());
            Connection connection = DriverManager.getConnection(dbCredentials.getUrl(), dbCredentials.getUsuario(), dbCredentials.getSenha());
            System.out.println("Conexão estabelecida ✅");
            return connection;

        } catch (Exception exception) {
            System.out.println("Erro de conexão");
            return null;
        }
    }
}
