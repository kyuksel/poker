package poker

object TestHelpers {
  // Hands
  val royalFlush = Hand.fromStrings("TC", "JC", "QC", "KC", "AC")
  val royalFlushMixed = Hand.fromStrings("JC", "TC", "AC", "QC", "KC")

  val straightFlush = Hand.fromStrings("8C", "9C", "TC", "JC", "QC")
  val straightFlushMixed = Hand.fromStrings("TC", "8C", "QC", "JC", "9C")

  val straight = Hand.fromStrings("7S", "8H", "9S", "TH", "JC")
  val straightMixed = Hand.fromStrings("TH", "7S", "9S", "JC", "8H")

  val twoPair = Hand.fromStrings("KC", "KS", "AC", "AS", "6D")

  // Kickers
  val queenKicker = Kickers.fromStrings("QC")
  val aceKicker = Kickers.fromStrings("AC")

  // HandStatuses
  val straightFlushWithQueenKickerStatus = HandStatus(HandType.StraightFlush, queenKicker)
}
