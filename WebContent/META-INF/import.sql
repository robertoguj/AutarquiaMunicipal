INSERT INTO USUARIO (username, password, cpf, nome, email, telefone, status_conta) values ('admin', 'admin', '741.235.133-87', 'Roberto Pereira', 'jrobertopr@hotmail.com', '(85)98845-2056', true);
INSERT INTO USUARIO (username, password, cpf, nome, email, telefone, status_conta) values ('user', 'user', '981.005.115-31', 'Leonardo Lima', 'instrutorleonardo@hotmail.com', '(85)99924-2424', true);
INSERT INTO USUARIO (username, password, cpf, nome, email, telefone, status_conta) values ('juridico', 'juridico', '081.067.189-13', 'Andrade Junior', 'projur@amc.fortaleza.ce.gov.br', '(85)98407-0408', false);

INSERT INTO PERFIL (description) VALUES ('ROLE_ADMIN');
INSERT INTO PERFIL (description) VALUES ('ROLE_USER');
INSERT INTO PERFIL (description) VALUES ('ROLE_PROJUR');
INSERT INTO PERFIL (description) VALUES ('ROLE_DAF');
INSERT INTO PERFIL (description) VALUES ('ROLE_DITRAN');

INSERT INTO USUARIO_PERFIL VALUES (1, 1);
INSERT INTO USUARIO_PERFIL VALUES (2, 2);
INSERT INTO USUARIO_PERFIL VALUES (3, 3);

INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '754.235.104-15', 'ANTONIO FURTADO MOURA SILVA', 'Rua do Contorno Leste, 1024', 'apto. 801', 'Aldeota', 'Fortaleza', 'CE', '60865-002');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '104.895.562-77', 'CLADIA MARTINS OLIVEIRA', 'Rua Andrade Furtado, 1034', 'apto. 702', 'Meireles', 'Fortaleza', 'CE', '60155-230');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '230.142.235-30', 'UBIRATAN AGUIAR SOBRINHO', 'Av. do Contorno Sul, 985', 'apto. 1202', 'Parangaba', 'Fortaleza', 'CE', '60163-020');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '154.955.305-89', 'PEDRO CARDOZO FONSECA JUNIOR', 'Rua dos Coqueirais, 985', null, 'Antonio Bezerra', 'Fortaleza', 'CE', '60045-230');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '530.115.235-90', 'CARLOS AMARILDO LIMA FILHO', 'Rua dos Coqueirais, 985', null, 'Messejana', 'Fortaleza', 'CE', '60025-115');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '125.955.235-79', 'NELSON AGUIAR NETO', 'Rua dos Coqueirais, 985', 'apto. 402', 'Joaquim T?ora', 'Fortaleza', 'CE', '60115-620');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '163.455.235-93', 'MARIA ANTONIA ROCHA ANDRADE', 'Rua Gozaga Mota, 1985', 'apto. 202', 'Carlito Pamplona', 'Fortaleza', 'CE', '60045-620');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '153.125.123-91', 'YGOR BEZERRA DE SOUZA', 'Rua Neto Pinheiro, 985', 'apto. 202', 'Coqueiral', 'Aquiraz', 'CE', '6015-620');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '224.118.235-89', 'ANDERSON DA SILVA PINHEIRO', 'Rua Antonio Anastacia, 1015', null, 'Montese', 'Fortaleza', 'CE', '60045-015');
INSERT INTO PESSOA (pessoa_tipo, cpf, nome, endereco, complemento, bairro, municipio, uf, cep) VALUES ('FISICA', '464.551.130-89', 'BEATRIZ SERQUEIRA AGUIAR', 'Rua dos Coqueirais, 123', null, 'Boqueirao', 'Euzebio', 'CE', '60012-020');

INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2013, '1458008124', 'Fiat Ducato 2.8 Turbodiesel', 'HIT-2462', 1);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2014, '2441158925', 'Fiat Uno Mille 1.0', 'HYV-2424', 2);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2011, '1955682455', 'Ford Ranger 2.3', 'HXX-3024', 3);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2015, '1422578104', 'Ford Verona 1.6', 'OKA-8090', 4);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2015, '1848188935', 'Chevrolet Omega Suprema 2.0', 'HMV-2424', 5);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2014, '1189922255', 'Chevrolet Blazer 2.2', 'MOI-6969', 6);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2011, '1424884103', 'Chevrolet Vectra 1.8 8V', 'OIK-7172', 7);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2010, '1440008900', 'Fiat Siena 1.3 Fire', 'HTY-2342', 8);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2013, '9980008133', 'Chevrolet Astra 2.0', 'MON-5619', 9);
INSERT INTO VEICULO (ano_fabricacao, chassi, modelo, placa, pessoa_id) VALUES (2012, '1470008456', 'Volkswagen Saveiro 1.8', 'HYA-2223', 10);

INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('19-09-2013', '181-XI', '23-07-2013', 'Estacionar o ve?ulo ao lado de outro ve?ulo em fila dupla.', '15:23:00', 'A012237952', 'Rua Senador Pompeu, 1120', 'LIQUIDADA', 127.69, 1);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('25-01-2013', '181-XII', '20-12-2012', 'Estacionar o ve?ulo na ?ea de cruzamento de vias, prejudicando a circulacao de veiculos e pedestres.', '11:03:00', 'A012237953', 'Av. Historiador Raimundo Girao, 1256', 'PRONTA_POSTAGEM', 127.69, 2);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('24-09-2014', '181-III', '17-06-2014', 'Estacionar o veiculo afastado da guia da cal?da (meio-fio) a mais de um metro.', '18:20:00', 'A012237954', 'Av. Silas Munguba, 1586', 'EM_RECURSO', 127.69, 3);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('11-12-2014', '179-I', '08-09-2014', 'Fazer ou deixar que se fa? reparo em veiculo na via publica, salvo nos casos de impedimento absoluto de sua remocao e em que o veiculo esteja devidamente sinalizado em pista de rolamento de rodovias e vias de tr?sito r?ido.', '09:08:00', 'A012237955', 'Av. Ant?io Sales, 1020', 'NOTIFICADA', 127.69, 4);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('10-05-2014', '177', '02-03-2014', 'Deixar o condutor de prestar socorro vitima de acidente de transito quando solicitado pela autoridade e seus agentes.', '08:27:00', 'A012237956', 'Av. Aguanambi, 586', 'NOTIFICADA', 103.90, 5);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('27-02-2015', '167', '20-01-2015', 'Deixar o condutor ou passageiro de usar o cinto de seguranca.', '08:59:00', 'A012237957', 'Av. Aguanambi, 586', 'PRONTA_POSTAGEM', 114.60, 6);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('24-01-2014', '186-I', '20-09-2014', 'Transitar pela contramao de direcao em vias com duplo sentido de circulacao, exceto para ultrapassar outro veiculo e apenas pelo tempo necessario, respeitada a preferencia do veiculo que transitar em sentido contrario.', '08:20:00', 'A012237958', 'Av. Frei Mansueto, 105', 'NOTIFICADA', 103.90, 7);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('24-10-2014', '190', '15-08-2014', 'Seguir veiculo em servico de urgencia, estando este com prioridade de passagem devidamente identificada por dispositivos regulamentares de alarme sonoro e iluminacao vermelha intermitentes', '11:20:00', 'A012237959', 'Rua Jaime Vasconcelos, 125', 'LIQUIDADA', 103.90, 8);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('17-08-2013', '192', '07-06-2013', 'Deixar de guardar distancia de seguranca lateral e frontal entre o seu veiculo e os demais, bem como em relatorio ao bordo da pista, considerando-se , no momento, a velocidade, as condicoes climaicas do local da circulacao e do veiculo.', '09:20:00', 'A012237960', 'Rua Castro Monte, 1189', 'EM_RECURSO', 103.90, 9);
INSERT INTO MULTA (data_vencimento, codigo_infracao, data_infracao, descricao_infracao, hora_infracao, codigo_auto_infracao, local_infracao, status_multa, valor_multa, veiculo_id) VALUES ('19-03-2014', '194', '12-01-2014', 'Transitar em marcha re salvo na distancia necessaria e pequenas manobras e de forma a nao causar riscos a seguranca.', '08:15:00', 'A012237961', 'Rua Manuel Jesuino, 586', 'PRONTA_POSTAGEM', 103.90, 10);

INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('24-09-2013', 'Multas nao pagas', 654.20, 1);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('21-06-2012', 'Multas nao pagas', 851.40, 2);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('21-03-2015', 'Multas executadas', 611.50, 3);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('17-05-2014', 'Multas liquidadas', 720.00, 4);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('11-03-2012', 'Multas Multas em recursos', 710.90, 5);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('18-12-2014', 'Multas nao pagas', 745.00, 6);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('01-04-2015', 'Multas liquidadas', 840.00, 7);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('31-01-2013', 'Multas executadas', 923.40, 8);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('17-06-1990', 'Multas em recurso', 967.50, 9);
INSERT INTO DIVIDA (data_inscricao, status_multa, valor_divida, pessoa_id) VALUES ('24-06-2014', 'Multas Multas em recursos', 674.00, 10);

INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (1, 1);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (1, 2);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (1, 3);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (2, 4);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (2, 5);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (3, 6);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (4, 7);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (4, 8);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (5, 9);
INSERT INTO DIVIDA_MULTA (DIVIDA_ID, MULTA_ID) VALUES (5, 10);

INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747715BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747716BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747717BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747718BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747719BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747720BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747721BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747722BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747723BR', '28-07-20015');
INSERT INTO POSTAGEM (AVISO_RECEBIMENTO, DATA_POSTAGEM) VALUES ('JS082747724BR', '28-07-20015');

INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 1, 'Aguardando recurso', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 2, 'Indeferido', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 3, 'Indeferido', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 4, 'Deferido', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 5, 'Aguardando recurso', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 6, 'Aguardando recurso', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 7, 'Deferido', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 8, 'Indeferido', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 9, 'Aguardando recurso', '15-06-2015');
INSERT INTO RECURSO (NUMERO_PROCESSO, MULTA_ID, STATUS_RECURSO, DATA_ABERTURA_PROCESSO) VALUES ('SPUNU0001/2015', 10, 'Aguardando recurso', '15-06-2015');