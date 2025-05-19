CREATE DATABASE IF NOT EXISTS idle;

USE idle;

CREATE TABLE melhorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_original TEXT NOT NULL,
    melhoria_sugerida TEXT NOT NULL,
    data_sugestao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    utilizada BOOLEAN DEFAULT FALSE
);

SELECT id, codigo_original, melhoria_sugerida, data_sugestao FROM sugestoes 
WHERE utilizada = false ORDER BY data_sugestao DESC;
