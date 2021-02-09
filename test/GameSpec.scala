import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec

class GameSpec extends PlaySpec with MockitoSugar {

  trait Context {
    val game: Game = new Game
  }

  "each game" should {
    "start with zero score" in new Context {
      game.score mustBe 0
    }

    "calculate score step by step - one roll not strike" in new Context {
      game.roll(5)
      game.score mustBe 5
    }

    "calculate score step by step - two roll not spare" in new Context {
      game.roll(3)
      game.score mustBe 3
      game.roll(4)
      game.score mustBe 7
    }

    "calculate score step by step - strike and then neither strike nor spare" in new Context {
      game.roll(10)
      game.score mustBe 10
      game.roll(3)
      game.score mustBe 13
      game.roll(4)
      game.score mustBe 24
    }

    "calculate score step by step - strike and then strike again" in new Context {
      game.roll(10)
      game.score mustBe 10
      game.roll(10)
      game.score mustBe 30
    }

    "calculate score step by step - strike and then spare" in new Context {
      game.roll(10)
      game.score mustBe 10
      game.roll(5)
      game.score mustBe 15
      game.roll(5)
      game.score mustBe 30
    }

    "calculate score step by step - spare and then neither strike nor spare" in new Context {
      game.roll(5)
      game.score mustBe 5
      game.roll(5)
      game.score mustBe 10
      game.roll(3)
      game.score mustBe 13
      game.roll(4)
      game.score mustBe 20
    }

    "calculate score step by step - spare and then spare again" in new Context {
      game.roll(5)
      game.score mustBe 5
      game.roll(5)
      game.score mustBe 10
      game.roll(5)
      game.score mustBe 15
      game.roll(5)
      game.score mustBe 25
    }

    "calculate score step by step - spare and then strike" in new Context {
      game.roll(5)
      game.score mustBe 5
      game.roll(5)
      game.score mustBe 10
      game.roll(10)
      game.score mustBe 30
    }

    "calculate score step by step - all strike" in new Context {
      // frame-1
      game.roll(10)
      game.score mustBe 10
      // frame-2
      game.roll(10)
      game.score mustBe 30
      // frame-3
      game.roll(10)
      game.score mustBe 50
      // frame-4
      game.roll(10)
      game.score mustBe 70
      // frame-5
      game.roll(10)
      game.score mustBe 90
      // frame-6
      game.roll(10)
      game.score mustBe 110
      // frame-7
      game.roll(10)
      game.score mustBe 130
      // frame-8
      game.roll(10)
      game.score mustBe 150
      // frame-9
      game.roll(10)
      game.score mustBe 170
      // frame-10
      game.roll(10)
      game.score mustBe 180
      game.roll(10)
      game.score mustBe 200
    }

    "calculate score step by step - all spare" in new Context {
      // frame-1
      game.roll(1)
      game.score mustBe 1
      game.roll(9)
      game.score mustBe 10
      // frame-2
      game.roll(2)
      game.score mustBe 12
      game.roll(8)
      game.score mustBe 22
      // frame-3
      game.roll(3)
      game.score mustBe 25
      game.roll(7)
      game.score mustBe 35
      // frame-4
      game.roll(4)
      game.score mustBe 39
      game.roll(6)
      game.score mustBe 49
      // frame-5
      game.roll(5)
      game.score mustBe 54
      game.roll(5)
      game.score mustBe 64
      // frame-6
      game.roll(6)
      game.score mustBe 70
      game.roll(4)
      game.score mustBe 80
      // frame-7
      game.roll(7)
      game.score mustBe 87
      game.roll(3)
      game.score mustBe 97
      // frame-8
      game.roll(8)
      game.score mustBe 105
      game.roll(2)
      game.score mustBe 115
      // frame-9
      game.roll(9)
      game.score mustBe 124
      game.roll(1)
      game.score mustBe 134
      // frame-10
      game.roll(5)
      game.score mustBe 139
      game.roll(5)
      game.score mustBe 144
      game.roll(5)
      game.score mustBe 154
    }

    "calculate score step by step - neither strike nor spare" in new Context {
      // frame-1
      game.roll(0)
      game.score mustBe 0
      game.roll(9)
      game.score mustBe 9
      // frame-2
      game.roll(1)
      game.score mustBe 10
      game.roll(8)
      game.score mustBe 18
      // frame-3
      game.roll(2)
      game.score mustBe 20
      game.roll(7)
      game.score mustBe 27
      // frame-4
      game.roll(3)
      game.score mustBe 30
      game.roll(6)
      game.score mustBe 36
      // frame-5
      game.roll(4)
      game.score mustBe 40
      game.roll(5)
      game.score mustBe 45
      // frame-6
      game.roll(5)
      game.score mustBe 50
      game.roll(4)
      game.score mustBe 54
      // frame-7
      game.roll(6)
      game.score mustBe 60
      game.roll(3)
      game.score mustBe 63
      // frame-8
      game.roll(7)
      game.score mustBe 70
      game.roll(2)
      game.score mustBe 72
      // frame-9
      game.roll(8)
      game.score mustBe 80
      game.roll(1)
      game.score mustBe 81
      // frame-10
      game.roll(9)
      game.score mustBe 90
      game.roll(0)
      game.score mustBe 90
    }

    "sample-test" in new Context {
      // frame-1
      game.roll(1)
      game.roll(4)
      // frame-2
      game.roll(4)
      game.roll(5)
      // frame-3
      game.roll(6)
      game.roll(4)
      // frame-4
      game.roll(5)
      game.roll(5)
      // frame-5
      game.roll(10)
      // frame-6
      game.roll(0)
      game.roll(1)
      // frame-7
      game.roll(7)
      game.roll(3)
      // frame-8
      game.roll(6)
      game.roll(4)
      // frame-9
      game.roll(10)
      // frame-10
      game.roll(2)
      game.roll(8)
      game.roll(6)

      game.score mustBe 133
    }

  }

}
