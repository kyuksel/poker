package poker

/** Type safety for poker ranks without runtime overhead
  *
  * @param char Poker ranks (2-9, T, J, Q, K, A) where T represents 10
  */
final case class Rank(char: Char) extends AnyVal
