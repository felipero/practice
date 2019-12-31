package felipero.codility.arrays

object CycleRotation {
  def rotate(arr: Array[Int], positionsToRotate: Int): Array[Int] = {
    if(arr.isEmpty || arr.size == 1)
      return arr

    val arrSize = arr.length
    val result: Array[Int] = new Array[Int](arrSize)

    val k = if(positionsToRotate > arrSize) positionsToRotate % arrSize else positionsToRotate

    for(n <- 0 to arrSize/2) {
      val newIdx = if ((n+k) > arrSize-1) (n+k-(arrSize)) else n+k
      result(newIdx) = arr(n)

      val endIdx = (arrSize-(n+1))

      val newOtherIdx = if((endIdx+k) > arrSize-1) (endIdx+k-(arrSize)) else endIdx+k
      result(newOtherIdx) = arr(endIdx)
    }

    return result
  }
}

