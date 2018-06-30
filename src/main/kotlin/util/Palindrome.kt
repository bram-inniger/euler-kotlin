package util

tailrec fun isPalindrome(list: List<Any>): Boolean = when {
    list.size <= 1 -> true
    list[0] != list[list.lastIndex] -> false
    else -> isPalindrome(list.subList(1, list.lastIndex))
}
