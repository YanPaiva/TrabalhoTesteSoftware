create database testesoftware;

use database testesoftware;

create TABLE aluno (
	id_aluno  int NOT NULL,
	nome varchar(100) NOT NULL,
	nota FLOAT(7,2) NULL,
	PRIMARY KEY (id_aluno)
);


create TABLE atividade (
	id_atividade  int NOT NULL,
	descricao varchar(100) NOT NULL,
	PRIMARY KEY (id_atividade)
);


create TABLE grupo (
	id_grupo  int NOT NULL,
	id_atividade  int NOT NULL,
	nome varchar(100) NOT NULL,
	nota FLOAT(7,2) NULL,
	PRIMARY KEY (id_grupo),
	FOREIGN KEY (id_atividade) REFERENCES atividade(id_atividade)
);

create TABLE grupo_aluno (
	id_grupo  int NOT NULL,
	id_aluno  int NOT NULL,
	FOREIGN KEY (id_grupo) REFERENCES grupo(id_grupo),
	FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
);
 