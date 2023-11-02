import java.util.Scanner


fun showStart()
{
    println("Добро пожаловать в игру 'Угадай число'!")
    println("Правила игры:")
    println("1. Компьютер загадает случайное число от 1 до 100")
    println("2. Задача игрока - угадать это число.")
}

fun main()
{
    val scanner = Scanner(System.`in`)
    val scores = mutableListOf<Int>()

    showStart()

    var playAgain = true

    while (playAgain)
    {
        val numberToGuess = (1..100).random()
        var attempts = 0
        var guess = 0
        var hasGuessed = false

        println("Компьютер загадал число. Попробуйте угадать!")

        while (!hasGuessed)
        {
            print("Введите вашу догадку: ")
            guess = scanner.nextInt()
            attempts++

            when
            {
                guess < numberToGuess -> println("Загаданное число больше.")
                guess > numberToGuess -> println("Загаданное число меньше.")
                else ->
                {
                    println("Поздравляем! Вы угадали число $numberToGuess за $attempts попыток.")
                    scores.add(attempts)
                    hasGuessed = true
                }
            }
        }

        print("Хотите сыграть еще раз? (да/нет): ")
        val playAgainInput = scanner.next()

        if (playAgainInput.equals("нет", ignoreCase = true))
        {
            playAgain = false
        }
    }

    println("Ваши результаты игры:")
    for (i in 0 until scores.size)
    {
        println("Игра ${i + 1}: ${scores[i]} попыток")
    }

    println("Спасибо за игру!")
}