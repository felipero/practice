module BinarySearch ( search ) where
import Data.Array;

search :: Array Int Int -> Int -> Int -> Int -> Int
search haystack needle lo hi
    | hi < lo = -1
    | pivot > needle = search haystack needle lo (mid-1)
    | pivot < needle = search haystack needle (mid+1) hi
    | otherwise = needle
    where
        mid = lo + (hi-lo) `div` 2 :: Int
        pivot = haystack!mid 
