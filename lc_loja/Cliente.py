'''
Classe.....: Cliente()
Parametros.: Cliente(Nome do Cliente)
Objetivo...: Solicitar emprestimo de Bicicletas a classe Loja
Autor......: Adriano A. Carvalho
Data.......: 19/02/2022
'''
from datetime import datetime as dt
from Loja import Loja

class Cliente():
    def __init__(self, nome: str):
        self.inicializa()
        self._nome: str = nome
        self.log("__init__", f"Classe Cliente inicializada com o nome: {nome}")
        
    def __repr__(self):
        return f"Cliente {self.nome} Alugou {self.qtd_bicicleta} | Tipo de Aluguel {self.tipo_aluguel} | Data do Aluguel {self.data_aluguel}"

    @property
    def nome(self):
        return self._nome

    def ver_estoque(self, loja: Loja):
        self.log("ver_estoque", "solicita a classe Loja para ver o estoque")
        return loja.ver_estoque()

    def solicita_aluguel(self, loja: Loja, quantidade, tipo_aluguel):
        if self.loja != None:
            if not isinstance(loja, Loja):
                raise TypeError(f"ERRO: Cliente já possui contrato com a {self.loja.nome}")

        if self.data_aluguel is not None:
            raise Exception(f"ERRO: Cliente já possui contrato em andamento ({self.loja.nome})")
        
        if type(quantidade) == str:
            if not quantidade.isnumeric():
                raise ValueError(f"ERRO: A quantidade solicitada deve ser um Inteiro")
            elif int(quantidade) <= 0:
                raise ValueError(f"ERRO: A quantidade solicitada deve ser um Inteiro e Maior que Zero")
        elif type(quantidade) != int:
            raise ValueError(f"ERRO: A quantidade solicitada deve ser um Inteiro")

        self.log("solicita_aluguel", f"solicita a classe loja para alugar {quantidade} bicicletas")
        self.loja = loja
        self.qtd_bicicleta, self.tipo_aluguel, self.data_aluguel = loja.solicita_aluguel(quantidade, tipo_aluguel)
        
    def devolve_aluguel(self, loja: Loja):
        if self.loja != None:
            if not isinstance(loja, Loja):
                raise TypeError(f"ERRO: O contrato do cliente {self.nome} é na Loja {self.loja.nome}")
            if loja != self.loja:
                raise SystemError(f"ERRO: O Cliente {self.nome} não pode devolver para a loja que não possui contrato ({self.loja.nome} != {loja.nome})")

        self.tempo_aluguel = self.calcula_tempo() 
        self.log("devolve_aluguel", f"solicita a classe loja para devolver as bicicletas e calcular fatura com data {self.data_devolucao}")

        valor_conta = loja.fechar_conta(self.nome, self.qtd_bicicleta, self.tipo_aluguel, self.tempo_aluguel)

        self.log("devolve_aluguel", f"O valor retornado do faturamento: {valor_conta:.2f} " )

        self.inicializa()
        return valor_conta

    def calcula_tempo(self):
        self.data_devolucao = dt.now() #Salva a Data e Hora atual da devolução
        self.log("calcula_tempo", f"Calcula a diferença entre o tempo inicial: {self.data_aluguel} e o tempo final: {self.data_devolucao}")
        tempo_segundos = (self.data_devolucao - self.data_aluguel).total_seconds()
        
        self.log("calcula_tempo", f"Tempo Calculado {tempo_segundos:.2f} em segundos")
        
        return tempo_segundos #retorna o tempo em segundos

    def inicializa(self): #função de inicializar as variaveis
        self.qtd_bicicleta = 0
        self.tipo_aluguel = None
        self.tempo_aluguel = 0
        self.data_aluguel = None
        self.data_devolucao = None
        self.loja = None

    def log(self, origem, mensagem): #função usada no log do sistema
        agora = dt.now()
        print(f"{agora} Classe: Cliente | Nome: {self.nome} | Função: {origem} | Status: {mensagem}")