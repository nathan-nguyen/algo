import scala.collection.mutable.Stack

object Solution {
  def isValid(s: List[Char], stack: Stack[Char]): Boolean = s match {
    case Nil => stack.isEmpty
    case ')'::tail => stack.size > 0 && stack.pop == '(' && isValid(tail, stack)
    case ']'::tail => stack.size > 0 && stack.pop == '[' && isValid(tail, stack)
    case '}'::tail => stack.size > 0 && stack.pop == '{' && isValid(tail, stack)
    case c::tail => stack.push(c); isValid(tail, stack)
  }

  def isValid(s: String): Boolean = isValid(s.toList, Stack[Char]())
}

