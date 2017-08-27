package poker

import org.scalatest.FunSuite
import Classification._
import TestHelpers._
import poker.core.HandType.RoyalFlush
import poker.core.HandStatus

final class ClassificationTest extends FunSuite {
  test("doMain") {
    assert(doMain(royalFlushStrArray) === HandStatus(RoyalFlush))
  }
}
