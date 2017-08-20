package poker

object TestHelpers {
  val royalFlush = Hand.fromStrings(Traversable("TC", "JC", "QC", "KC", "AC"))
  val royalFlushMixed = Hand.fromStrings(Traversable("JC", "TC", "AC", "QC", "KC"))

  val straight = Hand.fromStrings(Traversable("7S", "8H", "9S", "TH", "JC"))
  val straightMixed = Hand.fromStrings(Traversable("TH", "7S", "9S", "JC", "8H"))

  val twoPair = Hand.fromStrings(Traversable("KC", "KS", "AC", "AS", "6D"))  
}
