main = do
  n <- getLine
  let m = read n :: Int
  putStrNTimes m "Hello World"


putStrNTimes :: Int -> String -> IO ()
putStrNTimes 0 msg = putStr ""
putStrNTimes n msg = do
  putStrLn msg
  putStrNTimes (n - 1) msg
