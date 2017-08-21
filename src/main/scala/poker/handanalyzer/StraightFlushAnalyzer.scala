package poker.handanalyzer

import poker.{Hand, HandType, Kickers}

final class StraightFlushAnalyzer extends HandAnalyzer {
  override def doAnalyze(hand: Hand): (Option[HandType], Option[Kickers]) = ???
}
