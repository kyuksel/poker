package poker

object TestHelpers {
  // Hands
  val royalFlush = Hand.fromStrings(Traversable("TC", "JC", "QC", "KC", "AC"))
  val royalFlushMixed = Hand.fromStrings(Traversable("JC", "TC", "AC", "QC", "KC"))

  val straightFlush = Hand.fromStrings(Traversable("8C", "9C", "TC", "JC", "QC"))
  val straightFlushMixed = Hand.fromStrings(Traversable("TC", "8C", "QC", "JC", "9C"))

  val straight = Hand.fromStrings(Traversable("7S", "8H", "9S", "TH", "JC"))
  val straightMixed = Hand.fromStrings(Traversable("TH", "7S", "9S", "JC", "8H"))

  val twoPair = Hand.fromStrings(Traversable("KC", "KS", "AC", "AS", "6D"))

  // Kickers
  val jackKicker = Kickers.fromString("JC")
  val queenKicker = Kickers.fromString("QC")
  val aceKicker = Kickers.fromString("AC")

  // HandStatuses
  val straightFlushWithJackKickerStatus = HandStatus(HandType.StraightFlush, jackKicker)
}
