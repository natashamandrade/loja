# Script BD

```
INSERT INTO public.categoria (nome) VALUES 
('Moda'),('Beleza'),('Sala'),('Cozinha'),('Decoração');

INSERT INTO public.produto (nome,preco) values
('Camiseta PP',10.0),('Camiseta P',12.0),('Batom Vermelho',6.5),('Batom Roxo',6.0),('Sofá 3 lugares',749.99),
('Sofá 2 lugares',554.95),('Fogão 4 bocas',499.99),('Fogão indução 5 bocas',1899.99),('Quadros variados G',49.99),('Quadros variados P',24.29);

INSERT INTO public.categoria_produto (categoria_id,produto_id) VALUES
(1,1),(1,2),(2,3),(2,4),(3,5),(3,6),(4,7),(4,8),(5,9),(5,10);

INSERT INTO public.cliente (cpf_ou_cnpj, email, nome, tipo_cliente) values
('12345678901', 'natasha@teste.com', 'natasha', 'NOVO'),
('12345678902', 'simone@teste.com', 'simone', 'SEGUNDA_COMPRA'),
('12345678903', 'bruna@teste.com', 'bruna', 'MAIS_DE_2_MESES'),
('12345678904', 'alayne@teste.com', 'alayne', 'MAIS_DE_6_MESES'),
('12345678905', 'luisa@teste.com', 'luisa', 'MAIS_DE_1_ANO');

INSERT INTO public.telefone (numero, cliente_id) values
('62999999999', 1),('62999999998', 1),
('62980000000', 2),('62980000001', 2),
('62983000001', 3),('62983000002', 3),
('62986900001', 4),('62986900002', 4),
('62993900001', 5),('62993900001', 5);

INSERT INTO public.estado (nome) values
('GO'),('MG'),('SP'),('RJ'),('MT');

INSERT INTO public.cidade (nome, estado_id) values
('Goiânia', 1),('Anápolis', 1),
('Belo Horizonte', 2),('Uberlândia', 2),
('São Paulo', 3),('São José dos Campos', 3),
('Rio de Janeiro', 4),('Niteroi', 4),
('Cuiabá', 5),('Rondonópolis', 5);

INSERT INTO public.endereco (bairro, cep, complemento, logradouro, numero, cidade_id, cliente_id) values
('Centro', '74000001', 'Rua 1', 'Casa 1', '100', 1, 1),
('Centro', '74000002', 'Rua 2', 'Casa 2', '200', 1, 1),
('Setor Norte', '23000001', 'Rua 3', 'Casa 3', '300', 2, 2),
('Setor Sul', '24000002', 'Rua 4', 'Casa 4', '400', 2, 2),
('Setor Norte', '33000001', 'Rua 5', 'Casa 5', '500', 3, 3),
('Setor Sul', '34000002', 'Rua 6', 'Casa 6', '600', 4, 3),
('Setor Norte', '43000001', 'Rua 7', 'Casa 7', '700', 5, 4),
('Setor Sul', '44000002', 'Rua 8', 'Casa 8', '800', 6, 4),
('Setor Norte', '53000001', 'Rua 9', 'Casa 9', '900', 7, 5),
('Setor Sul', '54000002', 'Rua 10', 'Casa 10', '1000', 8, 5);

INSERT INTO public.pagamento (estado_pagamento) values
('PAGO'),('AGUARDANDO_PAGAMENTO'),
('PAGO'),('PAGO'),
('AGUARDANDO_PAGAMENTO'),('PROCESSANDO'),
('PAGO'),('PROCESSANDO'),
('PROCESSANDO'),('CANCELADO');

INSERT INTO public.pedido (instante, cliente_id, pagamento_id) values
('2020-01-01', 1, 1),('2020-01-03', 1, 2),
('2020-01-07', 2, 3),('2020-01-09', 2, 4),
('2020-01-10', 3, 5),('2020-01-11', 3, 6),
('2020-01-12', 4, 7),('2020-01-15', 4, 8),
('2020-01-18', 5, 9),('2020-01-22', 5, 10);

INSERT INTO public.pedido_produto (produto_id, pedido_id) values
(1, 1),(2, 1),(3, 1),
(4, 2),(5, 2),
(6, 3),
(7, 4),(8, 4),
(9, 5),
(10, 6),(1, 6),
(2, 7),(3, 7),(4, 7),
(5, 8),(6, 8),
(7, 9),
(8, 10),(9, 10),(10, 10),(1, 10);
```