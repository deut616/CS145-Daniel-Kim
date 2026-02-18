found_values = {0: 0, 1: 1}  # Memoization
call_count = 0

def get_fib(n):
    global call_count
    call_count += 1
    if n < 0:
        raise ValueError("Negative input not allowed")
    if n in found_values:
        return found_values[n]
    val = get_fib(n - 1) + get_fib(n - 2)
    found_values[n] = val
    return val

n = int(input("Enter an index for Fibonacci number: "))
result = get_fib(n)
print(f"Fibonacci number at index {n} is: {result}")
print(f"Total calls to get_fib: {call_count}")
