filter_array :: Int -> [Int] -> [Int]
filter_array n [] = []
filter_array n (x:xs)
    | x < n = x : filter_array n xs
    | otherwise = filter_array n xs

-- The Input/Output section. You do not need to change or modify this part
main = do
    n <- readLn :: IO Int
    inputdata <- getContents
    let numbers = map read (lines inputdata) :: [Int]
    putStrLn . unlines $ (map show . filter_array n) numbers
