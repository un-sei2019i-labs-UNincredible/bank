#include <iostream>

int division(int a, int b)
{
    return a / b;
}

int substraction(int a, int b)
{
    return a - b;
}

int factorial(int n)
{
    if (n == 0)
    {
        return 1;
    }
    return n * factorial(n - 1);
}

int combinatory(int n, int x)
{
    return factorial(n) / (factorial(x) * factorial(substraction(n, x)));
}

int main(int argc, char const *argv[])
{
    int n, x;

    std::cout << "Please type n: ";
    std::cin >> n;

    std::cout << "Please type x: ";
    std::cin >> x;

    std::cout << "The combinatory(n,x) = " << combinatory(n, x) << std::endl;

    return 0;
}
