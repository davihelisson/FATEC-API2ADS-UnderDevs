package daoManager;

import factory.ConnectionFactory;
import entities.LoadPrompts;
import entities.PromptForm;
import enums.PromptType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class PromptDao {

    private Connection connection;

    public PromptDao() {
        this.connection = new ConnectionFactory().getConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE DATABASE IF NOT EXISTS api");
            stmt.execute("USE api");
            boolean tableExists = checkTableExists("prompt");
            if (!tableExists) {
                String createTableSql = "CREATE TABLE prompt (" // Removido IF NOT EXISTS aqui
                        + "Id_Prompt INT PRIMARY KEY AUTO_INCREMENT, "
                        + "description VARCHAR(100) NOT NULL, "
                        + "code TEXT"
                        + ");";
                stmt.execute(createTableSql);

                // Popular a tabela com dados iniciais
                populateInitialData();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar o banco de dados", e);
        }
    }

    /**
     * Verifica se uma tabela específica existe no banco de dados.
     *
     * @param tableName O nome da tabela a ser verificada.
     * @return true se a tabela existir, false caso contrário.
     * @throws SQLException Se ocorrer um erro ao acessar os metadados do banco
     * de dados.
     */
    private boolean checkTableExists(String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[]{"TABLE"});
        return resultSet.next(); // Retorna true se houver uma próxima linha (tabela encontrada)
    }

    /**
     * Popula a tabela 'prompt' com dados iniciais predefinidos. Carrega o
     * conteúdo dos prompts de arquivos e os salva no banco de dados.
     */
    private void populateInitialData() {
        daoManager.PromptDao dao = new daoManager.PromptDao();

        List<PromptData> promptsToSeed = Arrays.asList(
                new PromptData("IMPROVEMENT", "PromptImprovement.txt"),
                new PromptData("UNITTEST", "PromptUnitTest.txt"),
                new PromptData("EXPLANATION", "PromptExplanation.txt"),
                new PromptData("DOCUMENTATION", "PromptDocumentation.txt")
        );

        for (PromptData data : promptsToSeed) {
            try {
                String content = LoadPrompts.loadPrompt(data.filePath, "");
                PromptForm promptForm = new PromptForm(data.description, content);
                dao.salvaPrompt(promptForm);
                System.out.println("Prompt '" + data.description + "' inserido com sucesso.");
            } catch (Exception e) {
                System.err.println("Erro ao inserir o prompt '" + data.description + "': " + e.getMessage());
            }
        }
    }

    /**
     * Salva um novo registro de prompt no banco de dados.
     *
     * @param prompt O objeto {@link PromptForm} contendo a descrição e o código
     * do prompt a ser salvo.
     * @throws RuntimeException Se ocorrer um erro de SQL durante a inserção dos
     * dados.
     */
    public void salvaPrompt(PromptForm prompt) {
        String sql = "INSERT INTO prompt(description, code) VALUES(?, ?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, prompt.getDescricao());
                stmt.setString(2, prompt.getCodigo());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    /**
     * Lista todos os registros de prompt existentes no banco de dados.
     *
     * @return Uma {@link List} de objetos {@link PromptForm}, cada um
     * representando um prompt com seu ID, descrição e código. Retorna uma lista
     * vazia se não houver prompts ou se ocorrer um erro.
     * @throws RuntimeException Se ocorrer um erro de SQL durante a recuperação
     * dos dados.
     */
    public List<PromptForm> listarPrompts() {
        List<PromptForm> list = new ArrayList<>();
        try {
            String sql = "SELECT Id_Prompt, description, code FROM prompt";
            try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("Id_Prompt");
                    String description = rs.getString("description");
                    String code = rs.getString("code");
                    PromptForm prompt = new PromptForm(id, description, code);
                    list.add(prompt);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * Atualiza um registro de prompt existente no banco de dados.
     *
     * @param prompt O objeto {@link PromptForm} contendo os dados atualizados
     * do prompt, incluindo descrição, código e ID para identificação.
     * @throws RuntimeException Se ocorrer um erro de SQL durante a atualização.
     */
    public void atualizaPrompt(PromptForm prompt) {
        try {
            String sql = "UPDATE prompt SET description = ?, code = ? WHERE Id_Prompt = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, prompt.getDescricao());
                stmt.setString(2, prompt.getCodigo());
                stmt.setInt(3, prompt.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Exclui um registro de prompt do banco de dados.
     *
     * @param id O ID do prompt a ser excluído.
     * @throws RuntimeException Se ocorrer um erro de SQL durante a exclusão.
     */
    public void deletaPrompt(int id) {
        try {
            String sql = "DELETE FROM prompt WHERE Id_Prompt = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca e concatena códigos de prompt do banco de dados.
     *
     * @param type O código inteiro que representa o tipo de prompt.
     * @return Uma String contendo os códigos de prompt encontrados, separados
     * por quebras de linha. Retorna uma String vazia se nenhum prompt for
     * encontrado ou se o tipo for inválido.
     */
    public String getPrompt(int type) {
        String sql = "SELECT code FROM prompt WHERE description = ?";
        StringBuilder allPromptCodes = new StringBuilder();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            String description = PromptType.getByCodigo(type).toString();
            stmt.setString(1, description);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String currentCode = rs.getString("code");
                    if (currentCode != null) {
                        allPromptCodes.append(currentCode);
                        if (!rs.isLast()) {
                            allPromptCodes.append("\n");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PromptDao.class.getName()).log(java.util.logging.Level.SEVERE, "Erro ao obter prompts: " + ex.getMessage(), ex);
        } catch (IllegalArgumentException e) {
            Logger.getLogger(PromptDao.class.getName()).log(java.util.logging.Level.WARNING, () -> "Tipo de prompt inválido: " + type + ". " + e.getMessage());
        }
        return allPromptCodes.toString();
    }
    /**
     * Classe interna para armazenar dados de um prompt a ser inserido. Contém a
     * descrição do prompt e o caminho do arquivo onde seu conteúdo está
     * armazenado.
     */
    private static class PromptData {
        
        final String description;
        final String filePath;
        
        PromptData(String description, String filePath) {
            this.description = description;
            this.filePath = filePath;
        }
    }
}
