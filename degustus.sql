create table if not exists endereco (
    id serial,
    cep varchar(8) not null,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    estado varchar(20) not null,
    numero varchar(10) not null,
    complemento varchar(100),
    constraint pk_endereco primary key (id)
);

create table if not exists empresa (
    id serial,
    nomeFantasia varchar(100) not null,
    cnpj varchar(14) not null,
    razaoSocial varchar(100) not null,
    idEndereco integer not null,
    constraint pk_empresa primary key (id),
    constraint fk_empresa_endereco foreign key (idEndereco) references endereco (id)
);

create table if not exists funcionario (
    cpf varchar(11) not null,
    nome varchar(50) not null,
    data_nascimento date not null,
    usuario varchar(20) not null,
    senha varchar(20) not null,
    idEmpresa integer not null,
    idEndereco integer not null,
    constraint pk_funcionario primary key (cpf),
    constraint fk_funcionario_empresa foreign key (idEmpresa) references empresa (id),
    constraint fk_funcionario_endereco foreign key (idEndereco) references endereco (id)
);

create table if not exists categoria (
    id serial,
    nome varchar(50) not null,
    tipo varchar(20),
    constraint pk_categoria primary key (id)
);

create table if not exists produto (
    id serial,
    nome varchar(50) not null,
    unidadeMedida decimal(10,2) not null,
    idCategoria integer not null,
    constraint pk_produto primary key (id),
    constraint fk_produto_categoria foreign key (idCategoria) references categoria (id)
);

create table if not exists precoProduto (
    id serial,
    valor decimal(10,2) not null,
    idProduto integer not null,
    idEmpresa integer not null,
    constraint pk_precoProduto primary key (id),
    constraint fk_precoProduto_produto foreign key (idProduto) references produto (id),
    constraint fk_precoProduto_empresa foreign key (idEmpresa) references empresa (id)
);

create table if not exists comanda (
    id serial,
    mesa varchar(10) not null,
    dataAbertura date not null,
    dataFechamento date,
    constraint pk_comanda primary key (id)
);

create table if not exists ordem (
    id serial,
    dataCriacao date not null,
    idEmpresa integer not null,
    idComanda integer not null,
    constraint pk_ordem primary key (id),
    constraint fk_ordem_empresa foreign key (idEmpresa) references empresa (id),
    constraint fk_ordem_comanda foreign key (idComanda) references comanda (id)
);


create table if not exists pedido (
    id serial,
    quantidade decimal(10,2) not null,
    idProduto integer not null,
    codOrdem integer not null,
    constraint pk_pedido primary key (id),
    constraint fk_pedido_produto foreign key (idProduto) references produto (id),
    constraint fk_pedido_ordem foreign key (codOrdem) references ordem (id)
);
