# Memoization dictionary- for faster recursion
found_values = {0: 0, 1: 1}

def get_fib(num):
    if num < 0:
        return "Not possible"
    
    # Check if we already did the math
    if num in found_values:
        return found_values[num]
    
    #  Recursion
    val = get_fib(num - 1) + get_fib(num - 2)
    found_values[num] = val
    return val

# --- Test ---
user_num = int(input("Which fibonacci number do you need? "))
print(f"The answer is {get_fib(user_num)}")