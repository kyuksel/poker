package poker.handanalyzer

import poker.{Hand, HandType, Kickers}

final class StraightAnalyzer extends HandAnalyzer {
  override def doAnalyze(hand: Hand): (Option[HandType], Option[Kickers]) = ???
}
