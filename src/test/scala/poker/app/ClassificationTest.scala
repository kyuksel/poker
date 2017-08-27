package poker.app

import org.scalatest.FunSuite
import poker.app.Classification._
import poker.core.HandType.RoyalFlush
import poker.core.HandStatus
import poker.TestHelpers._

final class ClassificationTest extends FunSuite {
  test("doMain") {
    assert(doMain(royalFlushStrArray) === HandStatus(RoyalFlush))
  }
}