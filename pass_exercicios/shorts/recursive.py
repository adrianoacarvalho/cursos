#Write a program to print your name 100 times with a recursive procedure.


def print_name(name, times):
  	
    print(times, name)
    
    if times == 1:
        return 1
    
    return times * print_name(name, times - 1)
  
  
print_name("Name", 100)
