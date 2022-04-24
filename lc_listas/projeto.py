import json
import os.path
from re import S
import sys
from xml.dom.minidom import ReadOnlySequentialNamedNodeMap

versao = 1.0

def obter_dados():
    '''
    Essa função carrega os dados dos produtos e retorna uma lista de dicionários, onde cada dicionário representa um produto.
    NÃO MODIFIQUE essa função.
    '''
    with open(os.path.join(sys.path[0], 'dados.json'), 'r') as arq:
        dados = json.loads(arq.read())
    return dados

def listar_categorias(dados):
    '''
    O parâmetro "dados" deve ser uma lista de dicionários representando os produtos.
    Essa função deverá retornar uma lista contendo todas as categorias dos diferentes produtos.
    Cuidado para não retornar categorias repetidas.    
    '''
    categorias = []
    
    for dado in dados:
       if dado['categoria'] not in categorias: categorias.append(dado['categoria'])

    categorias.sort()
    return categorias
    ...

def listar_por_categoria(dados, categoria):
    '''
    O parâmetro "dados" deve ser uma lista de dicionários representando os produtos.
    O parâmetro "categoria" é uma string contendo o nome de uma categoria.
    Essa função deverá retornar uma lista contendo todos os produtos pertencentes à categoria dada.
    '''

    lista = []
    
    for dado in dados:
       if dado['categoria'] == categoria.lower(): 
          lista.append(dado)

    return lista
    ...
    

def produto_mais_caro(dados, categoria):
    '''
    O parâmetro "dados" deve ser uma lista de dicionários representando os produtos.
    O parâmetro "categoria" é uma string contendo o nome de uma categoria.
    Essa função deverá retornar um dicionário representando o produto mais caro da categoria dada.
    '''
    
    lista_categoria = listar_por_categoria(dados, categoria)
    
    resultado = lista_categoria[0]
    
    for i in lista_categoria: 
        if float(i['preco']) > float(resultado['preco']): 
            resultado = i
     
    return resultado


def produto_mais_barato(dados, categoria):
    '''
    O parâmetro "dados" deve ser uma lista de dicionários representando os produtos.
    O parâmetro "categoria" é uma string contendo o nome de uma categoria.
    Essa função deverá retornar um dicionário representando o produto mais caro da categoria dada.
    '''

    lista_categoria = listar_por_categoria(dados, categoria)
    
    resultado = lista_categoria[0]
    
    for i in lista_categoria: 
        if float(i['preco']) < float(resultado['preco']): 
            resultado = i
     
    return resultado

def top_10_caros(dados):
    '''
    O parâmetro "dados" deve ser uma lista de dicionários representando os produtos.
    Essa função deverá retornar uma lista de dicionários representando os 10 produtos mais caros.
    '''

    resultado = []
    contador = 0

    while contador < 10:
        valor_encontrado = dados[0]

        for i in dados:
            if float(i['preco']) > float(valor_encontrado['preco']): 
                if i not in resultado:
                    valor_encontrado = i

        if valor_encontrado not in resultado:
            resultado.append(valor_encontrado)
        
        contador += 1

    return resultado



def top_10_baratos(dados):
    '''
    O parâmetro "dados" deve ser uma lista de dicionários representando os produtos.
    Essa função deverá retornar uma lista de dicionários representando os 10 produtos mais caros.
    '''
    resultado = []
    contador = 0

    while contador < 10:
        valor_encontrado = dados[0]

        for i in dados:
            if float(i['preco']) < float(valor_encontrado['preco']): 
                if i not in resultado:
                    valor_encontrado = i

        if valor_encontrado not in resultado:
            resultado.append(valor_encontrado)
        
        contador += 1

    return resultado

