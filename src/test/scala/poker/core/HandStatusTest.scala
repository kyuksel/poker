package poker.core

import org.scalatest.FunSuite
import poker.TestHelpers._

final class HandStatusTest extends FunSuite {
  test("compare") {
    assert(straightFlushWithQueenKickerStatus === HandStatus(
      Some(HandType.StraightFlush),
      Some(Kickers("QC"))))

    assert(straightFlushWithQueenKickerStatus !== HandStatus(
      Some(HandType.StraightFlush),
      Some(Kickers("QC", "8H"))))

    assert(straightFlushWithQueenKickerStatus !== HandStatus(
      Some(HandType.StraightFlush),
      None))

    assert(straightFlushWithQueenKickerStatus !== HandStatus(
      None,
      Some(Kickers("QC"))))

    assert(HandStatus.none === HandStatus())

    assert(royalFlushStatus > straightFlushWithQueenKickerStatus)
    assert(straightFlushWithTwoKickerStatus < straightFlushWithQueenKickerStatus)
    assert(royalFlushStatus === royalFlushStatus)
  }
}
