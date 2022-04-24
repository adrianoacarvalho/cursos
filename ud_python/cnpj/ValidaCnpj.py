"""
REGRAS:
04.252.011/0001-10 40.688.134/0001-61 71.506.168/0001-11 12.544.992/0001-05

0   4   2   5   2   0   1   1   0   0   0   1
5   4   3   2   9   8   7   6   5   4   3   2
0   16  6   10  18  0   7   6   0   0   0   2 = 65
Fórmula -> 11 - (65 % 11) = 1
Primeiro digito = 1 (Se o digito for maior que 9, ele se torna 0)

0   4   2   5   2   0   1   1   0   0   0   1   1   X
6   5   4   3   2   9   8   7   6   5   4   3   2
0   20  8   15  4   0   8   7   0   0   0   3   2 = 67
Fórmula -> 11 - (67 % 11) = 10 (Como o resultado é maior que 9, então é 0)
Segundo digito = 0

Novo CNPJ + Digitos = 04.252.011/0001-10
CNPJ Original =       04.252.011/0001-10
Válido

Recap.
543298765432 -> Primeiro digito
6543298765432 -> Segunro digito
"""
def validaCnpj(cnpj):
    if (len(cnpj) != 14) or not cnpj.isnumeric():  #verifica tamanho da string e se é numérico, importante aumentar o nível de validação
        raise ValueError('CNPJ deve ter 14 números!')
  
    primeiro_calculo = [5,4,3,2,9,8,7,6,5,4,3,2]   #lista padrão para o primeiro calculo
    segundo_calculo = [6,5,4,3,2,9,8,7,6,5,4,3,2]  #lista padrão para o segundo calculo

    cnpjnovo = [int(x) for x in cnpj[:12]]  #converto os primeiros 12 digitos do cnpj digitado em inteiro para facilitar o calculo

    total_calculo1 = sum(list(map(lambda x,y: x * y, cnpjnovo, primeiro_calculo))) #uso o map para multiplicar os numeros do cnpj com a lista padrao do primeiro calculo

    primeiro_digito =  abs(11 - (total_calculo1 % 11)) #calculo o valor absoluto para encontrar o primeiro digito
    
    if primeiro_digito > 9: #regra se o primeiro digito for maior que 9 ele automaticamente será 0
        primeiro_digito = 0

    cnpjnovo.append(primeiro_digito) #adiciono o primeiro digito calculado a lista para o segundo calculo.

    total_calculo2 = sum(list(map(lambda x,y: x * y, cnpjnovo, segundo_calculo))) #Mesma formula do primeiro calculo 
    segundo_digito =  abs(11 - (total_calculo2 % 11))
    if segundo_digito > 9:
        segundo_digito = 0
   
    cnpjnovo.append(segundo_digito)

    strcnpjnovo = ''

    for i in cnpjnovo:
        strcnpjnovo += str(i)  #transformo o cnpj calculado para string


    if cnpj == strcnpjnovo: #verifico se é igual ao digitado.
        return True #CNPJ Válido
    
    return False #CNPJ Inválido


#inicio do programa

while True:
    cnpj = input("Digite seu CNPJ(s - para sair):  ")

    if cnpj.lower() == "s":
         break

    if validaCnpj(cnpj):
        print("CNPJ.:", cnpj, " é Válido")
    else: 
         print("CNPJ.:", cnpj, " é inválido")
    
