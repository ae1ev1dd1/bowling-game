class Game() {

  private val frames: Array[Frame] = new Array[Frame](10)
  private var currentFrameIndex: Int = 0;

  def roll(pins: Int): Unit =
    if (isNewFrame) {
      frames(currentFrameIndex) = Frame(firstRoll = pins, secondRoll = None, bonus = None)
      if (canCloseFrame) closeFrame()
    } else {
      if (isLastFrame) {
        if (isLastFrameBonus) {
          frames(currentFrameIndex) = frames(currentFrameIndex).copy(bonus = Some(pins))
          closeFrame()
        } else {
          frames(currentFrameIndex) = frames(currentFrameIndex).copy(secondRoll = Some(pins))
          if (!frames(currentFrameIndex).isSpare) closeFrame()
        }
      } else {
        frames(currentFrameIndex) = frames(currentFrameIndex).copy(secondRoll = Some(pins))
        closeFrame()
      }
    }

  private def canCloseFrame: Boolean = currentFrameIndex != 9 && frames(currentFrameIndex).isStrike

  private def isNewFrame: Boolean = frames(currentFrameIndex) == null

  private def isLastFrame: Boolean = currentFrameIndex == 9

  private def isLastFrameBonus: Boolean = currentFrameIndex == 9 && (frames(currentFrameIndex).isStrike || frames(currentFrameIndex).isSpare)

  private def closeFrame(): Unit = {
    updatePreviousFrameBonus()
    currentFrameIndex += 1
  }

  private def updatePreviousFrameBonus(): Unit = {
    if (!isFirstFrame) {
      val previousFrame = frames(currentFrameIndex - 1)
      val currentFrame = frames(currentFrameIndex)
      if (previousFrame.isStrike)
        updatePreviousFrameBonus(currentFrame.firstRoll + currentFrame.secondRoll.getOrElse(0))
      else if (previousFrame.isSpare)
        updatePreviousFrameBonus(currentFrame.firstRoll)
      else
        updatePreviousFrameBonus(bonus = 0)
    }
  }

  private def updatePreviousFrameBonus(bonus: Int): Unit = {
    frames(currentFrameIndex - 1) = frames(currentFrameIndex - 1).copy(bonus = Some(bonus))
  }

  private def isFirstFrame: Boolean = currentFrameIndex == 0

  def score: Int = {
    var result = 0
    //    frames.map(_.score).sum
    for (frame <- frames)
      if (frame != null)
        result += frame.score
    result
  }

}
