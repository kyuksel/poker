package poker

import org.scalatest.FunSuite
import TestHelpers._

final class HandStatusTest extends FunSuite {
  test("sameAs") {
    assert(straightFlushWithJackKickerStatus sameAs HandStatus(
      Some(HandType.StraightFlush),
      Some(Kickers(Card("JC")))))

    assert(straightFlushWithJackKickerStatus notSameAs HandStatus(
      Some(HandType.StraightFlush),
      Some(Kickers.fromString(List("JC", "8H")))))

    assert(straightFlushWithJackKickerStatus notSameAs HandStatus(
      Some(HandType.StraightFlush),
      None))

    assert(straightFlushWithJackKickerStatus notSameAs HandStatus(
      None,
      Some(Kickers(Card("JC")))))

    assert(HandStatus.none sameAs HandStatus())
  }
}
