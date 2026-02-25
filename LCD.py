def gcd(a, b):
    """Recursive GCD function"""
    if b == 0:
        return a
    return gcd(b, a % b)


def lcm(a, b):
    """Compute LCM using GCD"""
    return (a * b) // gcd(a, b)


def get_valid_int(prompt):
    """Safe input: keeps asking until user enters a positive integer"""
    while True:
        try:
            value = int(input(prompt))
            if value <= 0:
                print("Value must be positive.")
                continue
            return value
        except ValueError:
            print("Invalid input. Please enter an integer.")


def compute_lcd(count, current_lcd):
    """Recursive LCD computation"""
    if count == 0:
        return current_lcd
    next_den = get_valid_int("Enter next denominator: ")
    new_lcd = lcm(current_lcd, next_den)
    return compute_lcd(count - 1, new_lcd)


def main():
    num_denominators = get_valid_int("How many denominators? ")
    first = get_valid_int("Enter denominator 1: ")

    lcd = compute_lcd(num_denominators - 1, first)
    print(f"The LCD is: {lcd}")


if __name__ == "__main__":
    main()