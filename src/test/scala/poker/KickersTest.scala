package poker

import org.scalatest.FunSuite
import poker.core.Kickers

final class KickersTest extends FunSuite {
  test("toString") {
    val kickerQS = s"""kicker "QS""""
    val kickers7DQS = s"""kickers "7D", "QS""""

    assert(Kickers("QS").toString === kickerQS)
    assert(Kickers("7D", "QS").toString === kickers7DQS)
  }

  test("compare") {
    import TestHelpers._

    assert(aceCKicker > queenCKicker)
    assert(queenCKicker === queenCKicker)
    assert(Kickers("7D", "8H") < Kickers("2C", "TS"))
  }
}
