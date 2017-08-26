package poker

object TestHelpers {
  // Hands
  val royalFlushHand = Hand("TC", "JC", "QC", "KC", "AC")
  val royalFlushHandMixed = Hand("JC", "TC", "AC", "QC", "KC")

  val straightFlushHand = Hand("8C", "9C", "TC", "JC", "QC")
  val straightFlushHandMixed = Hand("TC", "8C", "QC", "JC", "9C")

  val fourOfAKindHand = Hand("AS", "AD", "2D", "AC", "AH")

  val straightHand = Hand("7S", "8H", "9S", "TH", "JC")
  val straightHandMixed = Hand("TH", "7S", "9S", "JC", "8H")

  val twoPairHand = Hand("KC", "KS", "AC", "AS", "6D")

  val highCardHand = Hand("AS", "5D", "8H", "TC", "3H")

  // Kickers
  val aceKicker = Kickers("AC")
  val queenKicker = Kickers("QC")
  val sixKicker = Kickers("6D")
  val twoKicker = Kickers("2D")

  // HandStatuses
  val royalFlushStatus = HandStatus(HandType.RoyalFlush)
  val straightFlushWithQueenKickerStatus = HandStatus(HandType.StraightFlush, queenKicker)
  val straightFlushWithTwoKickerStatus = HandStatus(HandType.StraightFlush, twoKicker)
  val twoPairWithSixKickerStatus = HandStatus(HandType.TwoPair, sixKicker)
  val highCardStatus = HandStatus(HandType.HighCard, Kickers(highCardHand.sorted))
}
