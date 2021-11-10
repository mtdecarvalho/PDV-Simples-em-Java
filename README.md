Este é o repositório para a AV2 de PRJ feita por mim e pela Juliana.

# Implementação de um PDV (Ponto de Venda)

Sistema para registrar vendas de uma empresa.

### Funcionalidades 
- Manter um cadastro produtos (inclusão, alteração, exclusão e consulta de produtos);
- Manter um cadastro de clientes (inclusão, alteração, exclusão e consulta de clientes);
- Manter um cadastro de usuários com diferentes permissões, onde um usuário administrador pode alterar 
dados e cadastrar novos usuários;
- Registrar vendas. Uma venda pode ter mais de um item e a venda pode ou não ser vinculada a um
cliente;
- Registrar a forma de pagamento. A venda pode ser paga em dinheiro ou com cartão de
crédito;
- Atualizar o estoque dos produtos vendidos;
- Registrar a data da última venda de um produto;
- Imprimir a venda;
- Imprimir relatório de fechamento de caixa. Neste relatório, são impressos o código, o
valor total de cada venda realizada e o valor total recebido por cada forma de pagamento;
- Dados do produto: código, nome, unidade, preço, quantidade em estoque e data da última
venda;
- Dados do cliente: código, nome, endereço, telefone e e-mail;
- Dados da venda: código, data e hora, valor total da venda e cliente (quando houver);
- Dados de um item da venda: código, quantidade vendida, preço, total do item;
- Dados de um usuário: código, login, senha e permissão.
