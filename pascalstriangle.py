
memo = {} # memo storage 

def get_val(r, c):
    # Base cases
    if c == 0 or c == r:
        return 1
    
    # memoization
    if (r, c) not in memo:
        memo[(r, c)] = get_val(r - 1, c - 1) + get_val(r - 1, c)
    
    return memo[(r, c)]

def show_pascal(total, current=0):
    if current == total:
        return
    
    #spacing
    spaces = " " * (total - current)
    
    # list comprehension
    row_values = [str(get_val(current, i)) for i in range(current + 1)]
    
    print(spaces + " ".join(row_values))
    
    # Move to next row
    show_pascal(total, current + 1)

# Main
num = int(input("Enter rows: "))
show_pascal(num)