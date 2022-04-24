'''
Classe.....: Loja()
Parametros.: Loja(Nome, Estoque Inicial, Valor em Hora, Valor em Dias, Valor em Semana, Percentual de Desconto)
Objetivo...: Controlar alugueis, estoque de bicicleta e valor do emprestimo
Autor......: Adriano A. Carvalho
Data.......: 19/02/2022
'''

from datetime import datetime as dt
from types import NoneType

class Loja():
    def __init__(self, nome: str,  estoque_inicial:int, valor_hora, valor_dia, valor_semana, percentual_desconto, qtd_dias_para_desconto):
        self._nome: str = nome
        
        self.verificaInt(estoque_inicial)
        self.verificaInt(valor_hora)
        self.verificaInt(valor_dia)
        self.verificaInt(valor_semana)
        self.verificaInt(qtd_dias_para_desconto)
        self.verificaNumero(percentual_desconto)

        self._estoque: int = estoque_inicial
        self.valor_hora = valor_hora
        self.valor_dia = valor_dia
        self.valor_semana = valor_semana
        self.percentual_desconto = percentual_desconto
        self.qtd_dias_para_desconto = qtd_dias_para_desconto
        self.tipo_aluguel = {"hora", "dia", "semana"}

        self.log("__init__", f"Classe Loja inicializada com o Nome {nome}")

    @property
    def nome(self):
        return self._nome

    @property
    def estoque(self):
        return self._estoque

    @estoque.setter
    def estoque(self, novoEstoque):
        self._estoque = novoEstoque

    def ver_estoque(self):
        self.log("ver_estoque", f"A Loja possui {self.estoque}")
        return self.estoque

    def tem_estoque(self, qtd_bicicleta):
        self.log("tem_estoque", f"Verifica se possui estoque {self.estoque}")
        if qtd_bicicleta > self.estoque:
            raise Exception(f"ERRO: Quantidade requisitada ({qtd_bicicleta}) é maior que o Estoque disponivel ({self.estoque})")
        else:
            return True

    def solicita_aluguel(self, qtd_bicicleta, tipo_aluguel):
        if tipo_aluguel not in self.tipo_aluguel:
            raise ValueError(f"ERRO: Os tipos disponiveis para faturamento: {self.tipo_aluguel}")

        if self.tem_estoque(qtd_bicicleta):
            self.estoque -= qtd_bicicleta 

        data = dt.now()

        self.log("solicita_aluguel", f"O cliente alugou {qtd_bicicleta} faturando por {tipo_aluguel}, o estoque atual: {self.estoque} ")

        return qtd_bicicleta, tipo_aluguel, data
        

    def fechar_conta(self, nomecliente, qtd_bicicleta, tipo_aluguel, tempo_aluguel):  #tempo em segundos
        self.log("fechar_conta", f"Cliente {nomecliente} solicitou fechamento de conta")
        if tipo_aluguel not in self.tipo_aluguel:
            raise ValueError(f"ERRO: Os tipos disponiveis para faturamento: {self.tipo_aluguel}")
        
        self.estoque += qtd_bicicleta

        if tipo_aluguel == "hora":
            tempo_aluguel = round(tempo_aluguel/3600)
            self.log("fechar_conta", f"Memória de Cálculo: {tempo_aluguel:.2f} (tempo_aluguel) * {self.valor_hora:.2f} (valor_hora) * {qtd_bicicleta:.2f} (qtd_bicicleta)")
            valor_total = tempo_aluguel * self.valor_hora * qtd_bicicleta
        elif tipo_aluguel == "dia":
            tempo_aluguel = round(tempo_aluguel/(24*3600))
            self.log("fechar_conta", f"Memória de Cálculo: {tempo_aluguel:.2f} (tempo_aluguel) * {self.valor_dia:.2f} (valor_dia) * {qtd_bicicleta:.2f} (qtd_bicicleta)")
            valor_total = tempo_aluguel * self.valor_dia * qtd_bicicleta
        elif tipo_aluguel == "semana":
            tempo_aluguel = round(tempo_aluguel/(7*24*3600))
            self.log("fechar_conta", f"Memória de Cálculo: {tempo_aluguel:.2f} (tempo_aluguel) * {self.valor_semana:.2f} (valor_semana) * {qtd_bicicleta:.2f} (qtd_bicicleta)")
            valor_total = tempo_aluguel * self.valor_semana * qtd_bicicleta
        
        if qtd_bicicleta >= self.qtd_dias_para_desconto: 
            self.log("fechar_conta", f"Memória de Cálculo: Valor Bruto {valor_total:.2f} - {self.percentual_desconto:.2f} %")
            valor_total -= round((valor_total * self.percentual_desconto) / 100)

        self.log("fechar_conta", f"Memória de Cálculo: Valor {valor_total:.2f} ")    

        return valor_total

    def verificaInt(self, valor):
        if type(valor) == str:
            if not valor.isnumeric():
                raise ValueError(f"ERRO: A quantidade solicitada deve ser um Inteiro")
            elif int(valor) <= 0:
                raise ValueError(f"ERRO: A quantidade solicitada deve ser um Inteiro e Maior que Zero")
        elif type(valor) != int:
            raise ValueError(f"ERRO: A quantidade solicitada deve ser um Inteiro")
    
    def verificaNumero(self, valor):
        if type(valor) == str:
            if not valor.isnumeric():
                raise ValueError(f"ERRO: A quantidade solicitada deve ser um Número")
            elif int(valor) <= 0:
                raise ValueError(f"ERRO: A quantidade solicitada deve ser um Número e Maior que Zero")
        elif type(valor) == NoneType:
            raise ValueError(f"ERRO: A quantidade solicitada deve ser um Número e Maior que Zero")

    def log(self, origem, mensagem): #função usada no log do sistema
        agora = dt.now()
        print(f"{agora} Classe: Loja | Nome: {self.nome} | Função: {origem} | Status: {mensagem}")

