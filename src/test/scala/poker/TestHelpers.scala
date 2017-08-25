package poker

object TestHelpers {
  // Hands
  val royalFlush = Hand("TC", "JC", "QC", "KC", "AC")
  val royalFlushMixed = Hand("JC", "TC", "AC", "QC", "KC")

  val straightFlush = Hand("8C", "9C", "TC", "JC", "QC")
  val straightFlushMixed = Hand("TC", "8C", "QC", "JC", "9C")

  val straight = Hand("7S", "8H", "9S", "TH", "JC")
  val straightMixed = Hand("TH", "7S", "9S", "JC", "8H")

  val twoPair = Hand("KC", "KS", "AC", "AS", "6D")

  val highCard = Hand("AS", "5D", "8H", "TC", "3H")

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
  val highCardStatus = HandStatus(HandType.HighCard, Kickers(highCard.sorted))
}
