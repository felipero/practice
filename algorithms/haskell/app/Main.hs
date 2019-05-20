module Main where

  import Data.Array;
  import BinarySearch
  
  main :: IO ()
  main = do
    let a = search (listArray (1,12) [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]) 9 1 11
    putStrLn (show a)
