package Factory;

import entities.LoadPrompts;
import entities.PromptForm;
import enums.PromptType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MakeDatabase {

    private final Connection conn;

    public MakeDatabase() throws SQLException {
        this.conn = new Factory.ConnectionFactory().getConnection(); // Assumindo que Factory.ConnectionFactory é a sua classe de conexão

        // 1. Criar o banco de dados 'api' se ele não existir
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS api";
        try (PreparedStatement stmtCreateDB = conn.prepareStatement(createDatabaseSQL)) {
            stmtCreateDB.execute();
            System.out.println("Banco de dados 'api' verificado/criado com sucesso.");
        }

        // 2. Usar o banco de dados 'api'
        // É melhor incluir o nome do DB na URL de conexão ou adicioná-lo ao comando SQL
        // Para simplicidade, vamos usar o USE aqui, mas preferencialmente configure na URL da conexão
        String useDatabaseSQL = "USE api";
        try (PreparedStatement stmtUseDB = conn.prepareStatement(useDatabaseSQL)) {
            stmtUseDB.execute();
            System.out.println("Usando o banco de dados 'api'.");
        }

        // 3. Criar a tabela 'prompt'
        String createTableSQL = "CREATE TABLE IF NOT EXISTS prompt ("
                + "Id_Prompt INT PRIMARY KEY AUTO_INCREMENT, "
                + "description VARCHAR(100), "
                + "code VARCHAR(3000)"
                + ");";
        try (PreparedStatement stmtCreateTable = conn.prepareStatement(createTableSQL)) {
            stmtCreateTable.execute();
            System.out.println("Tabela 'prompt' verificada/criada com sucesso.");
        } finally {
            // É importante fechar a conexão no final do ciclo de vida da sua aplicação ou quando não for mais necessária
            // Se esta classe é instanciada apenas para criar o DB/tabela, você pode fechar aqui.
            // Se a conexão for reutilizada, ela deve ser gerenciada em um nível superior.
            if (this.conn != null && !this.conn.isClosed()) {
                this.conn.close();
                System.out.println("Conexão fechada.");
            }
        }
    }

    public static void main(String[] args) {
        try {
            MakeDatabase makeDatabase = new MakeDatabase();
            PromptForm prompt = new PromptForm("IMPROVEMENT", LoadPrompts.loadPrompt("PromptImprovement.txt", ""));
            DaoManager.PromptDao dao = new DaoManager.PromptDao();
            dao.salvaPrompt(prompt);
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar o banco de dados: " + e.getMessage());
        }
    }
}
