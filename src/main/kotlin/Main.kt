package tictactoe

fun main() {
    val table: Array<Array<Char>> = Array(3) { Array(3) { ' ' } }
    val digits = ('0'..'9').joinToString("")
    var moves = 0

    printTable(table)

    while (true) {
        val (rows, cols) = readln().split(" ")

        if (rows !in digits || cols !in digits) {
            println("You should enter numbers!")
            continue
        } else if (rows.toInt() !in 1..3 || cols.toInt() !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            continue
        } else if (table[rows.toInt() - 1][cols.toInt() - 1] != ' ') {
            println("This cell is occupied! Choose another one!")
            continue
        } else {
            moves++
            if (moves % 2 != 0) {
                table[rows.toInt() - 1][cols.toInt() - 1] = 'X'
            } else {
                table[rows.toInt() - 1][cols.toInt() - 1] = 'O'
            }

            printTable(table)

            if (moves >= 5) {
                val strX = winner(table, 'X')
                val strO = winner(table, 'O')

                if (strX) {
                    println("X wins")
                    break
                } else if (strO) {
                    println("O wins")
                    break
                } else if (moves == 9) {
                    println("Draw")
                    break
                }
            }
            continue
        }
    }
}

fun printTable(table: Array<Array<Char>>) {
    println("---------")
    for (row in table) {
        print("| ")
        for (cell in row) {
            print("$cell ")
        }
        println("|")
    }
    println("---------")
}

fun winner(table: Array<Array<Char>>, player: Char): Boolean {
    if (
        (table[0][0] == player && table[0][1] == player && table[0][2] == player) ||
        (table[1][0] == player && table[1][1] == player && table[1][2] == player) ||
        (table[2][0] == player && table[2][1] == player && table[2][2] == player) ||
        (table[0][0] == player && table[1][0] == player && table[2][0] == player) ||
        (table[0][1] == player && table[1][1] == player && table[2][1] == player) ||
        (table[0][2] == player && table[1][2] == player && table[2][2] == player) ||
        (table[0][0] == player && table[1][1] == player && table[2][2] == player) ||
        (table[0][2] == player && table[1][1] == player && table[2][0] == player)
    ) {
        return true
    }

    return false
}