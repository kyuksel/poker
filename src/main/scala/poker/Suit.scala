package poker

/** Type safety for poker suits without runtime overhead
  *
  * @param char Poker suits:
  *               H: Heart
  *               C: Club
  *               D: Diamond
  *               S: Spade
  */
final case class Suit(char: Char) extends AnyVal