def menu(dados):
    '''
    O parâmetro "dados" deve ser uma lista de dicionários representando os produtos.
    Essa função deverá, em loop, realizar as seguintes ações:
    - Exibir as seguintes opções:
        1. Listar categorias
        2. Listar produtos de uma categoria
        3. Produto mais caro por categoria
        4. Produto mais barato por categoria
        5. Top 10 produtos mais caros
        6. Top 10 produtos mais baratos
        0. Sair
    - Ler a opção do usuário.
    - No caso de opção inválida, imprima uma mensagem de erro.
    - No caso das opções 2, 3 ou 4, pedir para o usuário digitar a categoria desejada.
    - Chamar a função adequada para tratar o pedido do usuário e salvar seu retorno.
    - Imprimir o retorno salvo. 
    O loop encerra quando a opção do usuário for 0.
    '''
    opcao = None

    while opcao != 0:
        cabecalho()
        print("1. Listar categorias")
        print("2. Listar produtos de uma categoria")
        print("3. Produto mais caro por categoria")
        print("4. Produto mais barato por categoria")
        print("5. Top 10 produtos mais caros")
        print("6. Top 10 produtos mais baratos")
        print("0. Sair")
        print()
        linha()
        opcao = input("Digite a opção desejada: ")
        linha()
        if opcao.isnumeric():
            opcao = int(opcao)
            if opcao != 0:
                opcao, retorno, titulo = valida_opcao(opcao, dados)

                if retorno:
                    mostrar_retorno(opcao, titulo, retorno)
                    msg_info()
                
        else:
            if msg_erro("Opcao Invalida"):
                opcao = None
            else:
                opcao = 0


    fim_de_programa()
    ...

def linha():
     print("=======================================")

def limpa_tela():
    os.system('clear')

def cabecalho():
    limpa_tela()
    linha()
    print(f"==    Projeto Modulo 1   ver. {versao}    ==")
    print(f"==    Autor.: Adriano A. Carvalho    ==")
    print(f"==    Data..: 29/01/2022             ==")
    linha()
    print()
    print(f"             MENU PRINCIPAL ")
    linha()
    print()

def msg_erro(msg):
    print(f"ERRO.: {msg}")
    opcao = input("Continuar? (S/N) ")
    if opcao.upper() == "S":
        return True
    else: 
        return False

def msg_info():
    opcao = input("Pressione qualquer tecla para continuar. ")
    if opcao.upper() == "S":
        return True
    else: 
        return False

def fim_de_programa():
    limpa_tela()
    linha()
    print(f"==          FIM DE PROGRAMA          ==")
    linha()

def valida_opcao(opcao, dados):
    titulo = None
    retorno = []
    verifica = True


    if opcao == 1: 
        titulo = "CATEGORIAS"
        retorno = listar_categorias(dados)
    elif opcao == 2: 
        titulo = "PRODUTOS DA CATEGORIA"      
        while verifica:
            categoria = input("Digite a categoria: ")
            if categoria.lower() in listar_categorias(dados):
                verifica = False
                retorno = listar_por_categoria(dados, categoria)
            else: 
                verifica = msg_erro("Categoria inválida")
                          
    elif opcao == 3:
        titulo = "PRODUTO MAIS CARO POR CATEGORIA"
        while verifica:
            categoria = input("Digite a categoria: ")
            if categoria.lower() in listar_categorias(dados):
                verifica = False
                retorno = produto_mais_caro(dados, categoria)
            else: 
                verifica = msg_erro("Categoria inválida")
        
    elif opcao == 4:     
        titulo = "PRODUTO MAIS BARATO POR CATEGORIA"
        while verifica:
            categoria = input("Digite a categoria: ")
            if categoria.lower() in listar_categorias(dados):
                verifica = False
                retorno = produto_mais_barato(dados, categoria)
            else: 
                verifica = msg_erro("Categoria inválida")

    elif opcao == 5:    
        titulo = "TOP 10 PRODUTOS MAIS CAROS" 
        retorno = top_10_caros(dados)
    elif opcao == 6:
        titulo = "TOP 10 PRODUTOS MAIS BARATOS"
        retorno = top_10_baratos(dados)     
    elif opcao == 0:
        pass                 
    else:
        if msg_erro("Opcao Invalida"):
            opcao = None
        else:
            opcao = 0 

    return opcao, retorno, titulo


def mostrar_retorno(opcao, titulo, lista):
    indice = 1 
    print()
    print(f"RELATÓRIO.: {titulo}")
    linha()
    if opcao in (3, 4):
        print(lista)
    elif opcao in (5, 6):
        for i in lista:
            print(i)
    else:
        for i in lista:
            if type(i) == str:
                print(f"{indice}. {i.capitalize()}")
            else:
                print(f"{indice}. {i}")

            indice += 1


# Programa Principal - não modificar!
d = obter_dados()
menu(d)
