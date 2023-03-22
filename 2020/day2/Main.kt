import java.io.File
import java.util.ArrayList

fun checkValidPassword(input: String): Boolean {
    val parts: List<String> = input.split(" ")

    val characterToCheck = parts.get(1)[0]
    val limits = parts[0].split("-").map(String::toInt)

    val frequency = parts[2].count { it == characterToCheck }

    if (frequency >= limits[0] && frequency <= limits[1]) return true
    else return false

}

fun newRuleMapper(input: String): Boolean {
    val parts: List<String> = input.split(" ")

    val characterToCheck = parts.get(1)[0]
    val limits = parts[0].split("-").map(String::toInt)

    val count = limits.count {  parts.get(2)[it - 1] == characterToCheck }

    if (count == 1) return true
    return false

}

fun main() {

    var file = File("./input.txt")

    val passwordInput = file.readLines()

    val count1 = passwordInput.count { checkValidPassword(it) }

    val count2 = passwordInput.count { newRuleMapper(it) }

    println(count1)
    println(count2)

}
