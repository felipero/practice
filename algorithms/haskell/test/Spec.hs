{-# LANGUAGE TemplateHaskell #-}

import Test.QuickCheck
import Data.Array;
import BinarySearch


prop_search :: Int -> Bool
prop_search target = search (listArray (1,12) [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]) target 1 11 == target

return []
check = $quickCheckAll

main = check
