INSERT INTO usuarios (id,username, password, enabled) VALUES(1,'admin@gmail.com', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', true);
INSERT INTO usuarios (id,username, password, enabled) VALUES(2,'yamamoto@yahoo.com;br', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', true);
INSERT INTO usuarios (id,username, password, enabled) VALUES(3,'kon@hotmail.com', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', false);
INSERT INTO usuarios (id,username, password, enabled) VALUES(4,'ulquiorra@sad.com', '$2a$08$sFd33JOHRlbRYE4j1NDnZezggfaoRKGjAAXN10iIltiiTWhHX.q.2', false);

INSERT INTO AUTHORITY (id,AUTHORITY) VALUES(1,'ADMIN');
INSERT INTO AUTHORITY (id,AUTHORITY) VALUES(2,'USER');

INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (1,1);
INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (2,2);
INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (3,2);
INSERT INTO  AUTHORITIES_USERS (USUARIO_ID, AUTHORITY_ID) VALUES (4,2);

insert into empresas (data_criacao, nome_fantasia, cnpj, razao_social) values (CURRENT_DATE, 'Degustus Gourmet', '36587627000138', 'Degustus Food Services');
insert into empresas (data_criacao, nome_fantasia, cnpj, razao_social) values (CURRENT_DATE, 'Degustus Beer', '63972146000119', 'Degustus Food Services');

insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'Coca-Cola', 'descricao', 5, 'bebida', 2 );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'Guarana', 'descricao', 5,'bebida', 2  );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'Agua', 'descricao', 2, 'bebida', 2);
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'Hamburguer', 'descricao', 15,'prato', 2 );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'X-Salada', 'descricao', 12, 'prato', 2 );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'X-Bacon', 'descricao', 17, 'prato', 2);
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'Bolinho de Arroz', 'descricao', 24, 'prato', 1 );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'Vieira', 'descricao', 200, 'prato', 1 );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id) values (CURRENT_DATE, 'Bolinho de Frango', 'descricao', 33, 'prato', 1 );

insert into funcionarios (data_criacao, nome, sobrenome, usuario, senha) values (CURRENT_DATE, 'claudio', 'kelvin','ck', 'ck123');