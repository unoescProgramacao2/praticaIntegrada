insert into endereco (cep, rua, bairro, cidade, estado, numero, complemento) values  ('89800000', 'Rua dos Faróis', 'Centro', 'Chapecó', 'Santa Catarina', '307D', 'Food Park');
insert into endereco (cep, rua, bairro, cidade, estado, numero, complemento) values  ('89800001', 'Rua do Comércio', 'Centro', 'Chapecó', 'Santa Catarina', '200', 'Shopping');
insert into endereco (cep, rua, bairro, cidade, estado, numero) values  ('89800007', 'Rua do Falcão', 'Village', 'Chapecó', 'Santa Catarina', '100');

insert into empresa (nomeFantasia, cnpj, razaoSocial, idEndereco) values ('Degustus Gourmet', '36587627000138', 'Degustus Food Services', 1);
insert into empresa (nomeFantasia, cnpj, razaoSocial, idEndereco) values ('Degustus Beer', '63972146000119', 'Degustus Food Services', 2);

insert into funcionario (cpf, nome, data_nascimento, usuario, senha, idEmpresa, idEndereco) values ('04836558050', 'admin', CURRENT_DATE, 'admin', 'admin', 1, 3);

insert into categoria (nome, tipo) values ('Bebidas', 'bebida');
insert into categoria (nome, tipo) values ('Lanches', 'lanche');
insert into categoria (nome, tipo) values ('Salgados', 'salgado');
insert into categoria (nome, tipo) values ('Pratos Gourmet', 'pratoGourmet');
insert into categoria (nome, tipo) values ('Sobremesas', 'sobremesa');

insert into produto (nome, unidadeMedida, idCategoria) values ('Coca-Cola', 1, 11);
insert into produto (nome, unidadeMedida, idCategoria) values ('Guaraná', 1, 11);
insert into produto (nome, unidadeMedida, idCategoria) values ('Água', 1, 11);
insert into produto (nome, unidadeMedida, idCategoria) values ('Hamburguer', 1, 12);
insert into produto (nome, unidadeMedida, idCategoria) values ('X-Salada', 1, 12);
insert into produto (nome, unidadeMedida, idCategoria) values ('X-Bacon', 1, 12);
insert into produto (nome, unidadeMedida, idCategoria) values ('Bolinho de Arroz', 1, 13);
insert into produto (nome, unidadeMedida, idCategoria) values ('Bolinho de Feijão', 1, 13);
insert into produto (nome, unidadeMedida, idCategoria) values ('Bolinho de Frango', 1, 13);

insert into precoProduto (valor, idProduto, idEmpresa) values (5.00, 1, 1);
insert into precoProduto (valor, idProduto, idEmpresa) values (5.00, 2, 1);
insert into precoProduto (valor, idProduto, idEmpresa) values (5.00, 3, 2);
insert into precoProduto (valor, idProduto, idEmpresa) values (10.00, 4, 1);