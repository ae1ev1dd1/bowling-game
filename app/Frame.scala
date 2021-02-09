case class Frame(firstRoll: Int, secondRoll: Option[Int], bonus: Option[Int]) {

  require(firstRoll >= 0 && firstRoll <= 10, "Invalid Pins Roll")
  require(!secondRoll.exists(_ < 0) && !secondRoll.exists(_ > 10), "Invalid Pins Roll")
  require(!bonus.exists(_ < 0) && !bonus.exists(_ > 10), "Invalid Pins Roll")
  require(firstRoll + secondRoll.getOrElse(0) <= 10, "Invalid Pins Roll")

  def isStrike: Boolean = firstRoll == 10

  def isSpare: Boolean = firstRoll < 10 && firstRoll + secondRoll.getOrElse(0) == 10

  def score: Int = firstRoll + secondRoll.getOrElse(0) + bonus.getOrElse(0)
}
