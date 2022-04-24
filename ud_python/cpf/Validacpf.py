def cabecalho(titulo, separador):
    print("{:*<50}".format(separador))
    print(f"{titulo: ^50}")
    print("{:*<50}".format(separador))
    print()


linha = "*"
titulo = "Valida CPF"
cabecalho(titulo, linha)


while True:
    cpf = input("Digite seu CPF(s - para sair):  ")

    if cpf.lower() == "s":
        break

    novoCPF = ""
    contador = 0

    while contador <  len(cpf):
      caracter = cpf[contador]

      if caracter.isnumeric():
         novoCPF += cpf[contador]

      contador += 1

    #print(novoCPF)

    acumulador = 0

    if len(novoCPF) == 11:
        for p, r in enumerate(range(10, 1, -1)):
            #print(novoCPF[p], r)
            acumulador += int(novoCPF[p]) * r

        digito1 = (11 - (acumulador % 11))
        digito1 = 0 if (digito1 > 9) else digito1

        acumulador = 0
        for p, r in enumerate(range(11, 1, -1)):
            #print(novoCPF[p], r)
            if r == 2:
                acumulador += digito1 * r
            else:
                acumulador += int(novoCPF[p]) * r

        digito2 = (11 - (acumulador % 11))

    else:
        continue


    resultado = novoCPF[:9] + str(digito1) + str(digito2)

    #print(resultado)

    if resultado == novoCPF:
        print("CPF Válido!!")
    else:
        print("CPF invalido!!")

else:
    print("Programa encerrado")






