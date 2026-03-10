void main() {

//region Variables
    int x = 5;
    double sum = 0;
    boolean flag = false;
    int i = 0;
//endregion

//region 4.2.a.
    if (x % 2 == 0) {
        flag = true;
    } else {
        flag = false;
    }

    printState("if", x, sum, flag, i);
//endregion

//region 5.b
    switch (x % 2) {
        case 0:
            flag = true;
            break;
        case 1:
            flag = false;
            break;
        default:
            flag = false;
            break;
    }

    printState("switch", x, sum, flag, i);
//endregion

//region 5.c.
    flag = (x % 2 == 0) ? true : false;

    printState("operador ternário", x, sum, flag, i);
//endregion

//region 5.d.
    flag = (x % 2 == 0);

    printState("atribuição direta", x, sum, flag, i);
//endregion

//region 5.e.
    sum = 0;
    for (i = 1; i <= x; i++) {
        if (i == 3) {
            continue;
        }
        sum += i;
    }

    printState("for", x, sum, flag, i);
//endregion

//region 5.f.
    sum = 0;
    i = 1;
//endregion

//region 5.g.
    while (i <= x) {
        sum += i;
        i++;
    }

    printState("while", x, sum, flag, i);
//endregion

//region 5.h
    sum = 0;
    i = 1;
//endregion

//region 5.i
    do {
        sum += i;
        i++;
    } while (i <= x);

    printState("do-while", x, sum, flag, i);
//endregion

    System.out.println("Chô");
}


// 🔹 Função para imprimir o estado das variáveis
void printState(String nome, int x, double sum, boolean flag, int i) {
    System.out.println("Fim do ciclo " + nome);
    System.out.println(" - x -> " + x);
    System.out.println(" - sum -> " + sum);
    System.out.println(" - flag -> " + flag);
    System.out.println(" - i -> " + i);
    System.out.println();
}