def factorial_recursive(n):
    """
    Calculates factorial recursively.
    Base case: 0! = 1
    Recursive step: n! = n * (n-1)!
    """
    if n == 0:  # Base case
        return 1

    # Calculate previous factorial first
    previous_factorial = factorial_recursive(n - 1)
    
    # Multiply by current number
    current_factorial = n * previous_factorial
    
    
    print(f"factorial({n}) = {n} * factorial({n-1}) = {current_factorial}")
    
    return current_factorial

def main():
    try:
        number = int(input("Enter a non-negative integer: "))
        if number < 0:
            print("Negative numbers are not allowed.")
            return

        print(f"Calculating factorial of {number}...")
        factorial_value = factorial_recursive(number)
        print(f"The factorial of {number} is {factorial_value}")

    except ValueError:
        print("Invalid input! Please enter an integer.")

if __name__ == "__main__":
    main()

