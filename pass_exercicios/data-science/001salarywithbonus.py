'''
Make a program that reads a seller's name, his/her fixed salary and the sale's total 
made by himself/herself in the month (in money). Considering that this seller receives 
15% over all products sold, write the final salary (total) of this seller at the end of
the month , with two decimal places.

- Don’t forget to print the line's end after the result, otherwise you will receive “Presentation Error”.

- Don’t forget the blank spaces.

Input
The input file contains a text (employee's first name), and two double precision values, that are the seller's salary and the total value sold by him/her.

Output
Print the seller's total salary, according to the given example.
'''

'''
Programa.: 001salarywithbonus.py
Objetivo.: No Desafio um Degrau 24.03.2022
Autor....: Adriano A. Carvalho
Data.....: 24/03/2022
'''
from decimal import Rounded


seller = input("Enter seller`s name:")
salary = float(input("Enter fixed salary.:"))
total_sales = float(input("Enter total sales.: "))

total_salary = salary + (total_sales * 0.15)

print(f"TOTAL = {total_salary:.2f}")