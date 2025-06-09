-- Criação do banco de dados (opcional: só execute se não existir)
CREATE DATABASE IF NOT EXISTS sistema_cadastro_alunos;
USE sistema_cadastro_alunos;

-- Tabela Aluno
CREATE TABLE IF NOT EXISTS Aluno (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    CPF VARCHAR(14) UNIQUE NOT NULL,
    Email VARCHAR(100),
    Telefone VARCHAR(20),
    Endereco TEXT,
    Data_Cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela Curso
CREATE TABLE IF NOT EXISTS Curso (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    Categoria VARCHAR(50),
    Duracao VARCHAR(50),
    Status ENUM('ativo', 'inativo') DEFAULT 'ativo'
);

-- Tabela Nota (sem CHECK)
CREATE TABLE IF NOT EXISTS Nota (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Aluno INT NOT NULL,
    ID_Curso INT NOT NULL,
    Valor DECIMAL(4,2),
    Data_Lancamento DATETIME DEFAULT NOW(),
	FOREIGN KEY (ID_Aluno) REFERENCES Aluno(ID) ON DELETE CASCADE,
    FOREIGN KEY (ID_Curso) REFERENCES Curso(ID) ON DELETE CASCADE
    );
    



-- Tabela Histórico Acadêmico
CREATE TABLE IF NOT EXISTS HistoricoAcademico (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Aluno INT NOT NULL,
    ID_Curso INT NOT NULL,
    Data_Inicio DATE NOT NULL,
    Data_Conclusao DATE,
    Status ENUM('cursando', 'concluído', 'trancado') DEFAULT 'cursando',
    FOREIGN KEY (ID_Aluno) REFERENCES Aluno(ID) ON DELETE CASCADE,
    FOREIGN KEY (ID_Curso) REFERENCES Curso(ID) ON DELETE CASCADE
);

-- Tabela Funcionário
CREATE TABLE IF NOT EXISTS Funcionario (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    Cargo ENUM('professor', 'administrativo', 'coordenador') NOT NULL,
    Login VARCHAR(50) UNIQUE NOT NULL,
    Senha VARCHAR(255) NOT NULL COMMENT 'Armazenar hash (ex: bcrypt)',
    Data_Cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserção de dados de exemplo (opcional)
INSERT INTO Curso (Nome, Categoria, Duracao) VALUES
    ('Matemática Básica', 'Exatas', '60 horas'),
    ('Português Avançado', 'Humanas', '80 horas');

INSERT INTO Aluno (Nome, CPF, Email) VALUES
    ('João Silva', '123.456.789-09', 'joao@email.com'),
    ('Maria Oliveira', '987.654.321-00', 'maria@email.com');