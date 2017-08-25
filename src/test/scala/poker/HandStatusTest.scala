package poker

import org.scalatest.FunSuite
import TestHelpers._

final class HandStatusTest extends FunSuite {
  val QC = Card("QC")

  test("sameAs") {
    assert(straightFlushWithQueenKickerStatus isSameAs HandStatus(
      Some(HandType.StraightFlush),
      Some(Kickers(QC))))

    assert(straightFlushWithQueenKickerStatus notSameAs HandStatus(
      Some(HandType.StraightFlush),
      Some(Kickers.fromStrings("QC", "8H"))))

    assert(straightFlushWithQueenKickerStatus notSameAs HandStatus(
      Some(HandType.StraightFlush),
      None))

    assert(straightFlushWithQueenKickerStatus notSameAs HandStatus(
      None,
      Some(Kickers(QC))))

    assert(HandStatus.none isSameAs HandStatus())
  }
}
