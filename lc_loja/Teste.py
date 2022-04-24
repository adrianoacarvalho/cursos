'''
Programa.: Teste.py
Objetivo.: Testar as Classes Cliente e Loja
Autor....: Adriano A. Carvalho
Data.....: 19/02/2022
'''
#Inicio do Programa
import datetime as dt
from Loja import Loja
from Cliente import Cliente

#Instancia das classes para teste
print("---------Instanciamento dos Objetos---------")
# Loja(Nome da loja, Estoque Inicial, Valor da Hora, Valor do Dia, Valor da Semana, Valor do Desconto, Dias para considerar o Desconto )
# O Projeto solicita que o Valor da Hora seja = 5, Valor do Dia = 25, Valor da Semana = 100, O Desconto de 30% caso sejam alugadas 3 ou mais bicicletas
loja1 = Loja("Loja_1", 25, 5, 25, 100, 30, 3) 
loja2 = Loja("Loja_2", 15, 5, 25, 100, 30, 3)
cliente1 = Cliente("Cliente_1")
cliente2 = Cliente("Cliente_2")
cliente3 = Cliente("Cliente_3")
cliente4 = Cliente("Cliente_4")
#fim da inicialização

#Teste de comunicação do Objeto Cliente com o Objeto Loja
print("--------------Visualiza Estoque -------------")
print("O estoque da Loja 1 é: ", cliente1.ver_estoque(loja1), "bicicletas.")
print("O estoque da Loja 2 é: ", cliente2.ver_estoque(loja2), "bicicletas.")


#Teste de solicitação de aluguel por hora, dia, semana
print("-------Teste de Solicitação de Aluguel ------")
cliente1.solicita_aluguel(loja1, 1, "hora")
cliente2.solicita_aluguel(loja2, 10, "dia")
cliente3.solicita_aluguel(loja1, 2, "semana")

print("--------------Visualiza Estoque -------------")
print("O estoque da Loja 1 é: ", cliente1.ver_estoque(loja1), "bicicletas.")
print("O estoque da Loja 2 é: ", cliente2.ver_estoque(loja2), "bicicletas.")

#Teste de Devolução do Aluguel 
#Alterando as datas de Aluguel para Efetivação do Teste
cliente1.data_aluguel -= dt.timedelta(hours=10)
cliente2.data_aluguel -= dt.timedelta(days=3)
cliente3.data_aluguel -= dt.timedelta(weeks=5)

print("-------Visualização dos dados do Objeto ------")
print(cliente1)
print(cliente2)
print(cliente3)

print("-------Teste de Devolução de Aluguel ------")
print(f"O valor que o Cliente1 vai pagar: {cliente1.devolve_aluguel(loja1):.2f}")
print(f"O valor que o Cliente2 vai pagar: {cliente2.devolve_aluguel(loja2):.2f}")
print(f"O valor que o Cliente3 vai pagar: {cliente3.devolve_aluguel(loja1):.2f}")

print("--------------Visualiza Estoque -------------")
print("O estoque da Loja 1 é: ", cliente1.ver_estoque(loja1), "bicicletas.")
print("O estoque da Loja 2 é: ", cliente2.ver_estoque(loja2), "bicicletas.")

print("--------------Simulando Erros-------------")
#Testa paramêtro errado na instancia da Loja
try:    
    loja3 = Loja("Loja_3", 15, 5, 25, "Adriano", 30, 3)
except Exception as e:
    print(str(e))

try:    
    loja3 = Loja("Loja_3", 15, 5, 25, 100, None, 3)
except Exception as e:
    print(str(e))   

#Teste de Erro ao cliente solicitar contrato em outra loja ou na mesma
try:
    cliente1.solicita_aluguel(loja1, 4, "semana") #pois foi devolvido na linha 49
    print("Provocando o ERRO:")
    cliente1.solicita_aluguel(loja2, 2, "semana")
except Exception as e:
    print(str(e))

#Testa passar uma string na quantidade da solicitação de aluguel
try:
    cliente2.solicita_aluguel(loja2, "0", "semana")
except Exception as e:
    print(str(e))

#Teste de Erro ao cliente solicitar quantidade maior que o estoque da Loja
try:
    cliente4.solicita_aluguel(loja2, 18, "semana")
except Exception as e:
    print(str(e))

#Teste de Solicitar aluguel com tipo de faturamento que não existe

try:
    cliente4.solicita_aluguel(loja2, 10, "anual")
except Exception as e:
    print(str(e))

#Teste de Devolução de Bicicleta em loja diferente
try:
    cliente1.devolve_aluguel(loja2)
except Exception as e:
    print(str(e))

print("--------------FIM DO PROGRAMA--------------")







