'''
Classe.....: Matrix()
Autor......: Adriano A. Carvalho
Data.......: 13/03/2022
Versão.....: 2.0
'''

class matrix:
    def __init__(self, qtd_linhas, qtd_colunas):
        self.linhas = qtd_linhas
        self.colunas = qtd_colunas
        self.matrix = [[0]*qtd_linhas for i in range(qtd_colunas)]

    def linha(self):
        print("-----------------------------")

    def mostra(self):
        self.linha()
        print('Status da matrix:')
        for i in range(self.linhas):
            print(self.matrix[i])
        
        self.linha()
        qtd_rios, comprimento_rios = self.contagem(1)
        print("A quantidade de Rios.:", qtd_rios)
        print("O comprimento dos Rios.:", comprimento_rios)
        self.linha()
        qtd_ilhas, comprimento_ilhas = self.contagem(0)
        print("A quantidade de Ilhas.:", qtd_ilhas)
        print("O comprimento das Ilhas.:", comprimento_ilhas)
        
        return self.matrix

    def add(self, linha, coluna):
        self.matrix[linha][coluna] = 1  
    
    #para procurar rio = 1 ilha = 0
    def contagem(self, ilha:int) -> list():
        if not self.matrix:
            return None
         
            
        lista_tamanho = []
        visitado = set()
        contador = 0

                        
        def bfs(l, c):
            contador_tamanho = 1
            q = []
            visitado.add((l, c))
            q.append((l, c))
            while q:
                linha, coluna = q.pop(0)
                direcoes = [[1,0], [-1,0], [0, 1], [0, -1]]
                for dl, dc in direcoes:
                    l, c = linha + dl, coluna + dc
                    if (l in range(self.linhas) and c in range(self.colunas) and
                        self.matrix[l][c] == ilha and (l, c) not in visitado):
                        q.append((l,c))
                        visitado.add((l,c))
                        contador_tamanho += 1
            return contador_tamanho 


        for i in range(self.linhas):
            for j in range(self.colunas):
                if self.matrix[i][j] == ilha and (i, j) not in visitado:
                    lista_tamanho.append(bfs(i,j)) 
                    contador += 1
        return contador, lista_tamanho

    

def grafo_to_matrix(grafo = list()):
    linhas = len(grafo)
    colunas = len(grafo)
    matriz = matrix(linhas, colunas)
    contador = 0
    for i in grafo:
        for j in i:
            matriz.add(contador, j)
        contador += 1
    return matriz


def matrix_to_grafo(matriz = matrix):
    lista = matriz.matrix
    grafo = []
    linha = []
    
    for i in lista:
        contador = 0
        linha = []
        for j in i:
            if j == 1:
                linha.append(contador)        
            contador += 1
        grafo.append(linha)        

    return grafo



#TESTES

grafo = [                   # 1, 2, 1, 1, 1, 1
          [1],           
          [2, 3],        
          [1, 3, 4],      
          [],           
          [1]           
        ]


matrix1 = matrix(5,5)
matrix1.matrix = [
    [1, 0, 0, 0, 0],
    [1, 1, 1, 1, 1],
    [1, 0, 0, 0, 0],
    [1, 0, 0, 0, 0],
    [1, 0, 0, 0, 1],
]

matrix1.mostra()


m1 = grafo_to_matrix(grafo)
m1.mostra()

matrix2 = matrix(5,5)
matrix2.matrix = [
    [1, 0, 0, 1, 0],
    [1, 0, 1, 0, 0],
    [0, 0, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 0],
]

matrix2.mostra()



