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

insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'Coca-Cola', 'descricao', 5, 'bebida', 2, 'https://zapvendas.com.br/upload/95/7c77a8b7cc7cf11aeda1e2792075ff0c.png');
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'Guarana', 'descricao', 5,'bebida', 2, 'https://www.paodeacucar.com/img/uploads/1/477/19514477x200x200.jpg'  );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'Agua', 'descricao', 2, 'bebida', 2, 'https://uploads.consultaremedios.com.br/product_variation_images/large/5c25306db49a1bbcafab6473c96e83139fb5c761.jpg?1620053017');
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'Hamburguer', 'descricao', 15,'prato', 2, 'https://www.auau.com.br/image/cache/data/up_system/product-13698/HAMBURGUER-CHEDDAR-200x200.jpg' );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'X-Salada', 'descricao', 12, 'prato', 2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1F5y0kX4J5L2RTJBTTQ2GOr_iSK5HDpLjQ&usqp=CAU' );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'X-Bacon', 'descricao', 17, 'prato', 2, 'https://boulangerpaes.com.br/wp-content/uploads/2018/11/x-egg-bacon.png');
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'Bolinho de Arroz', 'descricao', 24, 'prato', 1 , 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0AHaG_0cBE3RJ20r0aIOxw3kVxr9e43fUUX9t6qvOhYz1Ry-WuKR18kof4vEZ8RcE684&usqp=CAU');
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'Vieira', 'descricao', 200, 'prato', 1, 'https://static1.conquistesuavida.com.br/articles//5/11/54/5/@/30127-vieira-e-um-fruto-do-mar-extremamente-ri-article_block_media-2.jpg' );
insert into itens (data_criacao, nome, descricao, valor, categoria, empresa_id, image_url) values (CURRENT_DATE, 'Bolinho de Frango', 'descricao', 33, 'prato', 1, 'https://static1.conquistesuavida.com.br/articles/9/10/79/9/@/29285-bolinho-de-cenoura-e-chia-e-rico-em-fibr-200x200-1.jpeg' );

insert into funcionarios (data_criacao, nome, sobrenome, usuario, senha) values (CURRENT_DATE, 'claudio', 'kelvin','ck', 'ck123');