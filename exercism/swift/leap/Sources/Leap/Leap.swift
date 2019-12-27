struct Year {
  let calendarYear: Int

  func isLeapYear() -> Bool {
    return calendarYear.isMultiple(of: 4) && (!calendarYear.isMultiple(of: 100) || calendarYear.isMultiple(of: 400))
  }
}
