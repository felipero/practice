leap <- function(year) {
  if(year %% 4 != 0)
    return(FALSE)
  else if (year %% 100 == 0 && year %% 400 != 0)
    return(FALSE)

  TRUE
}
