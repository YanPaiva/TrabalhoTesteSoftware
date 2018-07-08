create database testesoftware;

use database testesoftware;

create TABLE aluno (
	id_aluno  int NOT NULL,
	nome varchar(100) NOT NULL,
	PRIMARY KEY (id_aluno)
);


create TABLE atividade (
	id_atividade  int NOT NULL,
        id_disciplina int NOT NULL,
	disciplina varchar(100) NULL,
        descricao varchar(100) NOT NULL,
	PRIMARY KEY (id_atividade)
);

create TABLE atividade_aluno (
	id_atividade  int NOT NULL,
        id_aluno int NOT NULL,
	nota FLOAT(7,2) NULL,
	FOREIGN KEY (id_atividade) REFERENCES atividade(id_atividade)
        FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno)
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
 

/*
drop table atividade_aluno;
drop table grupo_aluno;
drop table aluno;
drop table grupo;
drop table atividade;

Para fazer o json funcionar precisa rodar esse comando:
json-server --watch atividades.json
*/