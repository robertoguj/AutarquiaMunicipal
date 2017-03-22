SELECT A.ID, A.DESCRICAO_INFRACAO FROM MULTAS A JOIN DIVIDAS_MULTAS B ON B.MULTA_ID = A.ID WHERE B.DIVIDA_ID=1;




CREATE TABLE DIVIDAS
(
  id serial NOT NULL,
  dt_inscricao date,
  status character varying(255),
  vl_divida double precision,
  pessoa_id integer,
  CONSTRAINT dividas_pkey PRIMARY KEY (id),
  CONSTRAINT pessoa_fkey FOREIGN KEY (pessoa_id)
      REFERENCES pessoa_fkey (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE DIVIDAS_MULTAS
(
  divida_id integer NOT NULL,
  multa_id integer NOT NULL,
  CONSTRAINT divida_fkey FOREIGN KEY (divida_id)
      REFERENCES dividas (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT multa_fkey FOREIGN KEY (multa_id)
      REFERENCES multas (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE MULTAS
(
  id serial NOT NULL,
  dt_vencimento date,
  codigo_infracao character varying(255),
  dt_infracao date,
  descricao_infracao character varying(255),
  hr_infracao time without time zone,
  id_auto_infracao character varying(255),
  local_infracao character varying(255),
  status character varying(255),
  vl_multa double precision,
  veiculo_id integer,
  CONSTRAINT multas_pkey PRIMARY KEY (id),
  CONSTRAINT veiculo_fkey FOREIGN KEY (veiculo_id)
      REFERENCES veiculo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE NOTIFICACAO
(
  id serial NOT NULL,
  nu_aviso_recebimento character varying(255),
  dt_postagem date,
  divida_id integer,
  CONSTRAINT notificacao_pkey PRIMARY KEY (id),
  CONSTRAINT divida_fkey FOREIGN KEY (divida_id)
      REFERENCES dividas (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE PESSOA
(
  id serial NOT NULL,
  cnpj character varying(255),
  cpf character varying(255),
  bairro character varying(255),
  cep character varying(255),
  complemento character varying(255),
  endereco character varying(255),
  municipio character varying(255),
  uf character varying(255),
  nome character varying(255),
  pessoa_tipo character varying(255),
  CONSTRAINT pessoa_pkey PRIMARY KEY (id)
)

CREATE TABLE RECURSO
(
  id serial NOT NULL,
  nu_processo character varying(255),
  multa_id integer,
  status character varying(255),
  dt_abertura_processo date,
  CONSTRAINT recurso_pkey PRIMARY KEY (id),
  CONSTRAINT multa_fkey FOREIGN KEY (multa_id)
      REFERENCES multas (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE VEICULO
(
  id serial NOT NULL,
  ano_fabricacao integer,
  chassi character varying(255),
  modelo character varying(255),
  placa character varying(255),
  pessoa_id integer,
  CONSTRAINT veiculo_pkey PRIMARY KEY (id),
  CONSTRAINT pessoa_fkey FOREIGN KEY (pessoa_id)
      REFERENCES pessoa (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)








create database db;
create table tbNovela (
codigo_novela int,
nome_novela varchar(30),
data_primeiro_capitulo date,
data_ultimo_capitulo date,
horario_exibicao time,
constraint pk_codigoNovela primary key (codigo_novela));

create table tbAtor(
codigo_ator int,
nome_ator varchar(20),
idade_ator int,
cidade_ator varchar(20),
salario_ator double,
sexo_ator varchar(1),
constraint pk_codigoAtor primary key (codigo_ator));

create table tbPersonagem(
codigo_personagem int,
codigo_ator int,
nome_personagem varchar(50),
idade_personagem int,
situacao_financeira_personagem varchar(20),
constraint pk_codigoPersonagem primary key (codigo_personagem),
constraint fk_codigoAtor foreign key (codigo_ator) references tbAtor (codigo_ator));

create table tbCapitulos(
codigo_capitulo int,
codigo_novela int,
nome_capitulo varchar(50),
data_exibicao_capitulo date,
constraint pk_codigoCapitulo primary key (codigo_capitulo));

create table tbNovelaPersonagem(
codigo_novela int(10) not null,
codigo_personagem int(10) not null,
constraint pk_codigo_novelaPersonagem primary key (codigo_novela, codigo_personagem),
constraint fk_codigo_novela foreign key (codigo_novela) references tbNovela (codigo_novela),
constraint fk_codigo_personagem foreign key (codigo_personagem) references tbPersonagem (codigo_personagem));

use db;

insert into tbAtor values (1,'FORTALEZA',36,'JOAO ANANIAS',2.500,'M');
insert into tbAtor values (2,'ITAREMA',39,'JOSE TOBIAS',8.500,'M');
insert into tbAtor values (3,'CAMOCIM',42,'ANTONIO FURTADO',9.000,'M');

insert into tbNovela values (1,'A VIAGEM','1977/06/24','1978/06/11','14:00:00');
insert into tbNovela values (2,'A PADROEIRA','1964/02/28','1965/03/25','21:00:00');
insert into tbNovela values (3,'TORRE DE BABEL','1957/09/02','1958/08/30','19:00:00');

insert into tbPersonagem values (1,1,'FRANCISCO OLIVEIRA',36,'NADA CONSTA');
insert into tbPersonagem values (2,3,'MARCOS ROCHA',36,'SPC SERASA');
insert into tbPersonagem values (3,2,'ANTONIO MARQUES',36,'SPC SERASA');

insert into tbCapitulos values (1,1,'ANACONDA','1977/12/05');
insert into tbCapitulos values (2,2,'TORRE DA ORCA','200/01/06');
insert into tbCapitulos values (3,1,'MIRANDINHA','2004/11/15');


-- Mostra a data de exibição do último capítulo para a novela “Mistérios de uma Vida”. 
SELECT DATA_ULTIMO_CAPITULO FROM TBNOVELA WHERE NOME_NOVELA LIKE ‘%MISTÉRIOS DE UMA VIDA%’

-- Mostra todas as novelas que tenham o valor do horário de exibição vazio (null). 
SELECT * FROM TBNOVELA WHERE HORARIO_EXIBICAO IS NULL

-- Mostra o nome de todos os atores que morem em cidades que comecem com a letra “M”. 
SELECT NOME_ATOR * FROM TBATOR WHERE CIDADE_ATOR LIKE ‘M%’

-- Mostra a quantidade de novelas que tenham como parte do nome a palavra “vida”. 
SELECT COUNT(CODIGO_NOVELA) AS QTDE_NOVELAS FROM TBNOVELA WHERE NOME_NOVELA LIKE ‘%VIDA%’

-- Mostra a quantidade de novelas que o ator “Fernando Souza” participou. 
SELECT COUNT(CODIGO_NOVELA) AS QTDE_NOVELAS FROM TBNOVELA WHERE (SELECT * FROM TBATOR WHERE NOME_ATOR LIKE ‘%FERNANDO SOUZA%’)

-- Mostra todos os campos da tabela tbPersonagem ordenados por nome em ordem crescente. 
SELECT * FROM TBPERSONAGEM ORDER BY NOME_PERSONAGEM ASC

-- Mostra todos os campos da tabela tbPersonagem ordenados por idade em ordem decrescente. 
SELECT * FROM TBPERSONAGEM ORDER BY IDADE_PERSONAGEM DESC

-- Mostra quantos atores existem cadastrados. 
SELECT COUNT(CODIGO_ATOR) AS QTDE_ATORES FROM TBATOR

-- Mostra quantas novelas existem cadastradas. 
SELECT COUNT(CODIGO_NOVELA) AS QTDE_NOVELAS FROM TBNOVELA

-- Mostra quantos capítulos existem por novela. Retorne o nome da novela e a quantidade de capítulos para a novela. 
SELECT A.NOME_NOVELA, COUNT(B.CODIGO_CAPITULO) FROM TBNOVELA A 
JOIN TBCAPITULOS B ON A.CODIGO_NOVELA = B.CODIGO_NOVELA GROUP BY A.NOME_NOVELA

-- Mostra quantos atores são do sexo feminino. 
SELECT COUT() * FROM TBATOR WHERE SEXO_ATOR = ‘F’

-- Mostra uma consulta que retorna a idade média dos personagens. 
SELECT AVG(IDADE_PERSONAGEM) AS MEDIA * FROM TBPERSONAGEM

-- Mostra quantos personagens têm menos de 15 anos. 
SELECT COUT(IDADE_PERSONAGEM < 15) AS MENOR_Q15 * FROM TBPERSONAGEM

-- Mostra o nome dos atores que têm a mesma idade do seu personagem. 
SELECT NOME_ATOR FROM TBATOR A JOIN TBPERSONAGEM B ON B.CODIGO_ATOR = A.CODIGO_ATOR WHERE A.IDADE_ATOR = B.IDADE_PERSONAGEM

-- Mostra qual o maior salário. 
SELECT MAX(SALARIO_ATOR) AS MAIOR_SALARIO * FROM TBATOR

-- Mostra qual o menor salário. 
SELECT MIN(SALARIO_ATOR) AS MAIOR_SALARIO * FROM TBATOR

-- Mostra o somatório de todos os salários. 
SELECT SUM(SALARIO_ATOR) AS TOTAL_SALARIOS * FROM TBATOR

-- Mostra a quantidade de personagens representados para cada ator. 
SELECT COUNT(CODIGO_PERSONAGEM) AS QTDE_PERSONAGENS FROM TBPERSONAGEM A JOIN TBATOR B ON B.CODIGO_ATOR = A.CODIGO_ATOR GROUP BY B.NOME_ATOR





-- Mostra o nome e matrícula de todos os alunos que entraram no semestre 2010.2
SELECT NOME, MAT FROM ALUNO WHERE SEMESTRE='2010.2';


-- Mostra o nome e matrícula de todos os alunos do curso de Administração ordenados por ordem alfabética 
SELECT A.MAT AS MATRICULA, A.NOME FROM ALUNO A JOIN CURSO C ON A.CODCURSO=C.COD WHERE C.NOME='Administração' ORDER BY A.NOME;


-- Mostra o nome do curso e o número de professores de cada curso.
SELECT C.NOME AS CURSO, COUNT(P.NOME) AS QTDE_PROFESSORES FROM CURSO C JOIN PROFESSOR P ON C.COD = P.CODCURSO GROUP BY C.NOME


-- Mostra o nome da disciplina, nome do curso e o professor que está ministrando-a, agrupadas por curso e ordenadas por ordem alfabética dentro do mesmo curso.
SELECT 
	C.NOME AS CURSO,
	D.NOME AS DISCIPLINA,
	P.NOME AS PROFESSOR

FROM CURSO C JOIN PROFESSOR P ON C.COD = P.COD JOIN DISCIPLINA D ON D.CODPROFESSOR = P.COD GROUP BY C.NOME ORDER BY C.NOME ASC


-- Mostra o nome e curso dos professores que não ministram disciplinas.
SELECT
	P.NOME AS PROFESSOR,
	C.NOME AS CURSO

FROM CURSO C JOIN PROFESSOR P ON C.COD = P.CODCURSO
	WHERE NOT EXISTS (SELECT D.CODPROFESSOR FROM DISCIPLINA D WHERE D.CODPROFESSOR = P.COD);

	
-- Mostra o nome das disciplinas que o aluno José Inácio está matriculado (tabela Oferta).
SELECT NOME AS DISCIPLINAS FROM DISCIPLINA WHERE COD IN(SELECT CODDISCIPLINA FROM TURMA WHERE COD IN (SELECT CODTURMA FROM OFERTA WHERE MAT IN (SELECT MAT FROM ALUNO WHERE NOME='JOSÉ INÁCIO')));


-- Mostra o nome e a média de cada aluno da disciplina de Introdução a Computação.
SELECT
	A.NOME AS ALUNO,
	((OFERTA.NOTA1 + OFERTA.NOTA2)/2) AS MEDIA
FROM ALUNO A JOIN OFERTA ON A.MAT = OFERTA.MAT JOIN TURMA T ON OFERTA.CODTURMA = T.COD
WHERE T.CODDISCIPLINA IN (SELECT COD FROM DISCIPLINA WHERE NOME='INTRODUÇÃO A COMPUTAÇÃO')
GROUP BY A.NOME


-- Mostra o nome e a média de todas as disciplinas.
SELECT
	D.NOME AS DISCIPLINAS,
	((AVG(OFERTA.NOTA1) + AVG(OFERTA.NOTA2)) /2) AS MEDIA
FROM OFERTA JOIN TURMA ON OFERTA.CODTURMA = TURMA.COD JOIN DISCIPLINA D ON TURMA.CODDISCIPLINA = D.COD GROUP BY D.NOME;


-- Mostra o nome de todos os professores e quantidade de disciplinas ministradas por cada um.
SELECT
	P.NOME AS PROFESSOR,
	COUNT(D.NOME) AS DISCIPLINAS_MINISTRADAS
FROM DISCIPLINA D JOIN PROFESSOR P ON D.CODPROFESSOR = P.COD GROUP BY P.NOME;




SELECT  P.CPF,P.NOME, SUM(M.VL_MULTA) AS TOTAL 
FROM 	VEICULO V,
		MULTAS M,
		PESSOA P
WHERE 	M.VEICULO_ID = V.ID
AND   	P.ID = V.PESSOA_ID
-- AND 	M.STATUS = 'PRONTA_NOTIFICACAO'
GROUP BY P.CPF, P.NOME

